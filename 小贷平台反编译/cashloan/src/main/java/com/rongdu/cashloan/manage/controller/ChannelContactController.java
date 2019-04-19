/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.ChannelContact;
/*     */ import com.rongdu.cashloan.cl.model.ChannelContactModel;
/*     */ import com.rongdu.cashloan.cl.model.KeyValue;
/*     */ import com.rongdu.cashloan.cl.service.ChannelContactService;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ChannelContactController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private ChannelContactService channelContactService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/listChannelContact.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelContact(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  58 */     Map<String, Object> searchMap = new HashMap();
/*  59 */     if (!StringUtils.isEmpty(searchParams)) {
/*  60 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*  62 */     Page<ChannelContactModel> page = this.channelContactService.listChannelContact(current, pageSize, searchMap);
/*  63 */     Map<String, Object> result = new HashMap();
/*  64 */     result.put("data", page);
/*  65 */     result.put("page", new RdPage(page));
/*  66 */     result.put("code", Integer.valueOf(200));
/*  67 */     result.put("msg", "查询成功");
/*  68 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/listChannelContactId.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelContactId()
/*     */     throws Exception
/*     */   {
/*  77 */     List<KeyValue> list = this.channelContactService.listChannelContactId();
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     result.put("data", list);
/*  80 */     result.put("code", Integer.valueOf(200));
/*  81 */     result.put("msg", "查询成功");
/*  82 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam("contactId") String contactId, @RequestParam("contactName") String contactName, @RequestParam("userName") String userName, @RequestParam("role") Long role, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/* 106 */     SysUser userinfo = getLoginUser(request);
/* 107 */     SysUser users = this.channelContactService.saveUsers(contactName, userName, role, contactId, userinfo.getName());
/* 108 */     Map<String, Object> result = new HashMap();
/* 109 */     if (users == null) {
/* 110 */       result.put("code", Integer.valueOf(400));
/* 111 */       result.put("msg", "渠道联系人编号已存在");
/*     */     } else {
/* 113 */       Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/* 114 */       boolean flag = this.channelContactService.save(param, users, contactId, contactName, role);
/* 115 */       if (flag) {
/* 116 */         result.put("code", Integer.valueOf(200));
/* 117 */         result.put("msg", "操作成功");
/*     */       } else {
/* 119 */         result.put("code", Integer.valueOf(400));
/* 120 */         result.put("msg", "操作失败");
/*     */       }
/*     */     }
/* 123 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/channelContactDetails.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelContactDetails(@RequestParam("id") Long id)
/*     */     throws ParseException
/*     */   {
/* 134 */     ChannelContact contact = this.channelContactService.channelContactDetails(id);
/*     */     
/* 136 */     List<KeyValue> channelProviderList = this.channelContactService.channelContactList(id);
/* 137 */     Map<String, Object> data = new HashMap();
/* 138 */     data.put("contact", contact);
/* 139 */     data.put("channelProviderList", channelProviderList);
/* 140 */     Map<String, Object> result = new HashMap();
/* 141 */     if (contact != null) {
/* 142 */       result.put("data", data);
/* 143 */       result.put("code", Integer.valueOf(200));
/* 144 */       result.put("msg", "操作成功");
/*     */     } else {
/* 146 */       result.put("code", Integer.valueOf(400));
/* 147 */       result.put("msg", "操作失败");
/*     */     }
/* 149 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/* 167 */     SysUser userinfo = getLoginUser(request);
/* 168 */     Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/* 169 */     boolean flag = this.channelContactService.update(param, id, userinfo.getName());
/* 170 */     Map<String, Object> result = new HashMap();
/* 171 */     if (flag) {
/* 172 */       result.put("code", Integer.valueOf(200));
/* 173 */       result.put("msg", "操作成功");
/*     */     } else {
/* 175 */       result.put("code", Integer.valueOf(400));
/* 176 */       result.put("msg", "操作失败");
/*     */     }
/* 178 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelContact/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channelContact:updateState", name="修改渠道联系人状态")
/*     */   public void updateState(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id, @RequestParam("status") String status)
/*     */   {
/* 193 */     SysUser userinfo = getLoginUser(request);
/* 194 */     Map<String, Object> result = new HashMap();
/* 195 */     Map<String, Object> param = new HashMap();
/* 196 */     param.put("id", id);
/* 197 */     param.put("status", status);
/* 198 */     param.put("updateTime", new Date());
/* 199 */     param.put("updateUser", userinfo.getName());
/* 200 */     int updateState = this.channelContactService.updateState(param);
/* 201 */     if (updateState > 0) {
/* 202 */       result.put("code", Integer.valueOf(200));
/* 203 */       result.put("msg", "提交成功");
/*     */     } else {
/* 205 */       result.put("code", Integer.valueOf(400));
/* 206 */       result.put("msg", "操作失败");
/*     */     }
/*     */     
/* 209 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ChannelContactController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
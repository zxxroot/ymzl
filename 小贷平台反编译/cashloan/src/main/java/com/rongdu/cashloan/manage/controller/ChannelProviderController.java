/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.ChannelProvider;
/*     */ import com.rongdu.cashloan.cl.model.ChannelContactModel;
/*     */ import com.rongdu.cashloan.cl.model.KeyValue;
/*     */ import com.rongdu.cashloan.cl.service.ChannelProviderService;
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
/*     */ public class ChannelProviderController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private ChannelProviderService channelProviderService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/listChannelProvider.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelProvider(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  58 */     Map<String, Object> searchMap = new HashMap();
/*  59 */     if (!StringUtils.isEmpty(searchParams)) {
/*  60 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*  62 */     Page<ChannelContactModel> page = this.channelProviderService.listChannelProvider(current, pageSize, searchMap);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/listChannelProviderId.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelProviderId()
/*     */     throws Exception
/*     */   {
/*  77 */     List<KeyValue> list = this.channelProviderService.listChannelProviderId();
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam("providerId") String providerId, @RequestParam("providerName") String providerName, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/* 102 */     SysUser userinfo = getLoginUser(request);
/* 103 */     Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/* 104 */     boolean flag = this.channelProviderService.save(param, userinfo.getName(), providerId, providerName);
/* 105 */     Map<String, Object> result = new HashMap();
/* 106 */     if (flag) {
/* 107 */       result.put("code", Integer.valueOf(200));
/* 108 */       result.put("msg", "操作成功");
/*     */     } else {
/* 110 */       result.put("code", Integer.valueOf(400));
/* 111 */       result.put("msg", "操作失败");
/*     */     }
/*     */     
/* 114 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/channelProviderDetails.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelProviderDetails(@RequestParam("id") Long id)
/*     */     throws ParseException
/*     */   {
/* 125 */     ChannelProvider provider = this.channelProviderService.channelProviderDetails(id);
/*     */     
/* 127 */     List<KeyValue> channelContactList = this.channelProviderService.channelContactList(id);
/* 128 */     Map<String, Object> data = new HashMap();
/* 129 */     data.put("provider", provider);
/* 130 */     data.put("channelContactList", channelContactList);
/* 131 */     Map<String, Object> result = new HashMap();
/* 132 */     if (provider != null) {
/* 133 */       result.put("data", data);
/* 134 */       result.put("code", Integer.valueOf(200));
/* 135 */       result.put("msg", "操作成功");
/*     */     } else {
/* 137 */       result.put("code", Integer.valueOf(400));
/* 138 */       result.put("msg", "操作失败");
/*     */     }
/* 140 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/* 158 */     SysUser userinfo = getLoginUser(request);
/* 159 */     Map<String, Object> result = new HashMap();
/* 160 */     Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/* 161 */     boolean flag = this.channelProviderService.update(param, id, userinfo.getName());
/* 162 */     if (flag) {
/* 163 */       result.put("code", Integer.valueOf(200));
/* 164 */       result.put("msg", "操作成功");
/*     */     } else {
/* 166 */       result.put("code", Integer.valueOf(400));
/* 167 */       result.put("msg", "操作失败");
/*     */     }
/* 169 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelProvider/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channelProvider:updateState", name="修改渠道联系人状态")
/*     */   public void updateState(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id, @RequestParam("status") String status)
/*     */   {
/* 184 */     SysUser userinfo = getLoginUser(request);
/* 185 */     Map<String, Object> result = new HashMap();
/* 186 */     Map<String, Object> param = new HashMap();
/* 187 */     param.put("id", id);
/* 188 */     param.put("status", status);
/* 189 */     param.put("updateTime", new Date());
/* 190 */     param.put("updateUser", userinfo.getName());
/* 191 */     int updateState = this.channelProviderService.updateState(param);
/* 192 */     if (updateState > 0) {
/* 193 */       result.put("code", Integer.valueOf(200));
/* 194 */       result.put("msg", "提交成功");
/*     */     } else {
/* 196 */       result.put("code", Integer.valueOf(400));
/* 197 */       result.put("msg", "操作失败");
/*     */     }
/*     */     
/* 200 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ChannelProviderController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
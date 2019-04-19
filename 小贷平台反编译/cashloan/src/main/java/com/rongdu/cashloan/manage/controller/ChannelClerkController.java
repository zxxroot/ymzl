/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.Channel;
/*     */ import com.rongdu.cashloan.cl.model.ChannelStaffCountModel;
/*     */ import com.rongdu.cashloan.cl.model.ChannelStaffModel;
/*     */ import com.rongdu.cashloan.cl.model.KeyValue;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ChannelClerkController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   @Resource
/*     */   private UrgeRepayOrderService urgeRepayOrderService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/channelStaffList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelStaffList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws ParseException
/*     */   {
/*  66 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  67 */     params = params == null ? new HashMap() : params;
/*  68 */     List<String> roleNid = new ArrayList();
/*  69 */     if (params.get("roleNid") == null)
/*     */     {
/*  71 */       roleNid.add("channelSupervisor");
/*  72 */       roleNid.add("channelStaff");
/*  73 */       params.put("roleNid", roleNid);
/*     */     }
/*  75 */     else if (params.get("roleNid").equals("csr"))
/*     */     {
/*  77 */       roleNid.add("channelSupervisor");
/*  78 */       params.put("roleNid", roleNid);
/*  79 */     } else if (params.get("roleNid").equals("csf"))
/*     */     {
/*  81 */       roleNid.add("channelStaff");
/*  82 */       params.put("roleNid", roleNid);
/*     */     }
/*     */     
/*  85 */     Page<ChannelStaffCountModel> page = this.channelService.channelCount(params, current, pageSize);
/*  86 */     Map<String, Object> result = new HashMap();
/*  87 */     result.put("data", page);
/*  88 */     result.put("page", new RdPage(page));
/*  89 */     result.put("code", Integer.valueOf(200));
/*  90 */     result.put("msg", "获取成功");
/*     */     
/*  92 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/channelStaffDetails.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelStaffDetails(@RequestParam("userId") Long userId)
/*     */     throws ParseException
/*     */   {
/* 102 */     ChannelStaffModel model = this.channelService.channelStaffDetails(userId);
/* 103 */     Map<String, Object> result = new HashMap();
/* 104 */     result.put("data", model);
/* 105 */     result.put("code", Integer.valueOf(200));
/* 106 */     result.put("msg", "获取成功");
/*     */     
/* 108 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channel:updateState", name="修改渠道员状态")
/*     */   public void updateState(@RequestParam("id") Long id, @RequestParam(value="status", required=false) String status, @RequestParam(value="memberState", required=false) String memberState)
/*     */   {
/* 122 */     Map<String, Object> result = new HashMap();
/* 123 */     Map<String, Object> param = new HashMap();
/* 124 */     result.put("code", Integer.valueOf(400));
/* 125 */     result.put("msg", "参数不合法");
/* 126 */     if ((memberState != null) || (status != null)) {
/* 127 */       param.put("id", id);
/* 128 */       param.put("status", status);
/* 129 */       param.put("memberState", memberState);
/* 130 */       this.urgeRepayOrderService.updateState(param);
/* 131 */       result.put("code", Integer.valueOf(200));
/* 132 */       result.put("msg", "提交成功");
/*     */     }
/*     */     
/* 135 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/updateChannelStaff.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channel:updateChannelStaff", name="修改渠道员状态")
/*     */   public void updateChannelStaff(@RequestParam("id") Long id, @RequestParam(value="params", required=false) String params)
/*     */     throws ServiceException
/*     */   {
/* 149 */     Map<String, Object> result = new HashMap();
/* 150 */     result.put("code", Integer.valueOf(400));
/* 151 */     result.put("msg", "参数不合法");
/* 152 */     if (params != null) {
/* 153 */       Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/* 154 */       SysUser sysUser = this.sysUserService.getUserById(id.longValue());
/* 155 */       if (sysUser == null) {
/* 156 */         result.put("code", Integer.valueOf(400));
/* 157 */         result.put("msg", "用户不存在");
/*     */       }
/* 159 */       if (param.get("phone") != null) {
/* 160 */         sysUser.setPhone(param.get("phone").toString());
/*     */       }
/* 162 */       if (param.get("email") != null) {
/* 163 */         sysUser.setEmail(param.get("email").toString());
/*     */       }
/* 165 */       if (param.get("remark") != null) {
/* 166 */         sysUser.setRemark(param.get("remark").toString());
/*     */       }
/* 168 */       if (param.get("mobile") != null) {
/* 169 */         sysUser.setMobile(param.get("mobile").toString());
/*     */       }
/* 171 */       this.sysUserService.userUpdate(sysUser);
/* 172 */       result.put("code", Integer.valueOf(200));
/* 173 */       result.put("msg", "提交成功");
/*     */     }
/*     */     
/* 176 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/relationChannelList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void relationChannelList(@RequestParam("userId") Long userId)
/*     */     throws ParseException
/*     */   {
/* 187 */     Map<String, Object> param = new HashMap();
/*     */     
/* 189 */     param.put("userId", userId);
/* 190 */     List<Channel> channelByUser = this.channelService.relationChannelList(param);
/*     */     
/* 192 */     param.put("userId", null);
/* 193 */     param.put("firstClassResponsiblePerson", userId);
/* 194 */     List<Channel> channellist = this.channelService.relationChannelListALL(param);
/* 195 */     Map<String, Object> data = new HashMap();
/* 196 */     data.put("channelList", channellist);
/* 197 */     data.put("channelByUser", channelByUser);
/* 198 */     Map<String, Object> result = new HashMap();
/* 199 */     result.put("data", data);
/* 200 */     result.put("code", Integer.valueOf(200));
/* 201 */     result.put("msg", "获取成功");
/* 202 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/updateChannelById.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channel:updateChannelById", name="修改渠道员状态")
/*     */   public void updateChannelById(@RequestParam("userId") Long userId, @RequestParam("channelList") String[] channelList)
/*     */   {
/* 216 */     Map<String, Object> result = new HashMap();
/* 217 */     result = this.channelService.updateChannelById(userId, channelList);
/* 218 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelClerk/listChannelClerk.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelContactId()
/*     */     throws Exception
/*     */   {
/* 227 */     List<KeyValue> list = this.channelService.listChannelContactId();
/* 228 */     Map<String, Object> result = new HashMap();
/* 229 */     result.put("data", list);
/* 230 */     result.put("code", Integer.valueOf(200));
/* 231 */     result.put("msg", "查询成功");
/* 232 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ChannelClerkController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
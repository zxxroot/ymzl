/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorTdCallInfo;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorVoices;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorVoicesContact;
/*     */ import com.rongdu.cashloan.cl.domain.UserContacts;
/*     */ import com.rongdu.cashloan.cl.domain.UserMessages;
/*     */ import com.rongdu.cashloan.cl.service.OperatorTdBasicService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorVoicesContactService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorVoicesService;
/*     */ import com.rongdu.cashloan.cl.service.UserContactsService;
/*     */ import com.rongdu.cashloan.cl.service.UserMessagesService;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.StringUtil;
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
/*     */ public class ManageMsgController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private UserContactsService userContactsService;
/*     */   @Resource
/*     */   private UserMessagesService userMessagesService;
/*     */   @Resource
/*     */   private OperatorVoicesService operatorVoicesService;
/*     */   @Resource
/*     */   private CloanUserService cloanUserService;
/*     */   @Resource
/*     */   private OperatorTdBasicService operatorTdBasicService;
/*     */   @Resource
/*     */   private OperatorVoicesContactService operatorVoicesContactService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/msg/listContacts.htm"})
/*     */   public void listContacts(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  72 */     Page<UserContacts> page = this.userContactsService.listContacts(userId, current, pageSize);
/*  73 */     Map<String, Object> data = new HashMap();
/*  74 */     data.put("list", page.getResult());
/*  75 */     Map<String, Object> result = new HashMap();
/*  76 */     result.put("data", data);
/*  77 */     result.put("page", new RdPage(page));
/*  78 */     result.put("code", Integer.valueOf(200));
/*  79 */     result.put("msg", "查询成功");
/*  80 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/msg/listMessages.htm"})
/*     */   public void listMessages(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  95 */     Page<UserMessages> page = this.userMessagesService.findShardPage(userId, current, pageSize);
/*  96 */     Map<String, Object> data = new HashMap();
/*  97 */     data.put("list", page.getResult());
/*  98 */     Map<String, Object> result = new HashMap();
/*  99 */     result.put("data", data);
/* 100 */     result.put("page", new RdPage(page));
/* 101 */     result.put("code", Integer.valueOf(200));
/* 102 */     result.put("msg", "查询成功");
/* 103 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/msg/listRecords.htm"})
/*     */   public void listRecords(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 117 */     Map<String, Object> params = new HashMap();
/* 118 */     params.put("userId", Long.valueOf(userId));
/* 119 */     Page<OperatorVoices> page = this.operatorVoicesService.findShardPage(params, current, pageSize);
/* 120 */     Map<String, Object> data = new HashMap();
/* 121 */     data.put("list", page.getResult());
/* 122 */     Map<String, Object> result = new HashMap();
/* 123 */     result.put("data", data);
/* 124 */     result.put("page", new RdPage(page));
/* 125 */     result.put("code", Integer.valueOf(200));
/* 126 */     result.put("msg", "查询成功");
/* 127 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/msg/listHighVoices.htm"})
/*     */   public void listHighVoicesRecords(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 141 */     Map<String, Object> params = new HashMap();
/* 142 */     params.put("userId", Long.valueOf(userId));
/* 143 */     params.put("orderBy", "call_cnt desc");
/* 144 */     Page<OperatorVoicesContact> page = this.operatorVoicesContactService.findShardPage(params, current, pageSize);
/* 145 */     Map<String, Object> data = new HashMap();
/* 146 */     data.put("list", page.getResult());
/* 147 */     Map<String, Object> result = new HashMap();
/* 148 */     result.put("data", data);
/* 149 */     result.put("page", new RdPage(page));
/* 150 */     result.put("code", Integer.valueOf(200));
/* 151 */     result.put("msg", "查询成功");
/* 152 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/msg/tdListRecords.htm"})
/*     */   public void tdListRecords(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 166 */     Map<String, Object> data = new HashMap();
/* 167 */     Page<OperatorVoices> page = new Page();
/* 168 */     Map<String, Object> params = new HashMap();
/* 169 */     params.put("userId", Long.valueOf(userId));
/* 170 */     OperatorTdCallInfo callInfo = this.operatorTdBasicService.findOperatorTdCallInfos(params);
/* 171 */     if (StringUtil.isNotBlank(callInfo)) {
/* 172 */       params = new HashMap();
/* 173 */       params.put("reqLogId", callInfo.getReqLogId());
/* 174 */       page = this.operatorTdBasicService.findPageOperatorTdCallRecord(params, current, pageSize);
/* 175 */       data.put("list", page.getResult());
/*     */     }
/*     */     
/* 178 */     Map<String, Object> result = new HashMap();
/* 179 */     result.put("data", data);
/* 180 */     result.put("page", new RdPage(page));
/* 181 */     result.put("code", Integer.valueOf(200));
/* 182 */     result.put("msg", "查询成功");
/* 183 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/msg/recordsDetail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void recordsDetail(@RequestParam("userId") long userId, @RequestParam("voiceToNumber") long voiceToNumber, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 200 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     
/* 202 */     Page<OperatorVoices> page = this.operatorVoicesService.recordsDetail(params, current, pageSize, userId, voiceToNumber);
/*     */     
/* 204 */     Map<String, Object> recordsCount = this.operatorVoicesService.recordsCount(userId, voiceToNumber);
/* 205 */     Map<String, Object> data = new HashMap();
/* 206 */     data.put("list", page.getResult());
/* 207 */     data.put("recordsCount", recordsCount);
/* 208 */     Map<String, Object> result = new HashMap();
/* 209 */     result.put("data", data);
/* 210 */     result.put("page", new RdPage(page));
/* 211 */     result.put("code", Integer.valueOf(200));
/* 212 */     result.put("msg", "查询成功");
/* 213 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageMsgController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
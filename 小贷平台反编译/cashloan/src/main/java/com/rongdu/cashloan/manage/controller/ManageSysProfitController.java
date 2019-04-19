/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.ManageAgentListModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageAgentModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageCashLogModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageProfitAmountModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageProfitLogModel;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAgentService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAmountService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitCashLogService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitLogService;
/*     */ import com.rongdu.cashloan.cl.service.UserInviteService;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageSysProfitController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private UserInviteService userInviteService;
/*     */   @Resource
/*     */   private ProfitAgentService profitAgentService;
/*     */   @Resource
/*     */   private ProfitAmountService profitAmountService;
/*     */   @Resource
/*     */   private ProfitCashLogService profitCashLogService;
/*     */   @Resource
/*     */   private ProfitLogService profitLogService;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   @RequestMapping({"/modules/manage/sysProfit/findAgentList.htm"})
/*     */   public void findAgentList(@RequestParam(value="userName", required=false) String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  74 */     Page<ManageAgentListModel> page = this.profitAgentService.findAgentList(userName, current, pageSize);
/*  75 */     Map<String, Object> data = new HashMap();
/*  76 */     data.put("list", page.getResult());
/*  77 */     Map<String, Object> result = new HashMap();
/*  78 */     result.put("data", data);
/*  79 */     result.put("page", new RdPage(page));
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
/*     */   @RequestMapping({"/modules/manage/sysProfit/findUserLevel.htm"})
/*     */   public void findUserLevel(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  97 */     Page<User> page = this.profitAgentService.findUserLevel(userName, current, pageSize);
/*  98 */     Map<String, Object> data = new HashMap();
/*  99 */     data.put("list", page.getResult());
/* 100 */     Map<String, Object> result = new HashMap();
/* 101 */     result.put("data", data);
/* 102 */     result.put("page", new RdPage(page));
/* 103 */     result.put("code", Integer.valueOf(200));
/* 104 */     result.put("msg", "查询成功");
/* 105 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/sysProfit/findAgent.htm"})
/*     */   public void findAgent(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 118 */     Page<ManageAgentModel> page = this.userInviteService.findSysAgent(userName, current, pageSize);
/* 119 */     Map<String, Object> data = new HashMap();
/* 120 */     data.put("list", page.getResult());
/* 121 */     Map<String, Object> result = new HashMap();
/* 122 */     result.put("data", data);
/* 123 */     result.put("page", new RdPage(page));
/* 124 */     result.put("code", Integer.valueOf(200));
/* 125 */     result.put("msg", "查询成功");
/* 126 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/sysProfit/findLog.htm"})
/*     */   public void findLog(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 139 */     Page<ManageProfitLogModel> page = this.profitCashLogService.findLog(userName, current, pageSize);
/* 140 */     Map<String, Object> data = new HashMap();
/* 141 */     data.put("list", page.getResult());
/* 142 */     Map<String, Object> result = new HashMap();
/* 143 */     result.put("data", data);
/* 144 */     result.put("page", new RdPage(page));
/* 145 */     result.put("code", Integer.valueOf(200));
/* 146 */     result.put("msg", "查询成功");
/* 147 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/sysProfit/findAmount.htm"})
/*     */   public void findAmount(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 162 */     Page<ManageProfitAmountModel> page = this.profitAmountService.findSysAmount(userName, current, pageSize);
/* 163 */     Map<String, Object> data = new HashMap();
/* 164 */     data.put("list", page.getResult());
/* 165 */     Map<String, Object> result = new HashMap();
/* 166 */     result.put("data", data);
/* 167 */     result.put("page", new RdPage(page));
/* 168 */     result.put("code", Integer.valueOf(200));
/* 169 */     result.put("msg", "查询成功");
/* 170 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/sysProfit/findCashLog.htm"})
/*     */   public void findCashLog(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 185 */     Page<ManageCashLogModel> page = this.profitLogService.findCashLog(userName, current, pageSize);
/* 186 */     Map<String, Object> data = new HashMap();
/* 187 */     data.put("list", page.getResult());
/* 188 */     Map<String, Object> result = new HashMap();
/* 189 */     result.put("data", data);
/* 190 */     result.put("page", new RdPage(page));
/* 191 */     result.put("code", Integer.valueOf(200));
/* 192 */     result.put("msg", "查询成功");
/* 193 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/profit/saveAgent.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void saveAgent(@RequestParam("level") int level)
/*     */     throws Exception
/*     */   {
/* 203 */     String leaderId = this.request.getParameter("userId");
/* 204 */     String userId = this.request.getParameter("inviteId");
/* 205 */     String rate = this.request.getParameter("rate");
/* 206 */     UserBaseInfo userBaseInfo = this.userBaseInfoMapper.findByUserId(Long.valueOf(Long.parseLong(userId)));
/* 207 */     Map<String, Object> result = new HashMap();
/* 208 */     int msg = 0;
/* 209 */     Date updateTime = new Date();
/* 210 */     if ((StringUtil.isNotBlank(rate)) && (Integer.valueOf(rate).intValue() <= 5)) {
/* 211 */       result.put("code", Integer.valueOf(400));
/* 212 */       result.put("msg", "分润比例设置错误");
/*     */ 
/*     */     }
/* 215 */     else if ((userBaseInfo != null) && ("10".equals(userBaseInfo.getState()))) {
/* 216 */       result.put("code", Integer.valueOf(400));
/* 217 */       result.put("msg", "该账号无法借款,请联系客服人员。");
/*     */     }
/* 219 */     else if (level == 1) {
/* 220 */       msg = this.profitAgentService.saveOne(Long.parseLong(userId), updateTime);
/*     */     } else {
/* 222 */       msg = this.profitAgentService.saveTwo(Long.parseLong(userId), leaderId, rate, updateTime);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 227 */     if (msg > 0) {
/* 228 */       result.put("code", Integer.valueOf(200));
/* 229 */       result.put("msg", "添加成功");
/*     */     }
/* 231 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/profit/freezeAgent.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void freezeAgent(@RequestParam("userId") long userId)
/*     */     throws Exception
/*     */   {
/* 242 */     Date updateTime = new Date();
/* 243 */     int msg = this.profitAgentService.freezeAgent(userId, updateTime);
/* 244 */     Map<String, Object> result = new HashMap();
/* 245 */     if (msg > 0) {
/* 246 */       result.put("code", Integer.valueOf(200));
/* 247 */       result.put("msg", "取消成功");
/*     */     } else {
/* 249 */       result.put("code", Integer.valueOf(400));
/* 250 */       result.put("msg", "取消失败");
/*     */     }
/* 252 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/profit/rankUp.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void rankUp(@RequestParam("id") long id, @RequestParam("userId") long userId)
/*     */     throws Exception
/*     */   {
/* 263 */     int msg = this.profitAgentService.rankUp(id, userId);
/* 264 */     Map<String, Object> result = new HashMap();
/* 265 */     if (msg > 0) {
/* 266 */       result.put("code", Integer.valueOf(200));
/* 267 */       result.put("msg", "添加成功");
/*     */     } else {
/* 269 */       result.put("code", Integer.valueOf(400));
/* 270 */       result.put("msg", "添加失败");
/*     */     }
/* 272 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/profit/pass.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void pass(@RequestParam("id") long id, @RequestParam("isUse") int isUse)
/*     */     throws Exception
/*     */   {
/* 283 */     int msg = this.profitAgentService.pass(isUse, id);
/* 284 */     Map<String, Object> result = new HashMap();
/* 285 */     if (msg > 0) {
/* 286 */       result.put("code", Integer.valueOf(200));
/* 287 */       result.put("msg", "代理商审核通过");
/*     */     } else {
/* 289 */       result.put("code", Integer.valueOf(400));
/* 290 */       result.put("msg", "代理商审核失败");
/*     */     }
/* 292 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageSysProfitController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
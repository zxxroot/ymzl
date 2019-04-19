/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.ManageCashLogModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageProfitAmountModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageProfitLogModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageProfitModel;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAgentService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAmountService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitCashLogService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitLogService;
/*     */ import com.rongdu.cashloan.cl.service.UserInviteService;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageProfitController
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
/*     */   private CloanUserService cloanUserService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/profit/findAgent.htm"})
/*     */   public void findAgent(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  68 */     Map<String, Object> result = new HashMap();
/*  69 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*     */     
/*  71 */     if ((user == null) || (StringUtil.isBlank(user.getPhone()))) {
/*  72 */       result.put("code", Integer.valueOf(400));
/*  73 */       result.put("msg", "用户异常");
/*  74 */       ServletUtils.writeToResponse(this.response, result);
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     Page<ManageProfitModel> page = this.userInviteService.findAgent(user.getPhone(), userName, current, pageSize);
/*  79 */     Map<String, Object> data = new HashMap();
/*  80 */     data.put("list", page.getResult());
/*     */     
/*  82 */     result.put("data", data);
/*  83 */     result.put("page", new RdPage(page));
/*  84 */     result.put("code", Integer.valueOf(200));
/*  85 */     result.put("msg", "查询成功");
/*  86 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/profit/findLog.htm"})
/*     */   public void findLog(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  99 */     Map<String, Object> result = new HashMap();
/* 100 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 101 */     if ((user == null) || (StringUtil.isBlank(user.getPhone()))) {
/* 102 */       result.put("code", Integer.valueOf(400));
/* 103 */       result.put("msg", "用户异常");
/* 104 */       ServletUtils.writeToResponse(this.response, result);
/* 105 */       return;
/*     */     }
/*     */     
/* 108 */     Page<ManageProfitLogModel> page = this.profitCashLogService.findLog(user.getPhone(), userName, current, pageSize);
/* 109 */     Map<String, Object> data = new HashMap();
/* 110 */     data.put("list", page.getResult());
/*     */     
/* 112 */     result.put("data", data);
/* 113 */     result.put("page", new RdPage(page));
/* 114 */     result.put("code", Integer.valueOf(200));
/* 115 */     result.put("msg", "查询成功");
/* 116 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/profit/findAmount.htm"})
/*     */   public void findAmount(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 131 */     Map<String, Object> result = new HashMap();
/* 132 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*     */     
/* 134 */     if ((user == null) || (StringUtil.isBlank(user.getPhone()))) {
/* 135 */       result.put("code", Integer.valueOf(400));
/* 136 */       result.put("msg", "用户异常");
/* 137 */       ServletUtils.writeToResponse(this.response, result);
/* 138 */       return;
/*     */     }
/*     */     
/* 141 */     Page<ManageProfitAmountModel> page = this.profitAmountService.findAmount(user.getPhone(), userName, current, pageSize);
/* 142 */     Map<String, Object> data = new HashMap();
/* 143 */     data.put("list", page.getResult());
/*     */     
/* 145 */     result.put("data", data);
/* 146 */     result.put("page", new RdPage(page));
/* 147 */     result.put("code", Integer.valueOf(200));
/* 148 */     result.put("msg", "查询成功");
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
/*     */   @RequestMapping({"/modules/manage/profit/findCashLog.htm"})
/*     */   public void findCashLog(@RequestParam("userName") String userName, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 164 */     Map<String, Object> result = new HashMap();
/* 165 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*     */     
/* 167 */     if ((user == null) || (StringUtil.isBlank(user.getPhone()))) {
/* 168 */       result.put("code", Integer.valueOf(400));
/* 169 */       result.put("msg", "用户异常");
/* 170 */       ServletUtils.writeToResponse(this.response, result);
/* 171 */       return;
/*     */     }
/*     */     
/* 174 */     Page<ManageCashLogModel> page = this.profitLogService.findCashLog(user.getPhone(), userName, current, pageSize);
/* 175 */     Map<String, Object> data = new HashMap();
/* 176 */     data.put("list", page.getResult());
/*     */     
/* 178 */     result.put("data", data);
/* 179 */     result.put("page", new RdPage(page));
/* 180 */     result.put("code", Integer.valueOf(200));
/* 181 */     result.put("msg", "查询成功");
/* 182 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageProfitController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
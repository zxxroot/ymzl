/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.model.ManageBorrowTestModel;
/*    */ import com.rongdu.cashloan.cl.service.BorrowRepayLogService;
/*    */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*    */ import com.rongdu.cashloan.cl.service.DhbReqLogService;
/*    */ import com.rongdu.cashloan.cl.service.OperatorReqLogService;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.domain.Borrow;
/*    */ import com.rongdu.cashloan.core.service.CloanUserService;
/*    */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*    */ import com.rongdu.cashloan.rc.service.TppBusinessService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class ManageBorrowTest
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private ClBorrowService clBorrowService;
/*    */   @Resource
/*    */   private CloanUserService userService;
/*    */   @Resource
/*    */   private OperatorReqLogService operatorReqLogService;
/*    */   @Resource
/*    */   private CloanUserService cloanUserService;
/*    */   @Resource
/*    */   private BorrowRepayLogService borrowRepayLogService;
/*    */   @Resource
/*    */   private TppBusinessService tppBusinessService;
/*    */   @Resource
/*    */   private DhbReqLogService dhbReqLogService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/user/list.htm"})
/*    */   public void list()
/*    */     throws Exception
/*    */   {
/* 47 */     List<ManageBorrowTestModel> list = this.clBorrowService.seleteUser();
/* 48 */     Map<String, Object> data = new HashMap();
/* 49 */     data.put("list", list);
/* 50 */     Map<String, Object> result = new HashMap();
/* 51 */     result.put("data", data);
/* 52 */     result.put("code", Integer.valueOf(200));
/* 53 */     result.put("msg", "查询成功");
/* 54 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/modules/manage/borrow/apply.htm"})
/*    */   public void apply(@RequestParam("amount") double amount, @RequestParam("timeLimit") String timeLimit, @RequestParam("userId") long userId, @RequestParam("cardId") long cardId)
/*    */     throws Exception
/*    */   {
/* 65 */     Map<String, Object> result = new HashMap();
/* 66 */     Borrow borrow = new Borrow(Long.valueOf(1L), Double.valueOf(amount), timeLimit, Long.valueOf(cardId), "", "", "", "");
/* 67 */     borrow = this.clBorrowService.rcBorrowApply(borrow, "", "");
/* 68 */     if ((borrow != null) && (borrow.getId().longValue() > 0L)) {
/* 69 */       result.put("code", Integer.valueOf(200));
/* 70 */       result.put("msg", "申请成功");
/*    */     } else {
/* 72 */       result.put("code", Integer.valueOf(400));
/* 73 */       result.put("msg", "申请失败");
/*    */     }
/*    */     
/* 76 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/modules/manage/borrow/dhbSauron.htm"})
/*    */   public void dhbSauron(@RequestParam("borrowId") long borrowId)
/*    */     throws Exception
/*    */   {
/* 87 */     Map<String, Object> result = new HashMap();
/* 88 */     Borrow borrow = new Borrow();
/* 89 */     borrow = this.clBorrowService.findByPrimary(Long.valueOf(borrowId));
/* 90 */     TppBusiness business = this.tppBusinessService.findByNid("DhbSauron", Long.valueOf(2L));
/* 91 */     this.dhbReqLogService.queryDhbSauron(borrow, business);
/*    */     
/* 93 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageBorrowTest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
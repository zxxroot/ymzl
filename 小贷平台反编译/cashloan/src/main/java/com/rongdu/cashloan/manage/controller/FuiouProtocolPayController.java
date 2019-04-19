/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.domain.BankCard;
/*    */ import com.rongdu.cashloan.cl.service.BankCardService;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class FuiouProtocolPayController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private BankCardService bankCardService;
/*    */   
/*    */   @RequestMapping(value={"/modules/newprotocol/unbind.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void unbind(@RequestParam("userId") Long userId)
/*    */     throws Exception
/*    */   {
/* 39 */     BankCard bankCard = this.bankCardService.getBankCardByUserId(userId);
/* 40 */     Map<String, Object> result = this.bankCardService.unBind(bankCard);
/* 41 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\FuiouProtocolPayController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
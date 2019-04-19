/*    */ package com.cashloan.cl.model.pay.lianlian.constant;
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
/*    */ public enum PayStatusEnum
/*    */ {
/* 16 */   PAYMENT_APPLY("APPLY", "付款申请"), 
/* 17 */   PAYMENT_CHECK("CHECK", "复核申请"), 
/* 18 */   PAYMENT_DEALING("PROCESSING", "付款处理中"), 
/* 19 */   PAYMENT_SUCCESS("SUCCESS", "付款成功"), 
/* 20 */   PAYMENT_FAILURE("FAILURE", "付款失败"), 
/* 21 */   PAYMENT_RETURN("CANCEL", "退款"), 
/* 22 */   PAYMENT_CLOSED("CLOSED", "订单关闭");
/*    */   
/*    */ 
/*    */   private String value;
/*    */   private String desc;
/*    */   
/*    */   private PayStatusEnum(String value, String desc)
/*    */   {
/* 30 */     this.value = value;
/* 31 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 35 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 39 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 43 */     return this.desc;
/*    */   }
/*    */   
/*    */   public void setDesc(String desc) {
/* 47 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public static PayStatusEnum getPayStatusEnumByValue(String value) {
/*    */     PayStatusEnum[] arrayOfPayStatusEnum;
/* 52 */     int j = (arrayOfPayStatusEnum = values()).length; for (int i = 0; i < j; i++) { PayStatusEnum statusEnum = arrayOfPayStatusEnum[i];
/* 53 */       if (statusEnum.getValue().equals(value)) {
/* 54 */         return statusEnum;
/*    */       }
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ }

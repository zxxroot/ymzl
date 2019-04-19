/*    */ package com.cashloan.cl.model;

import com.cashloan.cl.domain.ChannelApp;

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
/*    */ 
/*    */ public class ChannelAppModel
/*    */   extends ChannelApp
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String code;
/*    */   private String name;
/*    */   private String state;
/*    */   private String appTypeStr;
/*    */   
/*    */   public String getAppTypeStr()
/*    */   {
/* 29 */     if ("10".equals(getAppType())) {
/* 30 */       setAppTypeStr("android");
/* 31 */     } else if ("20".equals(getAppType())) {
/* 32 */       setAppTypeStr("ios");
/*    */     }
/* 34 */     return this.appTypeStr;
/*    */   }
/*    */   
/*    */   public void setAppTypeStr(String appTypeStr) {
/* 38 */     this.appTypeStr = appTypeStr;
/*    */   }
/*    */   
/*    */   public String getState() {
/* 42 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(String state) {
/* 46 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 50 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 54 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 58 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 62 */     this.name = name;
/*    */   }
/*    */ }

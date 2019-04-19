/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyValue
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 9067339405190218441L;
/*    */   private Long id;
/*    */   private String key;
/*    */   private String value;
/*    */   private int state;
/*    */   
/*    */   public String getKey()
/*    */   {
/* 34 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 38 */     this.key = key;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 42 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 46 */     this.value = value;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 50 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 54 */     this.id = id;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 58 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 62 */     this.state = state;
/*    */   }
/*    */ }

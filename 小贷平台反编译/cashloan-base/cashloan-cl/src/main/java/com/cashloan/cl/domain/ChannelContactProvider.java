/*    */ package com.cashloan.cl.domain;
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
/*    */ 
/*    */ 
/*    */ public class ChannelContactProvider
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Long id;
/*    */   private Long channelContactId;
/*    */   private Long channelProviderId;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 35 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 39 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Long getChannelContactId() {
/* 43 */     return this.channelContactId;
/*    */   }
/*    */   
/*    */   public void setChannelContactId(Long channelContactId) {
/* 47 */     this.channelContactId = channelContactId;
/*    */   }
/*    */   
/*    */   public Long getChannelProviderId() {
/* 51 */     return this.channelProviderId;
/*    */   }
/*    */   
/*    */   public void setChannelProviderId(Long channelProviderId) {
/* 55 */     this.channelProviderId = channelProviderId;
/*    */   }
/*    */ }

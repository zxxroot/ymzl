/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DhbRiskBlacklist
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private String idcardInBlacklist;
/*     */   private String phoneInBlacklist;
/*     */   private String inCourtBlacklist;
/*     */   private String inP2pBlacklist;
/*     */   private String inBankBlacklist;
/*     */   private String lastAppearIdcardInBlacklist;
/*     */   private String lastAppearPhoneInBlacklist;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  94 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 103 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 112 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 121 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdcardInBlacklist()
/*     */   {
/* 130 */     return this.idcardInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdcardInBlacklist(String idcardInBlacklist)
/*     */   {
/* 139 */     this.idcardInBlacklist = idcardInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneInBlacklist()
/*     */   {
/* 148 */     return this.phoneInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneInBlacklist(String phoneInBlacklist)
/*     */   {
/* 157 */     this.phoneInBlacklist = phoneInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInCourtBlacklist()
/*     */   {
/* 166 */     return this.inCourtBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInCourtBlacklist(String inCourtBlacklist)
/*     */   {
/* 175 */     this.inCourtBlacklist = inCourtBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInP2pBlacklist()
/*     */   {
/* 184 */     return this.inP2pBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInP2pBlacklist(String inP2pBlacklist)
/*     */   {
/* 193 */     this.inP2pBlacklist = inP2pBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInBankBlacklist()
/*     */   {
/* 202 */     return this.inBankBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInBankBlacklist(String inBankBlacklist)
/*     */   {
/* 211 */     this.inBankBlacklist = inBankBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastAppearIdcardInBlacklist()
/*     */   {
/* 220 */     return this.lastAppearIdcardInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastAppearIdcardInBlacklist(String lastAppearIdcardInBlacklist)
/*     */   {
/* 229 */     this.lastAppearIdcardInBlacklist = lastAppearIdcardInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastAppearPhoneInBlacklist()
/*     */   {
/* 238 */     return this.lastAppearPhoneInBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastAppearPhoneInBlacklist(String lastAppearPhoneInBlacklist)
/*     */   {
/* 247 */     this.lastAppearPhoneInBlacklist = lastAppearPhoneInBlacklist;
/*     */   }
/*     */ }

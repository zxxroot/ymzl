/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ public class UserAuth
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String realNameState;
/*     */   private String idState;
/*     */   private String contactState;
/*     */   private String bankCardState;
/*     */   private String zhimaState;
/*     */   private String taoBaoState;
/*     */   private String phoneState;
/*     */   private String workInfoState;
/*     */   private String otherInfoState;
/*     */   private String accFundState;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 100 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 109 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 118 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 127 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealNameState()
/*     */   {
/* 136 */     return this.realNameState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealNameState(String realNameState)
/*     */   {
/* 146 */     this.realNameState = realNameState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdState()
/*     */   {
/* 155 */     return this.idState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdState(String idState)
/*     */   {
/* 164 */     this.idState = idState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getContactState()
/*     */   {
/* 173 */     return this.contactState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContactState(String contactState)
/*     */   {
/* 182 */     this.contactState = contactState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBankCardState()
/*     */   {
/* 191 */     return this.bankCardState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBankCardState(String bankCardState)
/*     */   {
/* 200 */     this.bankCardState = bankCardState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getZhimaState()
/*     */   {
/* 209 */     return this.zhimaState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZhimaState(String zhimaState)
/*     */   {
/* 218 */     this.zhimaState = zhimaState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneState()
/*     */   {
/* 227 */     return this.phoneState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneState(String phoneState)
/*     */   {
/* 236 */     this.phoneState = phoneState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWorkInfoState()
/*     */   {
/* 245 */     return this.workInfoState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWorkInfoState(String workInfoState)
/*     */   {
/* 254 */     this.workInfoState = workInfoState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOtherInfoState()
/*     */   {
/* 263 */     return this.otherInfoState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOtherInfoState(String otherInfoState)
/*     */   {
/* 272 */     this.otherInfoState = otherInfoState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccFundState()
/*     */   {
/* 282 */     return this.accFundState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccFundState(String accFundState)
/*     */   {
/* 292 */     this.accFundState = accFundState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 302 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 312 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getTaoBaoState() {
/* 316 */     return this.taoBaoState;
/*     */   }
/*     */   
/*     */   public void setTaoBaoState(String taoBaoState) {
/* 320 */     this.taoBaoState = taoBaoState;
/*     */   }
/*     */ }
/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.PayLog;
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
/*     */ public class ManagePayLogModel
/*     */   extends PayLog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String borrowOrderNo;
/*     */   private String loginName;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private Date loanTime;
/*     */   private String stateStr;
/*     */   private String sourceStr;
/*     */   private String typeStr;
/*     */   private String scenesStr;
/*     */   private String borrowState;
/*     */   
/*     */   public String getBorrowOrderNo()
/*     */   {
/*  68 */     return this.borrowOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowOrderNo(String borrowOrderNo)
/*     */   {
/*  76 */     this.borrowOrderNo = borrowOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginName()
/*     */   {
/*  85 */     return this.loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginName(String loginName)
/*     */   {
/*  94 */     this.loginName = loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealName()
/*     */   {
/* 103 */     return this.realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealName(String realName)
/*     */   {
/* 112 */     this.realName = realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 121 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 130 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getLoanTime()
/*     */   {
/* 139 */     return this.loanTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanTime(Date loanTime)
/*     */   {
/* 148 */     this.loanTime = loanTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/* 157 */     this.stateStr = stateConvet(getState());
/* 158 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 167 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSourceStr()
/*     */   {
/* 176 */     this.sourceStr = sourceConvert(getSource());
/* 177 */     return this.sourceStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSourceStr(String sourceStr)
/*     */   {
/* 186 */     this.sourceStr = sourceStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTypeStr()
/*     */   {
/* 195 */     this.typeStr = typeConvert(getType());
/* 196 */     return this.typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTypeStr(String typeStr)
/*     */   {
/* 205 */     this.typeStr = typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScenesStr()
/*     */   {
/* 214 */     this.scenesStr = scenesConvert(getScenes());
/* 215 */     return this.scenesStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScenesStr(String scenesStr)
/*     */   {
/* 224 */     this.scenesStr = scenesStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowState()
/*     */   {
/* 233 */     return this.borrowState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowState(String borrowState)
/*     */   {
/* 242 */     this.borrowState = borrowState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String stateConvet(String state)
/*     */   {
/* 252 */     String stateStr = null;
/* 253 */     if ("10".equals(state)) {
/* 254 */       stateStr = "待支付";
/* 255 */     } else if ("15".equals(state)) {
/* 256 */       stateStr = "待审核";
/* 257 */     } else if ("20".equals(state)) {
/* 258 */       stateStr = "审核通过";
/* 259 */     } else if ("30".equals(state)) {
/* 260 */       stateStr = "审核不通过";
/* 261 */     } else if ("40".equals(state)) {
/* 262 */       stateStr = "支付成功";
/* 263 */     } else if ("50".equals(state)) {
/* 264 */       stateStr = "支付失败";
/*     */     } else {
/* 266 */       stateStr = " - ";
/*     */     }
/* 268 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String sourceConvert(String source)
/*     */   {
/*     */     String sourceStr;
/* 279 */     if ("10".equals(source)) {
/* 280 */       sourceStr = "自有资金"; } else {
/* 281 */       if ("20".equals(source)) {
/* 282 */         sourceStr = "其他资金";
/*     */       } else
/* 284 */         sourceStr = " - ";
/*     */     }
/* 286 */     return sourceStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String typeConvert(String type)
/*     */   {
/* 295 */     String typeStr = null;
/* 296 */     if ("10".equals(type)) {
/* 297 */       typeStr = "代付";
/* 298 */     } else if ("20".equals(type)) {
/* 299 */       typeStr = "代扣";
/* 300 */     } else if ("30".equals(type)) {
/* 301 */       typeStr = "线下代付";
/* 302 */     } else if ("40".equals(type)) {
/* 303 */       typeStr = "线下代扣";
/*     */     } else {
/* 305 */       typeStr = " - ";
/*     */     }
/*     */     
/* 308 */     return typeStr;
/*     */   }
/*     */   
/*     */   public static String scenesConvert(String scenes) {
/* 312 */     String scenesStr = null;
/* 313 */     if ("10".equals(scenes)) {
/* 314 */       scenesStr = "放款";
/* 315 */     } else if ("11".equals(scenes)) {
/* 316 */       scenesStr = "取现分润";
/* 317 */     } else if ("12".equals(scenes)) {
/* 318 */       scenesStr = "退还";
/* 319 */     } else if ("20".equals(scenes)) {
/* 320 */       scenesStr = "还款";
/* 321 */     } else if ("21".equals(scenes)) {
/* 322 */       scenesStr = "补扣";
/*     */     } else {
/* 324 */       scenesStr = " - ";
/*     */     }
/* 326 */     return scenesStr;
/*     */   }
/*     */ }

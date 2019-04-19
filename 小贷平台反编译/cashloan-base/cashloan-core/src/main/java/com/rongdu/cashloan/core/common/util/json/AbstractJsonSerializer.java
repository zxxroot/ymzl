/*     */ package com.rongdu.cashloan.core.common.util.json;
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
/*     */ public abstract class AbstractJsonSerializer
/*     */ {
/*  14 */   private String errorNo = "0";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  19 */   private String errorInfo = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  25 */   private boolean needErrorInfo = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void addObject(Object paramObject, String paramString, String[] paramArrayOfString, Boolean paramBoolean);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void addObject(Object paramObject, String paramString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void addObjectWithExclude(Object paramObject, String paramString, String[] paramArrayOfString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void addObjectWithInclude(Object paramObject, String paramString, String[] paramArrayOfString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract String toString();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorNo()
/*     */   {
/*  75 */     return this.errorNo;
/*     */   }
/*     */   
/*     */   public void setErrorNo(String errorNo)
/*     */   {
/*  80 */     this.errorNo = errorNo;
/*     */   }
/*     */   
/*     */   public String getErrorInfo()
/*     */   {
/*  85 */     return this.errorInfo;
/*     */   }
/*     */   
/*     */   public void setErrorInfo(String errorInfo)
/*     */   {
/*  90 */     this.errorInfo = errorInfo;
/*     */   }
/*     */   
/*     */   public boolean isNeedErrorInfo()
/*     */   {
/*  95 */     return this.needErrorInfo;
/*     */   }
/*     */   
/*     */   public void setNeedErrorInfo(boolean needErrorInfo)
/*     */   {
/* 100 */     this.needErrorInfo = needErrorInfo;
/*     */   }
/*     */ }

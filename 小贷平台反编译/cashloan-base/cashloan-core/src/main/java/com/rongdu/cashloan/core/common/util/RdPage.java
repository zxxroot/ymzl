/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import com.github.pagehelper.Page;
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
/*     */ public class RdPage
/*     */ {
/*     */   public static final int PAGE_NUM_DEFAULT = 1;
/*     */   public static final int PAGE_SIZE_DEFAULT = 10;
/*     */   private long total;
/*     */   private int pages;
/*     */   private int current;
/*     */   private int pageSize;
/*     */   
/*     */   public RdPage() {}
/*     */   
/*     */   public RdPage(Page<?> page)
/*     */   {
/*  46 */     this.total = page.getTotal();
/*  47 */     this.pages = page.getPages();
/*  48 */     this.current = page.getPageNum();
/*  49 */     this.pageSize = page.getPageSize();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasPre()
/*     */   {
/*  60 */     if ((this.pages > 1) && (this.current > 1)) {
/*  61 */       return true;
/*     */     }
/*  63 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/*  72 */     if ((this.pages > 1) && (this.current < this.pages)) {
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getTotal()
/*     */   {
/*  83 */     return this.total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotal(long total)
/*     */   {
/*  91 */     this.total = total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getPages()
/*     */   {
/*  99 */     return this.pages;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPages(int pages)
/*     */   {
/* 107 */     this.pages = pages;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCurrent()
/*     */   {
/* 115 */     return this.current == 0 ? 1 : this.current;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCurrent(int current)
/*     */   {
/* 123 */     this.current = current;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/* 130 */     return this.pageSize == 0 ? 10 : this.pageSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 138 */     this.pageSize = pageSize;
/*     */   }
/*     */ }

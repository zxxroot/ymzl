/*     */ package com.rongdu.cashloan.system.model;
/*     */ 
/*     */ import com.rongdu.cashloan.system.domain.SysMenu;
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
/*     */ public class TreeSysMenu
/*     */   extends SysMenu
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String text;
/*     */   private int parentId;
/*     */   private String iconCls;
/*     */   private String scriptId;
/*     */   private boolean expanded;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  46 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id)
/*     */   {
/*  51 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getText()
/*     */   {
/*  56 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(String text)
/*     */   {
/*  61 */     this.text = text;
/*     */   }
/*     */   
/*     */   public int getParentId()
/*     */   {
/*  66 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(int parentId)
/*     */   {
/*  71 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   public String getIconCls()
/*     */   {
/*  76 */     return this.iconCls;
/*     */   }
/*     */   
/*     */   public void setIconCls(String iconCls)
/*     */   {
/*  81 */     this.iconCls = iconCls;
/*     */   }
/*     */   
/*     */   public String getScriptId()
/*     */   {
/*  86 */     return this.scriptId;
/*     */   }
/*     */   
/*     */   public void setScriptId(String scriptId)
/*     */   {
/*  91 */     this.scriptId = scriptId;
/*     */   }
/*     */   
/*     */   public boolean isExpanded()
/*     */   {
/*  96 */     return this.expanded;
/*     */   }
/*     */   
/*     */   public void setExpanded(boolean expanded)
/*     */   {
/* 101 */     this.expanded = expanded;
/*     */   }
/*     */ }

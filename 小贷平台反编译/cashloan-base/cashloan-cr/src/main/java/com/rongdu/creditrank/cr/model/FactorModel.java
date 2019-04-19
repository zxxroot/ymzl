/*     */ package com.rongdu.creditrank.cr.model;
/*     */ 
/*     */ import com.rongdu.creditrank.cr.domain.Factor;
/*     */ import java.util.List;
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
/*     */ public class FactorModel
/*     */   extends Factor
/*     */ {
/*  25 */   public static final Integer FACTOR_TYPE_SYSTEM = Integer.valueOf(10);
/*  26 */   public static final Integer FACTOR_TYPE_INPUT = Integer.valueOf(20);
/*  27 */   public static final Integer FACTOR_TYPE_CARD = Integer.valueOf(30);
/*     */   
/*     */ 
/*     */   private List children;
/*     */   
/*     */ 
/*     */   private String tab;
/*     */   
/*     */ 
/*     */   private String weight;
/*     */   
/*     */ 
/*     */   private String cardName;
/*     */   
/*     */   private String itemName;
/*     */   
/*     */ 
/*     */   public List getChildren()
/*     */   {
/*  46 */     return this.children;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChildren(List children)
/*     */   {
/*  55 */     this.children = children;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTab()
/*     */   {
/*  63 */     return this.tab;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTab(String tab)
/*     */   {
/*  71 */     this.tab = tab;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWeight()
/*     */   {
/*  79 */     return this.weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWeight(String weight)
/*     */   {
/*  87 */     this.weight = weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCardName()
/*     */   {
/*  95 */     return this.cardName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardName(String cardName)
/*     */   {
/* 103 */     this.cardName = cardName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getItemName()
/*     */   {
/* 111 */     return this.itemName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemName(String itemName)
/*     */   {
/* 119 */     this.itemName = itemName;
/*     */   }
/*     */ }

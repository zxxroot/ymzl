/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableHeaderMetaData
/*     */ {
/*     */   private LinkedList<TableColumn> columns;
/*     */   private LinkedList<TableColumn> leafs;
/*     */   private String common;
/*  32 */   public int maxlevel = 0;
/*     */   
/*     */   public TableHeaderMetaData() {
/*  35 */     this.columns = new LinkedList();
/*  36 */     this.leafs = new LinkedList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addColumn(TableColumn col)
/*     */   {
/*  45 */     setLevel(col, 1);
/*  46 */     this.columns.add(col);
/*  47 */     addLeafColumn(col);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void refresh()
/*     */   {
/*  54 */     this.maxlevel = 1;
/*  55 */     for (TableColumn col : this.columns) {
/*  56 */       if (col.isVisible()) {
/*  57 */         col.level = 1;
/*  58 */         int level = refreshChildren(col);
/*  59 */         if (level > this.maxlevel) {
/*  60 */           this.maxlevel = level;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int refreshChildren(TableColumn parent)
/*     */   {
/*  72 */     if (parent.children.size() != 0) {
/*  73 */       int max = parent.level;
/*  74 */       for (TableColumn col : parent.children) {
/*  75 */         if (col.isVisible()) {
/*  76 */           col.parent = parent;
/*  77 */           parent.level += 1;
/*  78 */           int level = refreshChildren(col);
/*  79 */           if (level > max)
/*  80 */             max = level;
/*     */         }
/*     */       }
/*  83 */       return max;
/*     */     }
/*  85 */     return parent.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setLevel(TableColumn col, int level)
/*     */   {
/*  96 */     col.level = level;
/*  97 */     if ((col.isVisible()) && (level > this.maxlevel)) {
/*  98 */       this.maxlevel = level;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addLeafColumn(TableColumn col)
/*     */   {
/* 107 */     if (col.parent != null)
/* 108 */       setLevel(col, col.parent.level + 1);
/* 109 */     if (col.isComplex()) {
/* 110 */       for (TableColumn c : col.getChildren()) {
/* 111 */         addLeafColumn(c);
/*     */       }
/*     */     } else {
/* 114 */       this.leafs.add(col);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TableColumn> getColumns()
/*     */   {
/* 124 */     return this.leafs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TableColumn> getOriginColumns()
/*     */   {
/* 133 */     LinkedList<TableColumn> ret = new LinkedList();
/* 134 */     for (TableColumn c : this.columns) {
/* 135 */       if (c.isVisible())
/* 136 */         ret.add(c);
/*     */     }
/* 138 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableColumn getColumnAt(int index)
/*     */   {
/* 148 */     return (TableColumn)this.leafs.get(index);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getColumnCount()
/*     */   {
/* 157 */     return this.leafs.size();
/*     */   }
/*     */   
/*     */   public String getCommon() {
/* 161 */     return this.common;
/*     */   }
/*     */   
/*     */   public void setCommon(String common) {
/* 165 */     this.common = common;
/*     */   }
/*     */ }


/* excel\TableHeaderMetaData.class

 */
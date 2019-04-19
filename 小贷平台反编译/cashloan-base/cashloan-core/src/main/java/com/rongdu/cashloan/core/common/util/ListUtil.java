/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListUtil
/*     */ {
/*     */   public static List<Map<String, Object>> treeForExt(List<Map<String, Object>> list, Boolean leafChecked, Boolean rootChecked, Boolean expanded)
/*     */   {
/*  16 */     for (Map rec : list) {
/*  17 */       List<Map<String, Object>> children = (List)rec.get("children");
/*  18 */       if ((children == null) || (children.size() == 0)) {
/*  19 */         rec.put("leaf", Boolean.valueOf(true));
/*  20 */         if (leafChecked != null) {
/*  21 */           rec.put("checked", leafChecked);
/*     */         }
/*     */       } else {
/*  24 */         if (rootChecked != null) {
/*  25 */           rec.put("checked", rootChecked);
/*     */         }
/*  27 */         if (expanded != null) {
/*  28 */           rec.put("expanded", expanded);
/*     */         }
/*  30 */         treeForExt(children, leafChecked, rootChecked, expanded);
/*     */       }
/*     */     }
/*  33 */     return list;
/*     */   }
/*     */   
/*  36 */   public static List<Map<String, Object>> list2Tree(List<Map<String, Object>> list, String idField, String parentField) { List<Map<String, Object>> roots = new ArrayList();
/*  37 */     Map<String, Map> indexor = new LinkedHashMap();
/*  38 */     for (Map rec : list) {
/*  39 */       indexor.put(rec.get(idField).toString(), rec);
/*     */     }
/*  41 */     for (Map rec : list) {
/*  42 */       rec.put(idField, rec.get(idField).toString());
/*  43 */       Map father = (Map)indexor.get(String.valueOf(rec.get(parentField)));
/*  44 */       if (father != null) {
/*  45 */         List<Map> children = (List)father.get("children");
/*  46 */         if (children == null) {
/*  47 */           children = new ArrayList();
/*  48 */           father.put("children", children);
/*     */         }
/*  50 */         children.add(rec);
/*     */       } else {
/*  52 */         roots.add(rec);
/*     */       }
/*     */     }
/*  55 */     return roots;
/*     */   }
/*     */   
/*     */   public static List<Map> listCovertToTree(List<Map> list, String idField, String parentField) {
/*  59 */     List<Map> roots = new ArrayList();
/*  60 */     Map<String, Map<String, Object>> indexor = new LinkedHashMap();
/*  61 */     for (Map<String, Object> rec : list) {
/*  62 */       indexor.put(rec.get(idField).toString(), rec);
/*     */     }
/*  64 */     for (Map<String, Object> rec : list) {
/*  65 */       Map<String, Object> father = (Map)indexor.get(String.valueOf(rec.get(parentField)));
/*  66 */       if (father != null) {
/*  67 */         List<Map<String, Object>> children = (List)father.get("children");
/*  68 */         if (children == null) {
/*  69 */           children = new ArrayList();
/*  70 */           father.put("children", children);
/*     */         }
/*  72 */         children.add(rec);
/*     */       } else {
/*  74 */         roots.add(rec);
/*     */       }
/*     */     }
/*  77 */     return roots;
/*     */   }
/*     */   
/*     */   public static List<Map<String, Object>> treeCovertToExt(List<Map<String, Object>> list, Boolean leafChecked, Boolean rootChecked, Boolean expanded) {
/*  81 */     for (Map<String, Object> rec : list) {
/*  82 */       List<Map<String, Object>> children = (List)rec.get("children");
/*  83 */       if ((children == null) || (children.size() == 0)) {
/*  84 */         rec.put("leaf", Boolean.valueOf(true));
/*  85 */         if (leafChecked != null) {
/*  86 */           rec.put("checked", leafChecked);
/*     */         }
/*     */       } else {
/*  89 */         if (rootChecked != null) {
/*  90 */           rec.put("checked", rootChecked);
/*     */         }
/*  92 */         if (expanded != null) {
/*  93 */           rec.put("expanded", expanded);
/*     */         }
/*  95 */         treeCovertToExt(children, leafChecked, rootChecked, expanded);
/*     */       }
/*     */     }
/*  98 */     return list;
/*     */   }
/*     */   
/*     */ 
/* 102 */   public static String join(List list) { return join(list, ","); }
/*     */   
/*     */   public static String join(List list, String str) {
/* 105 */     StringBuilder sb = new StringBuilder();
/* 106 */     for (int i = 0; i < list.size(); i++) {
/* 107 */       Object o = list.get(i);
/* 108 */       if (i > 0) sb.append(str);
/* 109 */       sb.append(o.toString());
/*     */     }
/* 111 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static long attachCnt(List<Map<String, Object>> list, String textField, String cntField) {
/* 115 */     long cnt = 0L;
/* 116 */     for (Map<String, Object> rec : list) {
/* 117 */       List<Map<String, Object>> children = (List)rec.get("children");
/* 118 */       if ((children == null) || (children.size() == 0)) {
/* 119 */         rec.put("leaf", Boolean.valueOf(true));
/* 120 */         rec.put(textField + "Cnt", rec.get(textField) + "(" + rec.get(cntField) + ")");
/* 121 */         cnt += Long.valueOf(rec.get(cntField).toString()).longValue();
/*     */       } else {
/* 123 */         long c = attachCnt(children, textField, cntField);
/* 124 */         rec.put("expanded", Boolean.valueOf(true));
/* 125 */         rec.put(textField + "Cnt", rec.get(textField) + "(" + c + ")");
/* 126 */         cnt += c;
/*     */       }
/*     */     }
/* 129 */     return cnt;
/*     */   }
/*     */   
/*     */   public static Set<Object> collectProperty(List<Map> list, String property)
/*     */   {
/* 134 */     Set<Object> sets = new LinkedHashSet();
/* 135 */     for (Map map : list) {
/* 136 */       sets.add(map.get(property));
/*     */     }
/* 138 */     return sets;
/*     */   }
/*     */ }


/* ListUtil.class

 */
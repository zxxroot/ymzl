/*     */ package com.rongdu.creditrank.cr.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import tool.util.StringUtil;
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
/*     */ public class RuleInfoDetail
/*     */   implements Serializable
/*     */ {
/*  24 */   public static final Logger logger = LoggerFactory.getLogger(RuleInfoDetail.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String name;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String nid;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  52 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  60 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNid()
/*     */   {
/*  68 */     return this.nid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNid(String nid)
/*     */   {
/*  76 */     this.nid = nid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/*  84 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  92 */     this.type = type;
/*     */   }
/*     */   
/*     */   public boolean valid(RuleInfoDetail detail)
/*     */   {
/*  97 */     boolean flag = false;
/*  98 */     if ((detail != null) && (StringUtil.isNotBlank(detail.getName())) && 
/*  99 */       (StringUtil.isNotBlank(detail.getNid())) && 
/* 100 */       (StringUtil.isNotBlank(detail.getType()))) {
/* 101 */       if ("int".equals(detail.getType())) {
/* 102 */         flag = true;
/* 103 */       } else if ("string".equals(detail.getType())) {
/* 104 */         flag = true;
/*     */       }
/*     */     }
/* 107 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean validOptions(String type, Map<String, String> options) {
/* 111 */     boolean flag = false;
/* 112 */     if ("int".equals(type)) {
/* 113 */       flag = true;
/* 114 */     } else if ((StringUtil.isNotBlank(options)) && ("string".equals(type))) {
/* 115 */       Iterator<String> keys = options.keySet().iterator();
/*     */       
/* 117 */       while (keys.hasNext()) {
/* 118 */         String key = (String)keys.next();
/* 119 */         logger.info(key);
/* 120 */         if ((StringUtil.isNotBlank(key)) && (StringUtil.isNotBlank((CharSequence)options.get(key)))) {
/* 121 */           flag = true;
/*     */         } else {
/* 123 */           flag = false;
/*     */         }
/*     */       }
/*     */     }
/* 127 */     return flag;
/*     */   }
/*     */   
/* 130 */   public boolean validOptions(String type) { boolean flag = false;
/* 131 */     if ("int".equals(type)) {
/* 132 */       flag = true;
/* 133 */     } else if ("string".equals(type)) {
/* 134 */       flag = true;
/*     */     }
/* 136 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean validData(List<RuleInfoDetail> details) {
/* 140 */     boolean flag = false;
/* 141 */     if ((details != null) && (!details.isEmpty())) {
/* 142 */       for (int i = 0; i < details.size(); i++) {
/* 143 */         flag = valid((RuleInfoDetail)details.get(i));
/* 144 */         if (flag) {
/* 145 */           flag = validOptions(((RuleInfoDetail)details.get(i)).getType());
/*     */         }
/* 147 */         if (!flag) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/* 152 */     return flag;
/*     */   }
/*     */ }

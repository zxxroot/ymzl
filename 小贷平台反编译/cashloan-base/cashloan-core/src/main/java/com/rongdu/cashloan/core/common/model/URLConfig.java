/*     */ package com.rongdu.cashloan.core.common.model;
/*     */ 
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
/*     */ public class URLConfig
/*     */ {
/*  16 */   private String protocol = "http";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String host;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   private Integer port = Integer.valueOf(80);
/*     */   
/*  28 */   private String url = null;
/*     */   
/*  30 */   private String contextPath = "";
/*     */   
/*     */   public void init()
/*     */   {
/*  34 */     if (this.url == null) {
/*  35 */       createUrl();
/*     */     }
/*     */   }
/*     */   
/*     */   private void createUrl() {
/*  40 */     StringBuilder sb = new StringBuilder();
/*  41 */     if (StringUtil.isNotBlank(this.protocol)) {
/*  42 */       sb.append(this.protocol).append("://");
/*     */     }
/*  44 */     if (StringUtil.isNotBlank(this.host)) {
/*  45 */       sb.append(this.host);
/*     */     }
/*  47 */     if ((this.port != null) && 
/*  48 */       ((!"http".equals(this.protocol)) || (this.port.intValue() != 80)) && (
/*  49 */       (!"https".equals(this.protocol)) || (this.port.intValue() != 443)))
/*     */     {
/*     */ 
/*  52 */       sb.append(":").append(this.port);
/*     */     }
/*     */     
/*     */ 
/*  56 */     if ((this.contextPath != null) && (!"".equals(this.contextPath)))
/*     */     {
/*     */ 
/*     */ 
/*  60 */       if (this.contextPath.charAt(0) == '/') {
/*  61 */         sb.append(this.contextPath);
/*     */       }
/*     */       else {
/*  64 */         sb.append("/" + this.contextPath);
/*     */       }
/*     */     }
/*     */     
/*  68 */     while (sb.charAt(sb.length() - 1) == '/')
/*     */     {
/*  70 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/*     */     
/*  73 */     this.url = sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/*  83 */     if (this.url == null) {
/*  84 */       createUrl();
/*     */     }
/*  86 */     return this.url;
/*     */   }
/*     */   
/*     */   public String getHost() {
/*  90 */     return this.host;
/*     */   }
/*     */   
/*     */   public void setHost(String host) {
/*  94 */     this.host = host.toLowerCase();
/*     */   }
/*     */   
/*     */   public Integer getPort() {
/*  98 */     return this.port;
/*     */   }
/*     */   
/*     */   public void setPort(Integer port) {
/* 102 */     this.port = port;
/*     */   }
/*     */   
/*     */   public String getProtocol() {
/* 106 */     return this.protocol;
/*     */   }
/*     */   
/*     */   public void setProtocol(String protocol) {
/* 110 */     this.protocol = protocol.toLowerCase();
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 114 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/* 118 */     this.url = url;
/*     */   }
/*     */   
/*     */   public String getContextPath() {
/* 122 */     return this.contextPath;
/*     */   }
/*     */   
/*     */   public void setContextPath(String contextPath) {
/* 126 */     this.contextPath = contextPath;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\model\URLConfig.class

 */
/*     */ package com.cashloan.cl.model.hulu;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import credit.DsCreditRequest;
/*     */ import credit.Header;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HuluCreditRequest
/*     */   extends DsCreditRequest
/*     */ {
/*     */   private String company;
/*     */   private String name;
/*     */   private String id;
/*     */   private String mobile;
/*     */   private String first_contact_name;
/*     */   private String first_contact_type;
/*     */   private String first_contact_cell_phone_number;
/*     */   private String second_contact_name;
/*     */   private String second_contact_type;
/*     */   private String second_contact_cell_phone_number;
/*     */   
/*     */   public String getCompany()
/*     */   {
/*  30 */     return this.company;
/*     */   }
/*     */   
/*     */   public void setCompany(String company) {
/*  34 */     this.company = company;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  38 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  42 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getId() {
/*  46 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(String id) {
/*  50 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/*  54 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/*  58 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public String getFirst_contact_name() {
/*  62 */     return this.first_contact_name;
/*     */   }
/*     */   
/*     */   public void setFirst_contact_name(String first_contact_name) {
/*  66 */     this.first_contact_name = first_contact_name;
/*     */   }
/*     */   
/*     */   public String getFirst_contact_type() {
/*  70 */     return this.first_contact_type;
/*     */   }
/*     */   
/*     */   public void setFirst_contact_type(String first_contact_type) {
/*  74 */     this.first_contact_type = first_contact_type;
/*     */   }
/*     */   
/*     */   public String getFirst_contact_cell_phone_number() {
/*  78 */     return this.first_contact_cell_phone_number;
/*     */   }
/*     */   
/*     */   public void setFirst_contact_cell_phone_number(String first_contact_cell_phone_number) {
/*  82 */     this.first_contact_cell_phone_number = first_contact_cell_phone_number;
/*     */   }
/*     */   
/*     */   public String getSecond_contact_name() {
/*  86 */     return this.second_contact_name;
/*     */   }
/*     */   
/*     */   public void setSecond_contact_name(String second_contact_name) {
/*  90 */     this.second_contact_name = second_contact_name;
/*     */   }
/*     */   
/*     */   public String getSecond_contact_type() {
/*  94 */     return this.second_contact_type;
/*     */   }
/*     */   
/*     */   public void setSecond_contact_type(String second_contact_type) {
/*  98 */     this.second_contact_type = second_contact_type;
/*     */   }
/*     */   
/*     */   public String getSecond_contact_cell_phone_number() {
/* 102 */     return this.second_contact_cell_phone_number;
/*     */   }
/*     */   
/*     */   public void setSecond_contact_cell_phone_number(String second_contact_cell_phone_number) {
/* 106 */     this.second_contact_cell_phone_number = second_contact_cell_phone_number;
/*     */   }
/*     */   
/*     */   public HuluCreditRequest(String host, Header header, String company, String name, String identity, String mobile) {
/* 110 */     super(host, header);
/* 111 */     this.company = company;
/* 112 */     this.name = name;
/* 113 */     this.id = identity;
/* 114 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */ 
/*     */   protected HttpEntity handle()
/*     */     throws Exception
/*     */   {
/* 121 */     Map paramMap = new HashMap();
/* 122 */     paramMap.put("company_account", this.company);
/* 123 */     paramMap.put("name", this.name);
/* 124 */     paramMap.put("identity_card_number", this.id);
/* 125 */     paramMap.put("cell_phone_number", this.mobile);
/*     */     
/* 127 */     String body = JSON.toJSONString(paramMap);
/* 128 */     ContentType jsonType = ContentType.create("application/json", "utf-8");
/* 129 */     return new StringEntity(body, jsonType);
/*     */   }
/*     */ }

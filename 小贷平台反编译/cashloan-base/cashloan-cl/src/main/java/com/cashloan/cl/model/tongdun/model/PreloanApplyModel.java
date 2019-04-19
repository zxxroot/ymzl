/*     */ package com.cashloan.cl.model.tongdun.model;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class PreloanApplyModel
/*     */ {
/*  17 */   private static final Map<String, String> CODE_MESSAGE = new HashMap();
/*     */   
/*  19 */   static { CODE_MESSAGE.put("Accept", "建议通过");
/*  20 */     CODE_MESSAGE.put("Review", "建议审核");
/*  21 */     CODE_MESSAGE.put("Reject", "建议拒绝");
/*     */   }
/*     */   
/*     */   public static String getMessage(String key)
/*     */   {
/*  26 */     return (String)CODE_MESSAGE.get(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String name;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String id_number;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String mobile;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean is_id_checked;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String card_number;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String ip_address;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String token_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String black_box;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_url;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private double loan_amount;
/*     */   
/*     */ 
/*     */ 
/*     */   private Integer loan_term;
/*     */   
/*     */ 
/*     */ 
/*     */   private String loan_term_unit;
/*     */   
/*     */ 
/*     */ 
/*     */   private String purpose;
/*     */   
/*     */ 
/*     */ 
/*     */   private String apply_province;
/*     */   
/*     */ 
/*     */ 
/*     */   private String apply_city;
/*     */   
/*     */ 
/*     */ 
/*     */   private String apply_channel;
/*     */   
/*     */ 
/*     */ 
/*     */   private String loan_date;
/*     */   
/*     */ 
/*     */ 
/*     */   private String work_phone;
/*     */   
/*     */ 
/*     */ 
/*     */   private String home_phone;
/*     */   
/*     */ 
/*     */ 
/*     */   private String qq;
/*     */   
/*     */ 
/*     */ 
/*     */   private String email;
/*     */   
/*     */ 
/*     */ 
/*     */   private String diploma;
/*     */   
/*     */ 
/*     */ 
/*     */   private String marriage;
/*     */   
/*     */ 
/*     */ 
/*     */   private String house_property;
/*     */   
/*     */ 
/*     */ 
/*     */   private String house_type;
/*     */   
/*     */ 
/*     */ 
/*     */   private String registered_address;
/*     */   
/*     */ 
/*     */ 
/*     */   private String home_address;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact_address;
/*     */   
/*     */ 
/*     */ 
/*     */   private String career;
/*     */   
/*     */ 
/*     */ 
/*     */   private String applyer_type;
/*     */   
/*     */ 
/*     */ 
/*     */   private String work_time;
/*     */   
/*     */ 
/*     */ 
/*     */   private String company_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String company_address;
/*     */   
/*     */ 
/*     */ 
/*     */   private String company_industry;
/*     */   
/*     */ 
/*     */ 
/*     */   private String company_type;
/*     */   
/*     */ 
/*     */ 
/*     */   private String occupation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String annual_income;
/*     */   
/*     */ 
/*     */ 
/*     */   private String is_cross_loan;
/*     */   
/*     */ 
/*     */ 
/*     */   private String cross_loan_count;
/*     */   
/*     */ 
/*     */ 
/*     */   private String is_liability_loan;
/*     */   
/*     */ 
/*     */ 
/*     */   private String liability_loan_count;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_relation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_mobile;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_id_number;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_com_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact1_com_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_relation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_mobile;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_id_number;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_com_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact2_com_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_relation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_mobile;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_id_number;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_com_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact3_com_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_relation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_mobile;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_id_number;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_com_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact4_com_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_relation;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_mobile;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_id_number;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_com_name;
/*     */   
/*     */ 
/*     */ 
/*     */   private String contact5_com_addr;
/*     */   
/*     */ 
/*     */ 
/*     */   public String changeRelation(String relation)
/*     */   {
/* 348 */     String relationStr = "";
/* 349 */     if (relation != null) {
/* 350 */       if (relation.contains("父亲")) {
/* 351 */         relationStr = "father";
/* 352 */       } else if (relation.contains("母亲")) {
/* 353 */         relationStr = "mother";
/* 354 */       } else if (relation.contains("配偶")) {
/* 355 */         relationStr = "spouse";
/* 356 */       } else if (relation.contains("子女")) {
/* 357 */         relationStr = "child";
/* 358 */       } else if (relation.contains("其他亲属")) {
/* 359 */         relationStr = "other_relative";
/* 360 */       } else if (relation.contains("朋友")) {
/* 361 */         relationStr = "friend";
/* 362 */       } else if (relation.contains("同事")) {
/* 363 */         relationStr = "coworker";
/* 364 */       } else if (relation.contains("其他")) {
/* 365 */         relationStr = "others";
/*     */       } else {
/* 367 */         relationStr = "others";
/*     */       }
/*     */     } else {
/* 370 */       relationStr = "others";
/*     */     }
/* 372 */     return relationStr;
/*     */   }
/*     */   
/*     */   public String changeMarriage(String marriage) {
/* 376 */     String marriageStr = "";
/* 377 */     if (marriage != null) {
/* 378 */       if (marriage.contains("未婚")) {
/* 379 */         marriageStr = "SPINSTERHOOD";
/* 380 */       } else if (marriage.contains("已婚")) {
/* 381 */         marriageStr = "MARRIED";
/* 382 */       } else if (marriage.contains("离异")) {
/* 383 */         marriageStr = "DIVORCED";
/* 384 */       } else if (marriage.contains("丧偶")) {
/* 385 */         marriageStr = "WIDOWED";
/* 386 */       } else if (marriage.contains("再婚")) {
/* 387 */         marriageStr = "REMARRY ";
/* 388 */       } else if (marriage.contains("复婚")) {
/* 389 */         marriageStr = "REMARRY_FORMER ";
/*     */       } else {
/* 391 */         marriageStr = "";
/*     */       }
/*     */     } else {
/* 394 */       marriageStr = "";
/*     */     }
/* 396 */     return marriageStr;
/*     */   }
/*     */   
/*     */   public String changeDiploma(String diploma) {
/* 400 */     String diplomaStr = "";
/* 401 */     if (diploma != null) {
/* 402 */       if (diploma.contains("高中以下")) {
/* 403 */         diplomaStr = "PRE_HIGH_SCHOOL";
/* 404 */       } else if (diploma.contains("高中/中专")) {
/* 405 */         diplomaStr = "HIGH_SCHOOL";
/* 406 */       } else if (diploma.contains("大专")) {
/* 407 */         diplomaStr = "JUNIOR_COLLEGE";
/* 408 */       } else if (diploma.contains("本科")) {
/* 409 */         diplomaStr = "UNDER_GRADUATE";
/* 410 */       } else if (diploma.contains("研究生")) {
/* 411 */         diplomaStr = "POST_GRADUATE ";
/*     */       } else {
/* 413 */         diplomaStr = "";
/*     */       }
/*     */     } else {
/* 416 */       diplomaStr = "";
/*     */     }
/* 418 */     return diplomaStr;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 422 */     return this.name;
/*     */   }
/*     */   
/* 425 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String getId_number() {
/* 428 */     return this.id_number;
/*     */   }
/*     */   
/* 431 */   public void setId_number(String id_number) { this.id_number = id_number; }
/*     */   
/*     */   public String getMobile() {
/* 434 */     return this.mobile;
/*     */   }
/*     */   
/* 437 */   public void setMobile(String mobile) { this.mobile = mobile; }
/*     */   
/*     */   public boolean getIs_id_checked() {
/* 440 */     return this.is_id_checked;
/*     */   }
/*     */   
/* 443 */   public void setIs_id_checked(boolean is_id_checked) { this.is_id_checked = is_id_checked; }
/*     */   
/*     */   public String getCard_number() {
/* 446 */     return this.card_number;
/*     */   }
/*     */   
/* 449 */   public void setCard_number(String card_number) { this.card_number = card_number; }
/*     */   
/*     */   public String getIp_address() {
/* 452 */     return this.ip_address;
/*     */   }
/*     */   
/* 455 */   public void setIp_address(String ip_address) { this.ip_address = ip_address; }
/*     */   
/*     */   public String getToken_id() {
/* 458 */     return this.token_id;
/*     */   }
/*     */   
/* 461 */   public void setToken_id(String token_id) { this.token_id = token_id; }
/*     */   
/*     */   public String getBlack_box() {
/* 464 */     return this.black_box;
/*     */   }
/*     */   
/* 467 */   public void setBlack_box(String black_box) { this.black_box = black_box; }
/*     */   
/*     */   public String getNotify_url() {
/* 470 */     return this.notify_url;
/*     */   }
/*     */   
/* 473 */   public void setNotify_url(String notify_url) { this.notify_url = notify_url; }
/*     */   
/*     */   public double getLoan_amount() {
/* 476 */     return this.loan_amount;
/*     */   }
/*     */   
/* 479 */   public void setLoan_amount(double loan_amount) { this.loan_amount = loan_amount; }
/*     */   
/*     */   public Integer getLoan_term() {
/* 482 */     return this.loan_term;
/*     */   }
/*     */   
/* 485 */   public void setLoan_term(Integer loan_term) { this.loan_term = loan_term; }
/*     */   
/*     */   public String getLoan_term_unit() {
/* 488 */     return this.loan_term_unit;
/*     */   }
/*     */   
/* 491 */   public void setLoan_term_unit(String loan_term_unit) { this.loan_term_unit = loan_term_unit; }
/*     */   
/*     */   public String getPurpose() {
/* 494 */     return this.purpose;
/*     */   }
/*     */   
/* 497 */   public void setPurpose(String purpose) { this.purpose = purpose; }
/*     */   
/*     */   public String getApply_province() {
/* 500 */     return this.apply_province;
/*     */   }
/*     */   
/* 503 */   public void setApply_province(String apply_province) { this.apply_province = apply_province; }
/*     */   
/*     */   public String getApply_city() {
/* 506 */     return this.apply_city;
/*     */   }
/*     */   
/* 509 */   public void setApply_city(String apply_city) { this.apply_city = apply_city; }
/*     */   
/*     */   public String getApply_channel() {
/* 512 */     return this.apply_channel;
/*     */   }
/*     */   
/* 515 */   public void setApply_channel(String apply_channel) { this.apply_channel = apply_channel; }
/*     */   
/*     */   public String getLoan_date() {
/* 518 */     return this.loan_date;
/*     */   }
/*     */   
/* 521 */   public void setLoan_date(String loan_date) { this.loan_date = loan_date; }
/*     */   
/*     */   public String getWork_phone() {
/* 524 */     return this.work_phone;
/*     */   }
/*     */   
/* 527 */   public void setWork_phone(String work_phone) { this.work_phone = work_phone; }
/*     */   
/*     */   public String getHome_phone() {
/* 530 */     return this.home_phone;
/*     */   }
/*     */   
/* 533 */   public void setHome_phone(String home_phone) { this.home_phone = home_phone; }
/*     */   
/*     */   public String getQq() {
/* 536 */     return this.qq;
/*     */   }
/*     */   
/* 539 */   public void setQq(String qq) { this.qq = qq; }
/*     */   
/*     */   public String getEmail() {
/* 542 */     return this.email;
/*     */   }
/*     */   
/* 545 */   public void setEmail(String email) { this.email = email; }
/*     */   
/*     */   public String getDiploma() {
/* 548 */     return this.diploma;
/*     */   }
/*     */   
/* 551 */   public void setDiploma(String diploma) { this.diploma = changeDiploma(diploma); }
/*     */   
/*     */   public String getMarriage() {
/* 554 */     return this.marriage;
/*     */   }
/*     */   
/* 557 */   public void setMarriage(String marriage) { this.marriage = changeMarriage(marriage); }
/*     */   
/*     */   public String getHouse_property() {
/* 560 */     return this.house_property;
/*     */   }
/*     */   
/* 563 */   public void setHouse_property(String house_property) { this.house_property = house_property; }
/*     */   
/*     */   public String getHouse_type() {
/* 566 */     return this.house_type;
/*     */   }
/*     */   
/* 569 */   public void setHouse_type(String house_type) { this.house_type = house_type; }
/*     */   
/*     */   public String getRegistered_address() {
/* 572 */     return this.registered_address;
/*     */   }
/*     */   
/* 575 */   public void setRegistered_address(String registered_address) { this.registered_address = registered_address; }
/*     */   
/*     */   public String getHome_address() {
/* 578 */     return this.home_address;
/*     */   }
/*     */   
/* 581 */   public void setHome_address(String home_address) { this.home_address = home_address; }
/*     */   
/*     */   public String getContact_address() {
/* 584 */     return this.contact_address;
/*     */   }
/*     */   
/* 587 */   public void setContact_address(String contact_address) { this.contact_address = contact_address; }
/*     */   
/*     */   public String getCareer() {
/* 590 */     return this.career;
/*     */   }
/*     */   
/* 593 */   public void setCareer(String career) { this.career = career; }
/*     */   
/*     */   public String getApplyer_type() {
/* 596 */     return this.applyer_type;
/*     */   }
/*     */   
/* 599 */   public void setApplyer_type(String applyer_type) { this.applyer_type = applyer_type; }
/*     */   
/*     */   public String getWork_time() {
/* 602 */     return this.work_time;
/*     */   }
/*     */   
/* 605 */   public void setWork_time(String work_time) { this.work_time = work_time; }
/*     */   
/*     */   public String getCompany_name() {
/* 608 */     return this.company_name;
/*     */   }
/*     */   
/* 611 */   public void setCompany_name(String company_name) { this.company_name = company_name; }
/*     */   
/*     */   public String getCompany_address() {
/* 614 */     return this.company_address;
/*     */   }
/*     */   
/* 617 */   public void setCompany_address(String company_address) { this.company_address = company_address; }
/*     */   
/*     */   public String getCompany_industry() {
/* 620 */     return this.company_industry;
/*     */   }
/*     */   
/* 623 */   public void setCompany_industry(String company_industry) { this.company_industry = company_industry; }
/*     */   
/*     */   public String getCompany_type() {
/* 626 */     return this.company_type;
/*     */   }
/*     */   
/* 629 */   public void setCompany_type(String company_type) { this.company_type = company_type; }
/*     */   
/*     */   public String getOccupation() {
/* 632 */     return this.occupation;
/*     */   }
/*     */   
/* 635 */   public void setOccupation(String occupation) { this.occupation = occupation; }
/*     */   
/*     */   public String getAnnual_income() {
/* 638 */     return this.annual_income;
/*     */   }
/*     */   
/* 641 */   public void setAnnual_income(String annual_income) { this.annual_income = annual_income; }
/*     */   
/*     */   public String getIs_cross_loan() {
/* 644 */     return this.is_cross_loan;
/*     */   }
/*     */   
/* 647 */   public void setIs_cross_loan(String is_cross_loan) { this.is_cross_loan = is_cross_loan; }
/*     */   
/*     */   public String getCross_loan_count() {
/* 650 */     return this.cross_loan_count;
/*     */   }
/*     */   
/* 653 */   public void setCross_loan_count(String cross_loan_count) { this.cross_loan_count = cross_loan_count; }
/*     */   
/*     */   public String getIs_liability_loan() {
/* 656 */     return this.is_liability_loan;
/*     */   }
/*     */   
/* 659 */   public void setIs_liability_loan(String is_liability_loan) { this.is_liability_loan = is_liability_loan; }
/*     */   
/*     */   public String getLiability_loan_count() {
/* 662 */     return this.liability_loan_count;
/*     */   }
/*     */   
/* 665 */   public void setLiability_loan_count(String liability_loan_count) { this.liability_loan_count = liability_loan_count; }
/*     */   
/*     */   public String getContact1_relation() {
/* 668 */     return this.contact1_relation;
/*     */   }
/*     */   
/* 671 */   public void setContact1_relation(String contact1_relation) { this.contact1_relation = changeRelation(contact1_relation); }
/*     */   
/*     */   public String getContact1_name() {
/* 674 */     return this.contact1_name;
/*     */   }
/*     */   
/* 677 */   public void setContact1_name(String contact1_name) { this.contact1_name = contact1_name; }
/*     */   
/*     */   public String getContact1_mobile() {
/* 680 */     return this.contact1_mobile;
/*     */   }
/*     */   
/* 683 */   public void setContact1_mobile(String contact1_mobile) { this.contact1_mobile = contact1_mobile; }
/*     */   
/*     */   public String getContact1_id_number() {
/* 686 */     return this.contact1_id_number;
/*     */   }
/*     */   
/* 689 */   public void setContact1_id_number(String contact1_id_number) { this.contact1_id_number = contact1_id_number; }
/*     */   
/*     */   public String getContact1_addr() {
/* 692 */     return this.contact1_addr;
/*     */   }
/*     */   
/* 695 */   public void setContact1_addr(String contact1_addr) { this.contact1_addr = contact1_addr; }
/*     */   
/*     */   public String getContact1_com_name() {
/* 698 */     return this.contact1_com_name;
/*     */   }
/*     */   
/* 701 */   public void setContact1_com_name(String contact1_com_name) { this.contact1_com_name = contact1_com_name; }
/*     */   
/*     */   public String getContact1_com_addr() {
/* 704 */     return this.contact1_com_addr;
/*     */   }
/*     */   
/* 707 */   public void setContact1_com_addr(String contact1_com_addr) { this.contact1_com_addr = contact1_com_addr; }
/*     */   
/*     */   public String getContact2_relation() {
/* 710 */     return this.contact2_relation;
/*     */   }
/*     */   
/* 713 */   public void setContact2_relation(String contact2_relation) { this.contact2_relation = changeRelation(contact2_relation); }
/*     */   
/*     */   public String getContact2_name() {
/* 716 */     return this.contact2_name;
/*     */   }
/*     */   
/* 719 */   public void setContact2_name(String contact2_name) { this.contact2_name = contact2_name; }
/*     */   
/*     */   public String getContact2_mobile() {
/* 722 */     return this.contact2_mobile;
/*     */   }
/*     */   
/* 725 */   public void setContact2_mobile(String contact2_mobile) { this.contact2_mobile = contact2_mobile; }
/*     */   
/*     */   public String getContact2_id_number() {
/* 728 */     return this.contact2_id_number;
/*     */   }
/*     */   
/* 731 */   public void setContact2_id_number(String contact2_id_number) { this.contact2_id_number = contact2_id_number; }
/*     */   
/*     */   public String getContact2_addr() {
/* 734 */     return this.contact2_addr;
/*     */   }
/*     */   
/* 737 */   public void setContact2_addr(String contact2_addr) { this.contact2_addr = contact2_addr; }
/*     */   
/*     */   public String getContact2_com_name() {
/* 740 */     return this.contact2_com_name;
/*     */   }
/*     */   
/* 743 */   public void setContact2_com_name(String contact2_com_name) { this.contact2_com_name = contact2_com_name; }
/*     */   
/*     */   public String getContact2_com_addr() {
/* 746 */     return this.contact2_com_addr;
/*     */   }
/*     */   
/* 749 */   public void setContact2_com_addr(String contact2_com_addr) { this.contact2_com_addr = contact2_com_addr; }
/*     */   
/*     */   public String getContact3_relation() {
/* 752 */     return this.contact3_relation;
/*     */   }
/*     */   
/* 755 */   public void setContact3_relation(String contact3_relation) { this.contact3_relation = changeRelation(contact3_relation); }
/*     */   
/*     */   public String getContact3_name() {
/* 758 */     return this.contact3_name;
/*     */   }
/*     */   
/* 761 */   public void setContact3_name(String contact3_name) { this.contact3_name = contact3_name; }
/*     */   
/*     */   public String getContact3_mobile() {
/* 764 */     return this.contact3_mobile;
/*     */   }
/*     */   
/* 767 */   public void setContact3_mobile(String contact3_mobile) { this.contact3_mobile = contact3_mobile; }
/*     */   
/*     */   public String getContact3_id_number() {
/* 770 */     return this.contact3_id_number;
/*     */   }
/*     */   
/* 773 */   public void setContact3_id_number(String contact3_id_number) { this.contact3_id_number = contact3_id_number; }
/*     */   
/*     */   public String getContact3_addr() {
/* 776 */     return this.contact3_addr;
/*     */   }
/*     */   
/* 779 */   public void setContact3_addr(String contact3_addr) { this.contact3_addr = contact3_addr; }
/*     */   
/*     */   public String getContact3_com_name() {
/* 782 */     return this.contact3_com_name;
/*     */   }
/*     */   
/* 785 */   public void setContact3_com_name(String contact3_com_name) { this.contact3_com_name = contact3_com_name; }
/*     */   
/*     */   public String getContact3_com_addr() {
/* 788 */     return this.contact3_com_addr;
/*     */   }
/*     */   
/* 791 */   public void setContact3_com_addr(String contact3_com_addr) { this.contact3_com_addr = contact3_com_addr; }
/*     */   
/*     */   public String getContact4_relation() {
/* 794 */     return this.contact4_relation;
/*     */   }
/*     */   
/* 797 */   public void setContact4_relation(String contact4_relation) { this.contact4_relation = changeRelation(contact4_relation); }
/*     */   
/*     */   public String getContact4_name() {
/* 800 */     return this.contact4_name;
/*     */   }
/*     */   
/* 803 */   public void setContact4_name(String contact4_name) { this.contact4_name = contact4_name; }
/*     */   
/*     */   public String getContact4_mobile() {
/* 806 */     return this.contact4_mobile;
/*     */   }
/*     */   
/* 809 */   public void setContact4_mobile(String contact4_mobile) { this.contact4_mobile = contact4_mobile; }
/*     */   
/*     */   public String getContact4_id_number() {
/* 812 */     return this.contact4_id_number;
/*     */   }
/*     */   
/* 815 */   public void setContact4_id_number(String contact4_id_number) { this.contact4_id_number = contact4_id_number; }
/*     */   
/*     */   public String getContact4_addr() {
/* 818 */     return this.contact4_addr;
/*     */   }
/*     */   
/* 821 */   public void setContact4_addr(String contact4_addr) { this.contact4_addr = contact4_addr; }
/*     */   
/*     */   public String getContact4_com_name() {
/* 824 */     return this.contact4_com_name;
/*     */   }
/*     */   
/* 827 */   public void setContact4_com_name(String contact4_com_name) { this.contact4_com_name = contact4_com_name; }
/*     */   
/*     */   public String getContact4_com_addr() {
/* 830 */     return this.contact4_com_addr;
/*     */   }
/*     */   
/* 833 */   public void setContact4_com_addr(String contact4_com_addr) { this.contact4_com_addr = contact4_com_addr; }
/*     */   
/*     */   public String getContact5_relation() {
/* 836 */     return this.contact5_relation;
/*     */   }
/*     */   
/* 839 */   public void setContact5_relation(String contact5_relation) { this.contact5_relation = changeRelation(contact5_relation); }
/*     */   
/*     */   public String getContact5_name() {
/* 842 */     return this.contact5_name;
/*     */   }
/*     */   
/* 845 */   public void setContact5_name(String contact5_name) { this.contact5_name = contact5_name; }
/*     */   
/*     */   public String getContact5_mobile() {
/* 848 */     return this.contact5_mobile;
/*     */   }
/*     */   
/* 851 */   public void setContact5_mobile(String contact5_mobile) { this.contact5_mobile = contact5_mobile; }
/*     */   
/*     */   public String getContact5_id_number() {
/* 854 */     return this.contact5_id_number;
/*     */   }
/*     */   
/* 857 */   public void setContact5_id_number(String contact5_id_number) { this.contact5_id_number = contact5_id_number; }
/*     */   
/*     */   public String getContact5_addr() {
/* 860 */     return this.contact5_addr;
/*     */   }
/*     */   
/* 863 */   public void setContact5_addr(String contact5_addr) { this.contact5_addr = contact5_addr; }
/*     */   
/*     */   public String getContact5_com_name() {
/* 866 */     return this.contact5_com_name;
/*     */   }
/*     */   
/* 869 */   public void setContact5_com_name(String contact5_com_name) { this.contact5_com_name = contact5_com_name; }
/*     */   
/*     */   public String getContact5_com_addr() {
/* 872 */     return this.contact5_com_addr;
/*     */   }
/*     */   
/* 875 */   public void setContact5_com_addr(String contact5_com_addr) { this.contact5_com_addr = contact5_com_addr; }
/*     */ }

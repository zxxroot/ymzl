/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import tool.util.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidateUtil
/*    */ {
/*    */   private static Map<String, Object> map;
/*    */   
/*    */   public static boolean isUser_name(String user_name)
/*    */   {
/* 28 */     Pattern p = Pattern.compile("^(?![0-9]+$)[0-9A-Za-zΑ-￥]{2,15}$");
/* 29 */     Matcher m = p.matcher(user_name);
/* 30 */     return m.matches();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isChinese(String str)
/*    */   {
/* 40 */     String str_ = StringUtil.isNull(str);
/* 41 */     Pattern regex = Pattern.compile("[\\u4e00-\\u9fa5]{2,25}");
/* 42 */     Matcher matcher = regex.matcher(str_);
/*    */     
/* 44 */     return matcher.matches();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isEmail(String email)
/*    */   {
/* 54 */     String email_ = StringUtil.isNull(email);
/* 55 */     Pattern regex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
/* 56 */     Matcher matcher = regex.matcher(email_);
/* 57 */     return matcher.matches();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isPhone(String phone)
/*    */   {
/* 67 */     String phone_ = StringUtil.isNull(phone);
/* 68 */     Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
/* 69 */     Matcher matcher = regex.matcher(phone_);
/* 70 */     boolean isMatched = matcher.matches();
/* 71 */     return isMatched;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Map<String, Object> checkPhone(String phone)
/*    */   {
/* 81 */     map = new HashMap();
/* 82 */     map.put("result", Boolean.valueOf(false));
/* 83 */     if (StringUtil.isBlank(phone)) {
/* 84 */       map.put("message", "请输入手机号！");
/* 85 */       return map;
/*    */     }
/* 87 */     if (!isPhone(phone)) {
/* 88 */       map.put("message", "请输入正确的11位手机号！");
/*    */     } else {
/* 90 */       map.put("result", Boolean.valueOf(true));
/*    */     }
/* 92 */     return map;
/*    */   }
/*    */ }

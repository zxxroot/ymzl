/*     */ package com.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */

import com.rongdu.cashloan.cl.model.pay.fuiou.utils.RSAUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
/*     */ public class SignatureUtil
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(SignatureUtil.class);
/*     */   
/*     */   public static boolean validate(Object bean, String key) {
/*  25 */     List<String> values = new ArrayList();
/*  26 */     String signature = null;
/*  27 */     Method[] arrayOfMethod; int j = (arrayOfMethod = bean.getClass().getMethods()).length; for (int i = 0; i < j; i++) { Method method = arrayOfMethod[i];
/*     */       try {
/*  29 */         if ((method.getName().startsWith("get")) && (!"getClass".equalsIgnoreCase(method.getName())))
/*     */         {
/*  31 */           Object o = method.invoke(bean, null);
/*  32 */           if ((o != null) && (StringUtils.isNotEmpty(o.toString()))) {
/*  33 */             if ("getSignature".equalsIgnoreCase(method.getName().toLowerCase())) {
/*  34 */               signature = o.toString();
/*     */             } else
/*  36 */               values.add(o.toString());
/*     */           }
/*     */         }
/*     */       } catch (IllegalArgumentException e) {
/*  40 */         e.printStackTrace();
/*     */       } catch (IllegalAccessException e) {
/*  42 */         e.printStackTrace();
/*     */       } catch (InvocationTargetException e) {
/*  44 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  47 */     String localSignature = hex(values, key);
/*  48 */     return localSignature.equalsIgnoreCase(signature);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean validateRsa(Object bean, String key)
/*     */   {
/*  57 */     logger.debug("validateRsa  start ");
/*  58 */     List<String> values = new ArrayList();
/*  59 */     String signature = null;
/*  60 */     Method[] arrayOfMethod; int j = (arrayOfMethod = bean.getClass().getMethods()).length; for (int i = 0; i < j; i++) { Method method = arrayOfMethod[i];
/*     */       try {
/*  62 */         if ((method.getName().startsWith("get")) && (!"getClass".equalsIgnoreCase(method.getName())))
/*     */         {
/*  64 */           Object o = method.invoke(bean, null);
/*  65 */           if ((o != null) && (StringUtils.isNotEmpty(o.toString()))) {
/*  66 */             if ("getSignature".equalsIgnoreCase(method.getName().toLowerCase())) {
/*  67 */               signature = o.toString();
/*     */             } else
/*  69 */               values.add(o.toString());
/*     */           }
/*     */         }
/*     */       } catch (IllegalArgumentException e) {
/*  73 */         e.printStackTrace();
/*     */       } catch (IllegalAccessException e) {
/*  75 */         e.printStackTrace();
/*     */       } catch (InvocationTargetException e) {
/*  77 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  80 */     String[] strs = new String[values.size()];
/*  81 */     for (int i = 0; i < strs.length; i++) {
/*  82 */       strs[i] = ((String)values.get(i));
/*     */     }
/*  84 */     Arrays.sort(strs);
/*  85 */     StringBuffer source = new StringBuffer();
/*  86 */     String[] arrayOfString1;int e = (arrayOfString1 = strs).length;
for (int i = 0; i < e; i++) { String str = arrayOfString1[i];
/*  87 */       source.append(str).append("|");
/*     */     }
/*  89 */     String bigstr = source.substring(0, source.length() - 1);
/*  90 */     logger.debug("RSAbigstr:" + bigstr);
/*     */     try {
/*  92 */       return RSAUtils.verify(bigstr.getBytes(), key, signature);
/*     */     } catch (Exception ex) {
/*  94 */       logger.debug("RSAbigstr验签出错");
/*  95 */       ex.printStackTrace();
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public static String hex(List<String> values, String key) {
/* 101 */     String[] strs = new String[values.size()];
/* 102 */     for (int i = 0; i < strs.length; i++) {
/* 103 */       strs[i] = ((String)values.get(i));
/*     */     }
/* 105 */     Arrays.sort(strs);
/* 106 */     StringBuffer source = new StringBuffer();
/* 107 */     String[] arrayOfString1; int j = (arrayOfString1 = strs).length; for (int i = 0; i < j; i++) { String str = arrayOfString1[i];
/* 108 */       source.append(str).append("|");
/*     */     }
/* 110 */     String bigstr = source.substring(0, source.length() - 1);
/* 111 */     logger.debug("bigstr:" + bigstr);
/* 112 */     System.out.println(bigstr);
/* 113 */     System.out.println(DigestUtils.shaHex(bigstr));
/* 114 */     String result = DigestUtils.shaHex(DigestUtils.shaHex(bigstr) + "|" + key);
/* 115 */     logger.debug("bigstr hex result:" + result);
/* 116 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 126 */     String x = DigestUtils.shaHex("0|0002900F0345178|01|0103|13852816377|320321199008231211|6228480031697372923|AC01|DSF|似曾相识|备注");
/* 127 */     System.out.println(x);
/* 128 */     System.out.println(DigestUtils.shaHex(x + "|123456"));
/*     */   }
/*     */ }

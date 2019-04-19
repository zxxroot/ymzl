/*     */ package com.cashloan.cl.model.tongdun.util;
/*     */ 
/*     */

import org.apache.log4j.Logger;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

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
/*     */ public class EncryptUtil
/*     */ {
/*  18 */   private static final Logger logger = Logger.getLogger(EncryptUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static MultiValueMap<String, Object> postFormAndEncoder(Map<String, Object> paramMap, boolean urlEncode)
/*     */   {
/*  27 */     MultiValueMap<String, Object> encodeMap = new LinkedMultiValueMap();
/*  28 */     if (paramMap != null) {
/*  29 */       List<Map.Entry<String, Object>> infoIds = new ArrayList(paramMap.entrySet());
/*     */       
/*  31 */       Collections.sort(infoIds, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)((Map.Entry<String, Object>)o1).getKey()).compareTo((String)((Map.Entry<String, Object>)o2).getKey());
            }
/*     */       });
/*     */       try {
/*  37 */         for (Map.Entry<String, Object> set : infoIds) {
/*  38 */           encodeMap.add((String)set.getKey(), urlEncode ? URLEncoder.encode((String)set.getValue(), "utf-8") : String.valueOf(set.getValue()));
/*     */         }
/*     */       } catch (UnsupportedEncodingException e) {
/*  41 */         logger.error(e);
/*     */       }
/*     */     }
/*  44 */     return encodeMap;
/*     */   }
/*     */   
/*     */   public static String urlParamStrAndEncoder(Map<String, Object> paramMap, boolean urlEncode)
/*     */   {
/*  49 */     StringBuilder sb = new StringBuilder();
/*  50 */     if (paramMap != null) {
/*  51 */       List<Map.Entry<String, Object>> infoIds = new ArrayList(paramMap.entrySet());
/*     */
/*  53 */       Collections.sort(infoIds, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((String)((Map.Entry<String, Object>)o1).getKey()).compareTo((String)((Map.Entry<String, Object>)o2).getKey());
                    }
/*     */       });
/*     */       try {
/*  59 */         int n = 0;
/*  60 */         for (Map.Entry<String, Object> set : infoIds) {
/*  61 */           if (n == 0) {
/*  62 */             n++;
/*  63 */             if (urlEncode) {
/*  64 */               sb.append((String)set.getKey() + "=" + URLEncoder.encode((String)set.getValue(), "utf-8"));
/*     */             } else {
/*  66 */               sb.append((String)set.getKey() + "=" + set.getValue());
/*     */             }
/*     */           }
/*  69 */           else if (urlEncode) {
/*  70 */             sb.append("&" + (String)set.getKey() + "=" + URLEncoder.encode((String)set.getValue(), "utf-8"));
/*     */           } else {
/*  72 */             sb.append("&" + (String)set.getKey() + "=" + set.getValue());
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {
/*  77 */         logger.error(e);
/*     */       }
/*     */     }
/*  80 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String MD5Encode(String sourceString) {
/*  84 */     String resultString = null;
/*     */     try {
/*  86 */       resultString = new String(sourceString);
/*  87 */       MessageDigest md = MessageDigest.getInstance("MD5");
/*  88 */       resultString = byte2hexString(md.digest(resultString.getBytes()));
/*     */     }
/*     */     catch (Exception localException) {}
/*  91 */     return resultString;
/*     */   }
/*     */   
/*     */   private static final String byte2hexString(byte[] bytes) {
/*  95 */     StringBuffer bf = new StringBuffer(bytes.length * 2);
/*  96 */     for (int i = 0; i < bytes.length; i++) {
/*  97 */       if ((bytes[i] & 0xFF) < 16) {
/*  98 */         bf.append("0");
/*     */       }
/* 100 */       bf.append(Long.toString(bytes[i] & 0xFF, 16));
/*     */     }
/* 102 */     return bf.toString();
/*     */   }
/*     */ }

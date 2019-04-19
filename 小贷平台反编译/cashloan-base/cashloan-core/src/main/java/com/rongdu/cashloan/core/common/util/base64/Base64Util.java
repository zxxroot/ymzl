/*    */ package com.rongdu.cashloan.core.common.util.base64;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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
/*    */ 
/*    */ 
/*    */ public class Base64Util
/*    */ {
/* 22 */   public static final Logger logger = LoggerFactory.getLogger(Base64Util.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String base64Encode(String str)
/*    */   {
/* 30 */     Base64Encoder encoder = new Base64Encoder();
/* 31 */     String result = encoder.encode(str.getBytes());
/* 32 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String base64Encode(byte[] b)
/*    */   {
/* 41 */     Base64Encoder encoder = new Base64Encoder();
/* 42 */     String result = encoder.encode(b);
/* 43 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String base64Decode(String str)
/*    */   {
/*    */     try
/*    */     {
/* 54 */       if (StringUtil.isNotBlank(str)) {
/* 55 */         Base64Decoder decoder = new Base64Decoder();
/* 56 */         return decoder.decodeStr(str);
/*    */       }
/*    */       
/* 59 */       return null;
/*    */     }
/*    */     catch (IOException e) {
/* 62 */       logger.error(e.getMessage(), e);
/*    */     }
/* 64 */     return "";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static byte[] base64DecodeToArray(String str)
/*    */   {
/*    */     try
/*    */     {
/* 74 */       if (StringUtil.isNotBlank(str)) {
/* 75 */         Base64Decoder decoder = new Base64Decoder();
/* 76 */         return decoder.decodeBuffer(str);
/*    */       }
/* 78 */       return null;
/*    */     }
/*    */     catch (IOException e) {
/* 81 */       logger.error(e.getMessage(), e);
/*    */     }
/* 83 */     return null;
/*    */   }
/*    */ }


/*Base64Util.class

 */
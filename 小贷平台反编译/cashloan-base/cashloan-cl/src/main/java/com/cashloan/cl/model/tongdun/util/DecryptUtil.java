/*    */ package com.cashloan.cl.model.tongdun.util;
/*    */ 
/*    */ import com.sun.crypto.provider.SunJCE;
/*    */ import java.security.Key;
/*    */ import java.security.Security;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ import org.apache.log4j.LogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class DecryptUtil
/*    */ {
/* 14 */   public static Logger logger = LogManager.getLogger("DecryptUtil");
/* 15 */   private static String strDefaultKey = "ryt-tec";
/* 16 */   private Cipher decryptCipher = null;
/*    */   
/* 18 */   public DecryptUtil() throws Exception { this(strDefaultKey); }
/*    */   
/*    */   public DecryptUtil(String strKey) throws Exception
/*    */   {
/* 22 */     Security.addProvider(new SunJCE());
/* 23 */     Key key = getKey(strKey.getBytes());
/* 24 */     this.decryptCipher = Cipher.getInstance("DES");
/* 25 */     this.decryptCipher.init(2, key);
/*    */   }
/*    */   
/*    */   public static byte[] hexStr2ByteArr(String strIn) throws Exception
/*    */   {
/* 30 */     byte[] arrB = strIn.getBytes();
/* 31 */     int iLen = arrB.length;
/* 32 */     byte[] arrOut = new byte[iLen / 2];
/* 33 */     for (int i = 0; i < iLen; i += 2) {
/* 34 */       String strTmp = new String(arrB, i, 2);
/* 35 */       arrOut[(i / 2)] = ((byte)Integer.parseInt(strTmp, 16));
/*    */     }
/* 37 */     return arrOut;
/*    */   }
/*    */   
/*    */   private static Key getKey(byte[] arrBTmp) throws Exception
/*    */   {
/* 42 */     byte[] arrB = new byte[8];
/* 43 */     for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); i++) {
/* 44 */       arrB[i] = arrBTmp[i];
/*    */     }
/* 46 */     Key key = new SecretKeySpec(arrB, "DES");
/* 47 */     return key;
/*    */   }
/*    */   
/*    */   public byte[] decrypt(byte[] arrB) throws Exception {
/* 51 */     return this.decryptCipher.doFinal(arrB);
/*    */   }
/*    */   
/*    */   public String decrypt(String strIn) throws Exception {
/* 55 */     return new String(decrypt(hexStr2ByteArr(strIn)));
/*    */   }
/*    */   
/*    */   public String decryptStr(String phone) throws Exception {
/* 59 */     DecryptUtil des = new DecryptUtil("ryt-tec");
/* 60 */     return des.decrypt(phone);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/*    */     try {
/* 65 */       String test = "7aebb982c417f91361ace5ac31038fcd";
/* 66 */       DecryptUtil des = new DecryptUtil("fd9300358a70f2ac");
/* 67 */       String dt = des.decrypt(test);
/* 68 */       logger.info("解密后的字符：" + dt);
/*    */     } catch (Exception e) {
/* 70 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

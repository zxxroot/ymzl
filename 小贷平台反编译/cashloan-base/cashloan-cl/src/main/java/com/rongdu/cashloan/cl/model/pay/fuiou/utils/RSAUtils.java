package com.rongdu.cashloan.cl.model.pay.fuiou.utils;
import org.apache.commons.lang.StringUtils;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
/*     */ public class RSAUtils
/*     */ {
/*     */   public static final String KEY_ALGORITHM = "RSA";
/*     */   public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
/*     */   private static final String PUBLIC_KEY = "RSAPublicKey";
/*     */   private static final String PRIVATE_KEY = "RSAPrivateKey";
/*     */   private static final int MAX_ENCRYPT_BLOCK = 234;
/*     */   private static final int MAX_DECRYPT_BLOCK = 256;
/*     */   private static final String RSA_VER = "3.0";
/*     */
/*     */   public static Map<String, Object> genKeyPair()
/*     */     throws Exception
/*     */   {
/*  75 */     KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
/*  76 */     keyPairGen.initialize(2048);
/*  77 */     KeyPair keyPair = keyPairGen.generateKeyPair();
/*  78 */     RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
/*  79 */     RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
/*  80 */     Map<String, Object> keyMap = new HashMap(2);
/*  81 */     keyMap.put("RSAPublicKey", publicKey);
/*  82 */     keyMap.put("RSAPrivateKey", privateKey);
/*  83 */     return keyMap;
/*     */   }
/*     */   public static String sign(byte[] data, String privateKey)
/*     */     throws Exception
/*     */   {
/*  94 */     byte[] keyBytes =Base64Utils.decode(privateKey);
/*  95 */     PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
/*  96 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/*  97 */     PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
/*  98 */     Signature signature = Signature.getInstance("SHA256withRSA");
/*  99 */     signature.initSign(privateK);
/* 100 */     signature.update(data);
/* 101 */     return Base64Utils.encode(signature.sign());
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static boolean verify(byte[] data, String publicKey, String sign)
/*     */     throws Exception
/*     */   {
/* 114 */     byte[] keyBytes = Base64Utils.decode(publicKey);
/* 115 */     X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
/* 116 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 117 */     PublicKey publicK = keyFactory.generatePublic(keySpec);
/* 118 */     Signature signature = Signature.getInstance("SHA256withRSA");
/* 119 */     signature.initVerify(publicK);
/* 120 */     signature.update(data);
/* 121 */     return signature.verify(Base64Utils.decode(sign));
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
/*     */     throws Exception
/*     */   {
/* 133 */     byte[] keyBytes = Base64Utils.decode(privateKey);
/* 134 */     PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
/* 135 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 136 */     Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
/* 137 */     Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
/* 138 */     cipher.init(2, privateK);
/* 139 */     int inputLen = encryptedData.length;
/* 140 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 141 */     int offSet = 0;
/*     */
/* 143 */     int i = 0;
/*     */
/* 145 */     while (inputLen - offSet > 0) {
/* 146 */       byte[] cache; if (inputLen - offSet > 256) {
/* 147 */         cache = cipher.doFinal(encryptedData, offSet, 256);
/*     */       } else {
/* 149 */         cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
/*     */       }
/* 151 */       out.write(cache, 0, cache.length);
/* 152 */       i++;
/* 153 */       offSet = i * 256;
/*     */     }
/* 155 */     byte[] decryptedData = out.toByteArray();
/* 156 */     out.close();
/* 157 */     return decryptedData;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
/*     */     throws Exception
/*     */   {
/* 169 */     byte[] keyBytes = Base64Utils.decode(publicKey);
/* 170 */     X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
/* 171 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 172 */     Key publicK = keyFactory.generatePublic(x509KeySpec);
/* 173 */     Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
/* 174 */     cipher.init(2, publicK);
/* 175 */     int inputLen = encryptedData.length;
/* 176 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 177 */     int offSet = 0;
/*     */
/* 179 */     int i = 0;
/*     */
/* 181 */     while (inputLen - offSet > 0) {
/* 182 */       byte[] cache; if (inputLen - offSet > 256) {
/* 183 */         cache = cipher.doFinal(encryptedData, offSet, 256);
/*     */       } else {
/* 185 */         cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
/*     */       }
/* 187 */       out.write(cache, 0, cache.length);
/* 188 */       i++;
/* 189 */       offSet = i * 256;
/*     */     }
/* 191 */     byte[] decryptedData = out.toByteArray();
/* 192 */     out.close();
/* 193 */     return decryptedData;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static byte[] encryptByPublicKey(byte[] data, String publicKey)
/*     */     throws Exception
/*     */   {
/* 205 */     byte[] keyBytes = Base64Utils.decode(publicKey);
/* 206 */     X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
/* 207 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 208 */     Key publicK = keyFactory.generatePublic(x509KeySpec);
/*     */
/* 210 */     Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
/* 211 */     cipher.init(1, publicK);
/* 212 */     int inputLen = data.length;
/* 213 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 214 */     int offSet = 0;
/*     */
/* 216 */     int i = 0;
/*     */
/* 218 */     while (inputLen - offSet > 0) {
/* 219 */       byte[] cache; if (inputLen - offSet > 234) {
/* 220 */         cache = cipher.doFinal(data, offSet, 234);
/*     */       } else {
/* 222 */         cache = cipher.doFinal(data, offSet, inputLen - offSet);
/*     */       }
/* 224 */       out.write(cache, 0, cache.length);
/* 225 */       i++;
/* 226 */       offSet = i * 234;
/*     */     }
/* 228 */     byte[] encryptedData = out.toByteArray();
/* 229 */     out.close();
/* 230 */     return encryptedData;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
/*     */     throws Exception
/*     */   {
/* 242 */     byte[] keyBytes = Base64Utils.decode(privateKey);
/* 243 */     PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
/* 244 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 245 */     Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
/* 246 */     Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
/* 247 */     cipher.init(1, privateK);
/* 248 */     int inputLen = data.length;
/* 249 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 250 */     int offSet = 0;
/*     */
/* 252 */     int i = 0;
/*     */
/* 254 */     while (inputLen - offSet > 0) {
/* 255 */       byte[] cache; if (inputLen - offSet > 234) {
/* 256 */         cache = cipher.doFinal(data, offSet, 234);
/*     */       } else {
/* 258 */         cache = cipher.doFinal(data, offSet, inputLen - offSet);
/*     */       }
/* 260 */       out.write(cache, 0, cache.length);
/* 261 */       i++;
/* 262 */       offSet = i * 234;
/*     */     }
/* 264 */     byte[] encryptedData = out.toByteArray();
/* 265 */     out.close();
/* 266 */     return encryptedData;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static String getPrivateKey(Map<String, Object> keyMap)
/*     */     throws Exception
/*     */   {
/* 277 */     Key key = (Key)keyMap.get("RSAPrivateKey");
/* 278 */     return Base64Utils.encode(key.getEncoded());
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static String getPublicKey(Map<String, Object> keyMap)
/*     */     throws Exception
/*     */   {
/* 289 */     Key key = (Key)keyMap.get("RSAPublicKey");
/* 290 */     return Base64Utils.encode(key.getEncoded());
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   public static boolean isRSA(String reqVer)
/*     */   {
/* 298 */     boolean flag = false;
/* 299 */     if ((StringUtils.isNotEmpty(reqVer)) && (("3.0".compareTo(reqVer) == 0) || ("3.0".compareTo(reqVer) <= -1))) {
/* 300 */       flag = true;
/*     */     }
/* 302 */     return flag;
/*     */   }
/*     */ }

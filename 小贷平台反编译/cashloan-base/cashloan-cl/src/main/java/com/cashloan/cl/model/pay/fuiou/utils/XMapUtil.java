/*     */ package com.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import org.nuxeo.common.xmap.XMap;
/*     */ 
/*     */ public final class XMapUtil
/*     */ {
/*  11 */   private static final String charset = Charset.defaultCharset().name();
/*     */   
/*     */   private static final String xmlHeadStart = "<?xml ";
/*     */   
/*  15 */   private static final String xmlHead = "<?xml version=\"1.0\" encoding=\"" + charset + "\"?>";
/*     */   
/*     */   private static final String encodeStart = "encoding=\"";
/*     */   
/*     */   public static <T> T parseStr2Obj(Class<T> clazz, String spsDataStr)
/*     */   {
/*     */     try
/*     */     {
/*  23 */       spsDataStr = preHandlerSpsDataStr(spsDataStr);
/*     */       
/*  25 */       String charset = getCharsetByStr(spsDataStr);
/*     */       
/*  27 */       java.io.InputStream ips = new ByteArrayInputStream(spsDataStr.getBytes(charset));
/*  28 */       XMap xmap = new XMap();
/*  29 */       xmap.register(clazz);
/*  30 */       return (T)xmap.load(ips);
/*     */     }
/*     */     catch (Exception e) {
/*  33 */       e.printStackTrace();
/*  34 */       throw new IllegalArgumentException("解析XML异常");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> T parseBytes2Obj(Class<T> clazz, byte[] bytes, String charset)
/*     */   {
/*     */     try
/*     */     {
/*  46 */       return (T)parseStr2Obj(clazz, new String(bytes, charset));
/*     */     } catch (UnsupportedEncodingException e) {
/*  48 */       e.printStackTrace();
/*  49 */       throw new IllegalArgumentException("解析XML异常");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> T parseBytes2Obj(Class<T> clazz, byte[] bytes)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       return (T)parseStr2Obj(clazz, new String(bytes, Charset.defaultCharset().name()));
/*     */     } catch (UnsupportedEncodingException e) {
/*  64 */       e.printStackTrace();
/*  65 */       throw new IllegalArgumentException("解析XML异常");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String preHandlerSpsDataStr(String spsDataStr)
/*     */   {
/*  75 */     spsDataStr = spsDataStr.trim();
/*  76 */     if (!spsDataStr.startsWith("<?xml "))
/*  77 */       spsDataStr = xmlHead + spsDataStr;
/*  78 */     return spsDataStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String getCharsetByStr(String spsDataStr)
/*     */   {
/*  87 */     if (spsDataStr.contains("encoding=\""))
/*     */     {
/*  89 */       int i = spsDataStr.indexOf("encoding=\"");
/*  90 */       String splitChar = spsDataStr.substring(i + 9, i + 10);
/*  91 */       String encodeSub = spsDataStr.substring(i + 10);
/*  92 */       int j = encodeSub.indexOf(splitChar);
/*  93 */       return encodeSub.substring(0, j);
/*     */     }
/*  95 */     return charset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getSubXmlByTagName(String data, String tagName)
/*     */   {
/* 105 */     data = data.substring(data.indexOf("<" + tagName), data.indexOf("</" + tagName + ">") + tagName.length() + 3);
/* 106 */     return data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> String toXMLGBK(T bean)
/*     */     throws Exception
/*     */   {
/* 115 */     return toXML(bean, "GBK");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> String toXMLUTF8(T bean)
/*     */     throws Exception
/*     */   {
/* 124 */     return toXML(bean, "UTF-8");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> String toXML(T bean, String charset)
/*     */     throws Exception
/*     */   {
/* 133 */     XMap xmap = new XMap();
/* 134 */     xmap.register(bean.getClass());
/* 135 */     String str = xmap.asXmlString(bean, charset, null);
/* 136 */     System.out.println("返回xml：" + str);
/* 137 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   public static <T> String convertObj2Str(T obj)
/*     */     throws IllegalArgumentException
/*     */   {
/*     */     try
/*     */     {
/* 146 */       XMap map = new XMap();
/* 147 */       map.register(obj.getClass());
/* 148 */       return map.asXmlString(obj, "GBK", null);
/*     */     } catch (Exception e) {
/* 150 */       e.printStackTrace();
/* 151 */       throw new IllegalArgumentException("解析数据异常");
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> String toXMLE(T bean, String charset) {
/* 156 */     XMap xmap = new XMap();
/* 157 */     xmap.register(bean.getClass());
/* 158 */     String str = "";
/*     */     try {
/* 160 */       str = xmap.asXmlString(bean, charset, null);
/*     */     } catch (Exception e) {
/* 162 */       e.printStackTrace();
/*     */     }
/*     */     
/* 165 */     return str;
/*     */   }
/*     */ }

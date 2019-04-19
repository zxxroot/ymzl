/*     */ package com.cashloan.cl.utils;
/*     */ 
/*     */
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
/*     */ public class AppHelper
/*     */ {
/*  27 */   private static final Logger log = LoggerFactory.getLogger(AppHelper.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Class<?> loadClass(String className)
/*     */     throws ClassNotFoundException
/*     */   {
/*     */     try
/*     */     {
/*  37 */       return Thread.currentThread().getContextClassLoader().loadClass(className);
/*     */     } catch (ClassNotFoundException e) {
/*     */       try {
/*  40 */         return Class.forName(className);
/*     */       } catch (ClassNotFoundException ex) {
/*     */         try {
/*  43 */           return ClassLoader.class.getClassLoader().loadClass(className);
/*     */         } catch (ClassNotFoundException exc) {
/*  45 */           throw exc;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Object newInstance(String clazzStr)
/*     */   {
/*     */     try
/*     */     {
/*  59 */       log.debug("loading class:" + clazzStr);
/*  60 */       Class<?> clazz = loadClass(clazzStr);
/*  61 */       return instantiate(clazz);
/*     */     } catch (ClassNotFoundException e) {
/*  63 */       log.error("Class not found.", e);
/*     */     } catch (Exception ex) {
/*  65 */       log.error("类型实例化失败[class=" + clazzStr + "]\n" + ex.getMessage());
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> T instantiate(Class<T> clazz)
/*     */   {
/*  76 */     if (clazz.isInterface()) {
/*  77 */       log.error("所传递的class类型参数为接口，无法实例化");
/*  78 */       return null;
/*     */     }
/*     */     try {
/*  81 */       return (T)clazz.newInstance();
/*     */     } catch (Exception ex) {
/*  83 */       log.error("检查传递的class类型参数是否为抽象类?", ex.getCause());
/*     */     }
/*  85 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEmpty(String str)
/*     */   {
/*  94 */     return (str == null) || (str.length() == 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isSame(String str1, String str2)
/*     */   {
/* 104 */     if ((str1 == null) && (str2 == null)) return true;
/* 105 */     if (str1 == null) return false;
/* 106 */     return str1.equals(str2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getNewToken()
/*     */   {
/* 114 */     return "pm" + getUUID();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getUUID()
/*     */   {
/* 122 */     return UUID.randomUUID().toString().replaceAll("-", "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> T json2Object(String jsonstring, Class<T> clazz)
/*     */   {
/* 132 */     if (isEmpty(jsonstring)) {
/* 133 */       return null;
/*     */     }
/* 135 */     ObjectMapper mapper = new ObjectMapper();
///* 136 */     mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*     */     try {
/* 138 */       return (T)mapper.readValue(jsonstring, clazz);
/*     */     } catch (JsonParseException e) {
/* 140 */       e.printStackTrace();
/*     */     } catch (JsonMappingException e) {
/* 142 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 144 */       e.printStackTrace();
/*     */     }
/* 146 */     return null;
/*     */   }
/*     */   
/*     */   public static <T> List<T> getObjectsFromJson(String jsonstring, Class<T> clsT) {
/* 150 */     if (isEmpty(jsonstring)) {
/* 151 */       return null;
/*     */     }
/* 153 */     ObjectMapper mapper = new ObjectMapper();
///* 154 */     mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*     */     try {
/* 156 */       JsonParser parser = mapper.getJsonFactory().createJsonParser(jsonstring);
/* 157 */       JsonNode nodes = parser.readValueAsTree();
/* 158 */       List<T> list = new ArrayList(nodes.size());
/* 159 */       for (JsonNode node : nodes) {
/* 160 */         list.add(mapper.readValue(JSON.toJSONString(node), clsT));
/*     */       }
/* 162 */       return list;
/*     */     } catch (JsonParseException e) {
/* 164 */       e.printStackTrace();
/*     */     } catch (JsonMappingException e) {
/* 166 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 168 */       e.printStackTrace();
/*     */     }
/* 170 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String object2Json(Object object)
/*     */   {
/* 179 */     ObjectMapper mapper = new ObjectMapper();
/*     */     try {
/* 181 */       return mapper.writeValueAsString(object);
/*     */     } catch (JsonGenerationException e) {
/* 183 */       e.printStackTrace();
/*     */     } catch (JsonMappingException e) {
/* 185 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 187 */       e.printStackTrace();
/*     */     }
/* 189 */     return "";
/*     */   }
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
/*     */   public static String printStackTraceToString(Throwable t)
/*     */   {
/* 207 */     StringWriter sw = new StringWriter();
/* 208 */     t.printStackTrace(new PrintWriter(sw, true));
/* 209 */     return sw.getBuffer().toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String sendUrl(String strURL)
/*     */     throws IOException
/*     */   {
/* 219 */     URL url = new URL(strURL);
/* 220 */     HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
/* 221 */     BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(httpConnection.getInputStream(), "gbk"));
/* 222 */     String result = reader.readLine();
/* 223 */     if (result == null) result = "";
/* 224 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getNow()
/*     */   {
/* 232 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
/*     */   }
/*     */   
/*     */   public static String getNow(String format) {
/* 236 */     if (isEmpty(format)) format = "yyyy-MM-dd HH:mm:ss";
/* 237 */     return new SimpleDateFormat(format).format(new Date());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date string2Date(String str)
/*     */     throws Exception
/*     */   {
/* 247 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
/*     */   }
/*     */ }

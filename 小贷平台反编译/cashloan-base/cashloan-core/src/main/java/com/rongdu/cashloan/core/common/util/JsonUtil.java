/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.util.NumberUtil;
import tool.util.StringUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Map;

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
/*     */ public class JsonUtil
/*     */   extends tool.util.JsonUtil
/*     */ {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
/*     */   
/*  36 */   private static ObjectMapper mapper = new ObjectMapper();
/*  37 */   private static ObjectMapper mapperWithYMDDate = new ObjectMapper();
/*     */   private JSONObject jsonObject;
/*     */   
/*  40 */   static { mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
/*  41 */     mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
/*  42 */     mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*  43 */     mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
/*  44 */     mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/*  45 */     mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
/*     */     
/*  47 */     mapperWithYMDDate.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
/*  48 */     mapperWithYMDDate.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
/*  49 */     mapperWithYMDDate.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*  50 */     mapperWithYMDDate.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/*  51 */     mapperWithYMDDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
/*     */   }
/*     */   
/*     */   public static ObjectMapper getJsonMapper() {
/*  55 */     return mapper;
/*     */   }
/*     */   
/*     */   public static <T> T parse(String value, Class<T> clz)
/*     */   {
/*  60 */     if (StringUtils.isEmpty(value)) {
/*  61 */       return null;
/*     */     }
/*     */     try {
/*  64 */       T obj = mapper.readValue(value, clz);
/*  65 */       if ((obj instanceof Map)) {
/*  66 */         return (T) MapUtil.removeEmptyStr((Map)obj);
/*     */       }
/*  68 */       return obj;
/*     */     } catch (Exception e) {
/*  70 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T parseWithOnlyYMDDate(String value, Class<T> clz) {
/*  75 */     if (StringUtils.isEmpty(value)) {
/*  76 */       return null;
/*     */     }
/*     */     try {
/*  79 */       return (T)mapperWithYMDDate.readValue(value, clz);
/*     */     } catch (Exception e) {
/*  81 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T parse(byte[] bytes, Class<T> clz) {
/*     */     try {
/*  87 */       return (T)mapper.readValue(bytes, clz);
/*     */     }
/*     */     catch (Exception e) {
/*  90 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T parse(InputStream ins, Class<T> clz) {
/*     */     try {
/*  96 */       return (T)mapper.readValue(ins, clz);
/*     */     }
/*     */     catch (Exception e) {
/*  99 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T parse(Reader reader, Class<T> clz) {
/*     */     try {
/* 105 */       return (T)mapper.readValue(reader, clz);
/*     */     }
/*     */     catch (Exception e) {
/* 108 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
/* 113 */     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
/*     */   }
/*     */   
/*     */   public static <T> T parse(String value, JavaType javaType)
/*     */   {
/* 118 */     if (StringUtils.isEmpty(value)) {
/* 119 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 123 */       return (T)mapper.readValue(value, javaType);
/*     */     }
/*     */     catch (IOException e) {
/* 126 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T update(String value, T object)
/*     */   {
/*     */     try {
/* 133 */       return (T)mapper.readerForUpdating(object).readValue(value);
/*     */     }
/*     */     catch (Exception e) {
/* 136 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String writeValueAsString(Object o) {
/*     */     try {
/* 142 */       return mapper.writeValueAsString(o);
/*     */     }
/*     */     catch (Exception e) {
/* 145 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void writeJson(Object obj, HttpServletResponse resp) {
/*     */     try {
/* 151 */       resp.setContentType("application/json");
/* 152 */       resp.setCharacterEncoding("utf8");
/* 153 */       PrintWriter pw = resp.getWriter();
/* 155 */       String str; if (!(obj instanceof String)) {
/* 156 */         str = toString(obj);
/*     */       } else {
/* 158 */         str = obj.toString();
/*     */       }
/* 160 */       pw.print(str);
/* 161 */       pw.flush();
/* 162 */       pw.close();
/*     */     } catch (IOException e) {
/* 164 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void write(OutputStream outs, Object o) {
/*     */     try {
/* 170 */       mapper.writeValue(outs, o);
/*     */     }
/*     */     catch (Exception e) {
/* 173 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void write(Writer writer, Object o) {
/*     */     try {
/* 179 */       mapper.writeValue(writer, o);
/*     */     }
/*     */     catch (Exception e) {
/* 182 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void writeWithOnlyYMDDate(Writer writer, Object o) {
/*     */     try {
/* 188 */       mapperWithYMDDate.writeValue(writer, o);
/*     */     }
/*     */     catch (Exception e) {
/* 191 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String toString(Object o) {
/*     */     try {
/* 197 */       return mapper.writeValueAsString(o);
/*     */     }
/*     */     catch (Exception e) {
/* 200 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static byte[] toBytes(Object o) {
/*     */     try {
/* 206 */       return mapper.writeValueAsBytes(o);
/*     */     }
/*     */     catch (Exception e) {
/* 209 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getInt(String jsonStr, String key)
/*     */   {
/* 220 */     return NumberUtil.getInt(StringUtil.isNull(getValue(jsonStr, key)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static double getDouble(String jsonStr, String key)
/*     */   {
/* 230 */     return NumberUtil.getDouble(StringUtil.isNull(getValue(jsonStr, key)));
/*     */   }
/*     */   
/*     */   private static Object getValue(String jsonStr, String key) {
/* 234 */     JSONObject json = null;
/*     */     try {
/* 236 */       json = JSON.parseObject(jsonStr);
/* 237 */       return json.get(key);
/*     */     } catch (Exception e) {
/* 239 */       logger.error(e.getMessage(), e);
/*     */     }
/* 241 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   public static JsonUtil newJson()
/*     */   {
/* 247 */     JsonUtil jsonUtil = new JsonUtil();
/* 248 */     jsonUtil.jsonObject = new JSONObject();
/* 249 */     jsonUtil.jsonObject.put("message", "操作成功");
/* 250 */     jsonUtil.jsonObject.put("code", Integer.valueOf(200));
/* 251 */     return jsonUtil;
/*     */   }
/*     */   
/*     */   public static JsonUtil newFailJson() {
/* 255 */     JsonUtil jsonUtil = new JsonUtil();
/* 256 */     jsonUtil.jsonObject = new JSONObject();
/* 257 */     jsonUtil.jsonObject.put("message", "操作失败");
/* 258 */     jsonUtil.jsonObject.put("code", Integer.valueOf(400));
/* 259 */     return jsonUtil;
/*     */   }
/*     */   
/*     */   public JsonUtil addData(String key, Object value) {
/* 263 */     this.jsonObject.put(key, value);
/* 264 */     return this;
/*     */   }
/*     */   
/*     */   public JsonUtil addMessage(Object value) {
/* 268 */     this.jsonObject.put("message", value);
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   public JsonUtil addCode(Object value) {
/* 273 */     this.jsonObject.put("code", value);
/* 274 */     return this;
/*     */   }
/*     */   
/*     */   public JsonUtil addPageInfo(PageInfo<?> pageInfo) {
/* 278 */     JSONObject page = new JSONObject();
/* 279 */     page.put("currentPage", Integer.valueOf(pageInfo.getPageNum()));
/* 280 */     page.put("pages", Integer.valueOf(pageInfo.getPages()));
/* 281 */     page.put("total", Long.valueOf(pageInfo.getTotal()));
/* 282 */     this.jsonObject.put("page", page);
/* 283 */     return this;
/*     */   }
/*     */   
/*     */   public String toJsonString() {
/* 287 */     return this.jsonObject.toJSONString();
/*     */   }
/*     */   
/*     */   public JSON toJson()
/*     */   {
/* 292 */     return this.jsonObject;
/*     */   }
/*     */ }

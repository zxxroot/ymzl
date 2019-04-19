/*    */ package com.rongdu.cashloan.core.common.util.parse.impl;
/*    */ 
/*    */

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rongdu.cashloan.core.common.exception.RDRuntimeException;
import com.rongdu.cashloan.core.common.util.parse.ClassTypeParser;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

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
/*    */ public class DefaultClassTypeParser
/*    */   implements ClassTypeParser
/*    */ {
/* 17 */   static ObjectMapper mapper = new ObjectMapper();
/*    */   
/*    */   static {
/* 20 */     mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
/* 21 */     mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
/* 22 */     mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/* 23 */     mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/* 24 */     mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
/*    */   }
/*    */   
/*    */   public <T> T parse(String content, Class<T> valueType)
/*    */   {
/* 29 */     if (StringUtils.isEmpty(content)) {
/* 30 */       return null;
/*    */     }
/*    */     try {
/* 33 */       return (T)mapper.readValue(content, valueType);
/*    */     } catch (Exception e) {
/* 35 */       throw new RDRuntimeException("解析错误", e);
/*    */     }
/*    */   }
/*    */   
/*    */   public String parseToJSONString(Object object)
/*    */   {
/* 41 */     return JSON.toJSONString(object);
/*    */   }
/*    */ }


/* parse\impl\DefaultClassTypeParser.class

 */
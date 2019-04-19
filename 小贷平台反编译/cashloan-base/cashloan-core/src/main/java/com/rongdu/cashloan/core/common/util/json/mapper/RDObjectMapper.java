/*    */ package com.rongdu.cashloan.core.common.util.json.mapper;
/*    */ 
/*    */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
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
/*    */ public class RDObjectMapper
/*    */   extends ObjectMapper
/*    */ {
/*    */   private String dateFormatPattern;
/*    */   
/*    */   public void setDateFormatPattern(String dateFormatPattern)
/*    */   {
/* 20 */     this.dateFormatPattern = dateFormatPattern;
/*    */   }
/*    */   
/*    */   public void init()
/*    */   {
/* 25 */     setSerializationInclusion(JsonInclude.Include.NON_NULL);
/*    */     
/* 27 */     configure(SerializationFeature.INDENT_OUTPUT, true);
/* 28 */     configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
/*    */     
/* 30 */     configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
/* 31 */     configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*    */     
/*    */ 
/* 34 */     if (StringUtils.isNotEmpty(this.dateFormatPattern)) {
/* 35 */       DateFormat dateFormat = new SimpleDateFormat(this.dateFormatPattern);
/* 36 */       setDateFormat(dateFormat);
/*    */     }
/*    */   }
/*    */ }

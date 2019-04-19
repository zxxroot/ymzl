/*    */ package com.rongdu.cashloan.core.common.web.controller;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @Scope("prototype")
/*    */ public class ReadFileController
/*    */   extends BaseController
/*    */ {
/* 30 */   private static final Logger logger = Logger.getLogger(ReadFileController.class);
/*    */   
/*    */   /* Error */
/*    */   @org.springframework.web.bind.annotation.RequestMapping({"/readFile.htm"})
/*    */   public String readImg(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
{return null;}
/*    */ }
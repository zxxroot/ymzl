/*    */ package com.cashloan.cl.utils;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InterruptedIOException;
/*    */ import org.apache.http.client.HttpRequestRetryHandler;
/*    */ import org.apache.http.protocol.HttpContext;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class WhiteKnightInvoker$1
/*    */   implements HttpRequestRetryHandler
/*    */ {
/*    */   WhiteKnightInvoker$1(WhiteKnightInvoker paramWhiteKnightInvoker) {}
/*    */   
/*    */   public boolean retryRequest(IOException exception, int executionCount, HttpContext context)
/*    */   {
/* 76 */     if (executionCount >= 3) {
/* 77 */       return false;
/*    */     }
/* 79 */     if ((exception instanceof InterruptedIOException)) {
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */ }

/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.xml.ws.WebServiceContext;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ public class IpUtil
/*    */ {
/* 26 */   public static final Logger logger = LoggerFactory.getLogger(IpUtil.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @Resource
/*    */   private WebServiceContext wsContext;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getRemortIP(HttpServletRequest request)
/*    */   {
/* 43 */     String ip = request.getHeader("x-forwarded-for");
/* 44 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 45 */       ip = request.getHeader("X-Real-IP");
/*    */     }
/* 47 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 48 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 50 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 51 */       ip = request.getRemoteAddr();
/*    */     }
/*    */     
/*    */ 
/* 55 */     if (("127.0.0.1".equals(ip)) || (ip.endsWith("0:0:0:0:0:0:1")))
/*    */     {
/* 57 */       InetAddress inet = null;
/*    */       try {
/* 59 */         inet = InetAddress.getLocalHost();
/*    */       } catch (UnknownHostException e) {
/* 61 */         logger.error(e.getMessage(), e);
/*    */       }
/* 63 */       if (inet != null) {
/* 64 */         ip = inet.getHostAddress();
/*    */       }
/* 66 */       return ip;
/*    */     }
/* 68 */     if (ip.length() > 0) {
/* 69 */       String[] ipArray = ip.split(",");
/* 70 */       if ((ipArray != null) && (ipArray.length > 1)) {
/* 71 */         return ipArray[0];
/*    */       }
/* 73 */       return ip;
/*    */     }
/*    */     
/* 76 */     return "";
/*    */   }
/*    */ }


/* IpUtil.class

 */
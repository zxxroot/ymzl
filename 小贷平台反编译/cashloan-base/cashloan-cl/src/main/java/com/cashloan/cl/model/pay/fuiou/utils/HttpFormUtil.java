/*    */ package com.cashloan.cl.model.pay.fuiou.utils;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpFormUtil
/*    */ {
/*    */   public static String formForward(String url, Map<String, String> params, String charset)
/*    */   {
/* 20 */     StringBuffer formHtml = new StringBuffer();
/* 21 */     formHtml.append("<html>");
/* 22 */     String head = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + charset + 
/* 23 */       "\" pageEncoding=\"" + charset + "\" />";
/* 24 */     formHtml.append(head);
/* 25 */     formHtml.append("<title>loading</title>");
/* 26 */     formHtml.append("<style type=\"text/css\">");
/* 27 */     formHtml.append("body{margin:200px auto;font-family: \"宋体\", Arial;font-size: 12px;color: #369;text-align: center;}");
/* 28 */     formHtml.append("#1{height:auto; width:78px; margin:0 auto;}");
/* 29 */     formHtml.append("#2{height:auto; width:153px; margin:0 auto;}");
/* 30 */     formHtml.append("vertical-align: bottom;}");
/* 31 */     formHtml.append("</style>");
/* 32 */     formHtml.append("</head>");
/* 33 */     formHtml.append("<body OnLoad=\"OnLoadEvent();\" >");
/* 34 */     formHtml.append("<div id=\"3\">");
/* 35 */     formHtml.append("Loading...");
/* 36 */     formHtml.append("</div>");
/*    */     
/* 38 */     formHtml.append("<form name=\"forwardForm\" action=\"").append(url).append("\" method=\"POST\">");
/* 39 */     System.out.println("form表单跳转url:" + url);
/* 40 */     Iterator<String> keyIterator = params.keySet().iterator();
/* 41 */     while (keyIterator.hasNext())
/*    */     {
/* 43 */       String key = (String)keyIterator.next();
/* 44 */       formHtml.append("  <input type=\"hidden\" name=\"").append(key).append("\" value=\"")
/* 45 */         .append((String)params.get(key)).append("\"/>");
/* 46 */       System.out.println("form表单跳转参数：" + key + "=" + (String)params.get(key));
/*    */     }
/* 48 */     formHtml.append("</form>");
/* 49 */     formHtml.append("<SCRIPT LANGUAGE=\"Javascript\">");
/* 50 */     formHtml.append("  function OnLoadEvent(){");
/* 51 */     formHtml.append("    document.forwardForm.submit();");
/* 52 */     formHtml.append("  }");
/* 53 */     formHtml.append("</SCRIPT>");
/* 54 */     formHtml.append("</body>");
/* 55 */     formHtml.append("</html>");
/*    */     
/* 57 */     return formHtml.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String formForward(String url, Map<String, String> params)
/*    */   {
/* 69 */     return formForward(url, params, "utf8");
/*    */   }
/*    */ }

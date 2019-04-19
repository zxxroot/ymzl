/*    */ package com.rongdu.cashloan.system.security.freemarker.directive;
/*    */ 
/*    */ import com.rongdu.cashloan.system.security.userdetails.UserFunction;
/*    */ import com.rongdu.cashloan.system.security.userdetails.UserRole;
/*    */ import freemarker.core.Environment;
/*    */ import freemarker.template.TemplateDirectiveBody;
/*    */ import freemarker.template.TemplateDirectiveModel;
/*    */ import freemarker.template.TemplateException;
/*    */ import freemarker.template.TemplateModel;
/*    */ import freemarker.template.TemplateModelException;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import tool.util.StringUtil;
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
/*    */ public class SpringSecurityAuthorizeUrlDirective
/*    */   implements TemplateDirectiveModel
/*    */ {
/*    */   public void execute(Environment env, Map params, TemplateModel[] temp, TemplateDirectiveBody body)
/*    */     throws TemplateException, IOException
/*    */   {
/* 40 */     if (params.isEmpty()) {
/* 41 */       throw new TemplateModelException(
/* 42 */         "This directive doesn't allow parameters.");
/*    */     }
/*    */     
/* 45 */     if (body != null) {
/* 46 */       boolean b = false;
/* 47 */       String url = params.get("value").toString();
/* 48 */       if (StringUtil.isNotBlank(url))
/*    */       {
/* 50 */         UserRole userRole = (UserRole)SecurityContextHolder.getContext()
/* 51 */           .getAuthentication().getPrincipal();
/* 52 */         Map<String, UserFunction> resourceMap = userRole.getFunctionMap();
/* 53 */         if ((resourceMap != null) && (!resourceMap.isEmpty()) && 
/* 54 */           (resourceMap.containsKey(url))) {
/* 55 */           b = true;
/*    */         }
/*    */       }
/*    */       
/* 59 */       if (b) {
/* 60 */         body.render(env.getOut());
/*    */       }
/*    */     } else {
/* 63 */       throw new NullPointerException("missing body");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\freemarker\directive\SpringSecurityAuthorizeUrlDirective.class

 */
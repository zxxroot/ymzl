/*    */ package com.rongdu.cashloan.system.security.decision;
/*    */ 
/*    */ import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

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
/*    */ public class AccessDecisionManager
/*    */   implements org.springframework.security.access.AccessDecisionManager
/*    */ {
/*    */   public void decide(Authentication auth, Object obj, Collection<ConfigAttribute> configs)
/*    */     throws AccessDeniedException, InsufficientAuthenticationException
/*    */   {
/* 20 */     if (configs == null)
/*    */       return;
/*    */     Iterator localIterator2;
/* 23 */     for (Iterator localIterator1 = configs.iterator(); localIterator1.hasNext(); 
/*    */         
/* 25 */         localIterator2.hasNext())
/*    */     {
/* 23 */       ConfigAttribute ca = (ConfigAttribute)localIterator1.next();
/* 24 */       String needRole = ((SecurityConfig)ca).getAttribute();
/* 25 */       localIterator2 = auth.getAuthorities().iterator(); GrantedAuthority ga = (GrantedAuthority)localIterator2.next();
/* 26 */       if (needRole.equals(ga.getAuthority())) {
/* 27 */         return;
/*    */       }
/*    */     }
/*    */     
/* 31 */     throw new AccessDeniedException("no right");
/*    */   }
/*    */   
/*    */   public boolean supports(ConfigAttribute attribute) {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean supports(Class<?> clazz) {
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\decision\AccessDecisionManager.class

 */
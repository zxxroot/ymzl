/*    */ package com.rongdu.cashloan.system.security.userdetails;
/*    */ 
/*    */

import com.rongdu.cashloan.core.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
/*    */ public class UserRole
/*    */   extends User
/*    */ {
/*    */   private static final long serialVersionUID = -1548996487718223988L;
/*    */   private Map<String, UserFunction> functionMap;
/*    */   
/*    */   public UserRole(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities, Map<String, UserFunction> functionMap)
/*    */   {
/* 27 */     if (functionMap != null) {
/* 28 */       this.functionMap = functionMap;
/*    */     } else {
/* 30 */       this.functionMap = new HashMap();
/*    */     }
/*    */   }
/*    */   
/*    */   public Map<String, UserFunction> getFunctionMap() {
/* 35 */     return Collections.unmodifiableMap(this.functionMap);
/*    */   }
/*    */ }

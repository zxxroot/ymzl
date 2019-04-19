/*    */ package com.rongdu.cashloan.system.security.userdetails;
/*    */ 
/*    */ import org.springframework.security.access.ConfigAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -260181556678341867L;
/*    */   private Long id;
/*    */   private Collection<ConfigAttribute> roles;
/*    */   
/*    */   public UserFunction(Long id)
/*    */   {
/* 21 */     this.id = id;
/* 22 */     this.roles = new ArrayList();
/*    */   }
/*    */   
/*    */   public UserFunction(Long id, Collection<ConfigAttribute> roles) {
/* 26 */     this.id = id;
/* 27 */     this.roles = roles;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Collection<ConfigAttribute> getRoles() {
/* 39 */     return this.roles;
/*    */   }
/*    */   
/*    */   public void setRoles(Collection<ConfigAttribute> roles) {
/* 43 */     this.roles = roles;
/*    */   }
/*    */   
/*    */   public void add(ConfigAttribute role) {
/* 47 */     this.roles.add(role);
/*    */   }
/*    */ }

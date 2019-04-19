/*     */ package com.rongdu.cashloan.system.security.authentication.provider;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysRole;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.model.MenuModel;
import com.rongdu.cashloan.system.security.authentication.encoding.PasswordEncoder;
import com.rongdu.cashloan.system.security.userdetails.UserFunction;
import com.rongdu.cashloan.system.security.userdetails.UserRole;
import com.rongdu.cashloan.system.service.SysMenuService;
import com.rongdu.cashloan.system.service.SysRoleService;
import com.rongdu.cashloan.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tool.util.StringUtil;

import java.util.*;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class UserRoleDetailProvider
/*     */   implements UserDetailsService
/*     */ {
/*  45 */   public static final Logger logger = LoggerFactory.getLogger(UserRoleDetailProvider.class);
/*     */   
/*     */ 
/*     */   @Autowired
/*     */   private SysUserService sysUserService;
/*     */   
/*     */ 
/*     */   @Autowired
/*     */   private SysRoleService sysRoleService;
/*     */   
/*     */ 
/*     */   @Autowired
/*     */   private SysMenuService sysMenuService;
/*     */   
/*     */ 
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */ 
/*     */   private String systemPasswordInitialization;
/*     */   
/*     */ 
/*     */ 
/*     */   public UserDetails loadUserByUsername(String userName)
/*     */     throws UsernameNotFoundException, DataAccessException
/*     */   {
/*     */     try
/*     */     {
/*  72 */       SysUser op = this.sysUserService.getUserByUserName(userName);
/*     */       
/*  74 */       if (op == null) {
/*  75 */         throw new UsernameNotFoundException(userName + " is not exists");
/*     */       }
/*     */       
/*  78 */       List<SysRole> roleList = this.sysRoleService.getRoleListByUserId(op.getId().longValue());
/*     */       
/*  80 */       Collection<GrantedAuthority> auths = new ArrayList();
/*     */       
///*  82 */       auths.add(new GrantedAuthorityImpl("ROLE_DEFAULT"));
/*     */       
/*  84 */       Map<String, UserFunction> functionMap = null;
/*  85 */       if ((roleList != null) && (!roleList.isEmpty())) {
/*  86 */         List<Long> roleIdList = new ArrayList();
/*     */         /*GrantedAuthorityImpl auth;
*//*  88 *//*         for (SysRole role : roleList) {
*//*  89 *//*           auth = new GrantedAuthorityImpl(role.getId().toString());
*//*  90 *//*           auths.add(auth);
*//*  91 *//*           roleIdList.add(role.getId());
*//*     *//*         }*/
/*     */         
/*  94 */         List<MenuModel> menuList = this.sysMenuService.getMenuListByRoleIds(roleIdList);
/*  95 */         if ((menuList != null) && (!menuList.isEmpty())) {
/*  96 */           functionMap = new HashMap();
/*     */           
/*  98 */           for (MenuModel menu : menuList) {
/*  99 */             String href = menu.getHref();
/* 100 */             if (StringUtil.isNotBlank(href)) {
/* 101 */               String[] urls = StringUtils.commaDelimitedListToStringArray(href);
/* 102 */               String[] arrayOfString1; int j = (arrayOfString1 = urls).length; for (int i = 0; i < j; i++) { String url = arrayOfString1[i];
/* 103 */                 url = StringUtil.trim(url);
/* 104 */                 if (StringUtil.isNotBlank(url))
/*     */                 {
/* 106 */                   if (!functionMap.containsKey(url)) {
/* 107 */                     UserFunction userFunction = new UserFunction(menu.getId());
/* 108 */                     ConfigAttribute ca = new SecurityConfig(menu.getRoleId().toString());
/* 109 */                     userFunction.add(ca);
/* 110 */                     functionMap.put(url, userFunction);
/*     */                   } else {
/* 112 */                     ((UserFunction)functionMap.get(url)).add(new SecurityConfig(menu.getRoleId().toString()));
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 120 */         return (UserDetails) new UserRole(userName, getPassword(op), true,
/* 121 */           true, true, true, auths, functionMap);
/*     */       }
/*     */     }
/*     */     catch (ServiceException e) {
/* 125 */       logger.error(e.getMessage(), e);
/*     */     }
/* 127 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getPassword(SysUser op)
/*     */     throws ServiceException
/*     */   {
/* 139 */     String password = op.getPassword();
/* 140 */     if (("mlms".equals(op.getUserName())) && (op.getLoginTime() == null)) {
/* 141 */       if (StringUtil.isNotBlank(this.systemPasswordInitialization)) {
/* 142 */         password = this.passwordEncoder.encodePassword(this.systemPasswordInitialization);
/*     */       } else {
/* 144 */         password = this.passwordEncoder.encodePassword("123456");
/*     */       }
/* 146 */       op.setPassword(password);
/* 147 */       this.sysUserService.editUserPassWord(op);
/*     */     }
/* 149 */     return password;
/*     */   }
/*     */   
/*     */   public SysUserService getSysUserService()
/*     */   {
/* 154 */     return this.sysUserService;
/*     */   }
/*     */   
/*     */   public void setSysUserService(SysUserService sysUserService)
/*     */   {
/* 159 */     this.sysUserService = sysUserService;
/*     */   }
/*     */   
/*     */   public SysRoleService getSysRoleService()
/*     */   {
/* 164 */     return this.sysRoleService;
/*     */   }
/*     */   
/*     */   public void setSysRoleService(SysRoleService sysRoleService)
/*     */   {
/* 169 */     this.sysRoleService = sysRoleService;
/*     */   }
/*     */   
/*     */   public SysMenuService getSysMenuService()
/*     */   {
/* 174 */     return this.sysMenuService;
/*     */   }
/*     */   
/*     */   public void setSysMenuService(SysMenuService sysMenuService)
/*     */   {
/* 179 */     this.sysMenuService = sysMenuService;
/*     */   }
/*     */   
/*     */   public String getSystemPasswordInitialization()
/*     */   {
/* 184 */     return this.systemPasswordInitialization;
/*     */   }
/*     */   
/*     */   public void setSystemPasswordInitialization(String systemPasswordInitialization)
/*     */   {
/* 189 */     this.systemPasswordInitialization = systemPasswordInitialization;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\provider\UserRoleDetailProvider.class

 */
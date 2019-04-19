/*     */ package com.rongdu.cashloan.system.security.authentication.handler;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.service.SysRoleService;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.authority.AuthorityUtils;
/*     */ import org.springframework.security.core.context.SecurityContext;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ public class SaveLoginInfoAuthenticationSuccessHandler
/*     */   extends SimpleUrlAuthenticationSuccessHandler
/*     */ {
/*  42 */   public static final Logger logger = LoggerFactory.getLogger(SaveLoginInfoAuthenticationSuccessHandler.class);
/*     */   
/*     */   @Autowired
/*     */   private SysRoleService sysRoleService;
/*     */   
/*     */   @Autowired
/*     */   private SysUserService sysUserService;
/*     */   
/*     */ 
/*     */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
/*     */     throws IOException, ServletException
/*     */   {
/*     */     try
/*     */     {
/*  56 */       UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/*  57 */       SysUser op = new SysUser();
/*  58 */       op.setUserName(user.getUsername());
/*  59 */       op.setLoginIp(getIpAddr(request));
/*     */       
/*  61 */       this.sysUserService.editUserLoginInfo(op);
/*  62 */       Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
/*  63 */       SysUser sysUser = this.sysUserService.getUserByUserName(op.getUserName());
/*  64 */       HttpSession session = request.getSession();
/*  65 */       session.setAttribute("SysUser", sysUser);
/*  66 */       if ((roles.contains("ROLE_DEFAULT")) && (sysUser.getStatus().intValue() == 0)) {
/*  67 */         Map<Object, Object> context = new HashMap();
/*  68 */         context.put("code", Integer.valueOf(200));
/*  69 */         context.put("msg", "登录成功");
/*  70 */         ServletUtils.writeToResponse(response, context);
/*  71 */         List<SysRole> roleList = this.sysRoleService.getRoleListByUserId(op.getId().longValue());
/*  72 */         List<Long> roleIdList = new ArrayList();
/*     */         
/*  74 */         for (SysRole role : roleList) {
/*  75 */           roleIdList.add(role.getId());
/*     */         }
/*  77 */         session.setAttribute("roleList", roleIdList);
/*  78 */         super.onAuthenticationSuccess(request, response, authentication);
/*     */       } else {
/*  80 */         Map<Object, Object> context = new HashMap();
/*  81 */         context.put("code", Integer.valueOf(400));
/*  82 */         context.put("msg", sysUser.getStatus().intValue() == 1 ? "该账号已被锁定，请解锁后使用！" : "登录失败！");
/*  83 */         ServletUtils.writeToResponse(response, context);
/*     */       }
/*     */     } catch (ServiceException e) {
/*  86 */       logger.error(e.toString(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getIpAddr(HttpServletRequest request)
/*     */   {
/*  98 */     String ip = request.getHeader("x-forwarded-for");
/*  99 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 100 */       ip = request.getHeader("Proxy-Client-IP");
/*     */     }
/* 102 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 103 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/* 105 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 106 */       ip = request.getRemoteAddr();
/*     */     }
/* 108 */     return ip;
/*     */   }
/*     */   
/*     */   public void setSysUserService(SysUserService sysUserService) {
/* 112 */     this.sysUserService = sysUserService;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\SaveLoginInfoAuthenticationSuccessHandler.class

 */
/*    */ package com.rongdu.cashloan.system.permission;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import com.rongdu.cashloan.system.domain.SysPerm;
/*    */ import com.rongdu.cashloan.system.domain.SysUser;
/*    */ import com.rongdu.cashloan.system.service.SysPermService;
/*    */ import com.rongdu.cashloan.system.service.SysUserService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.AuthenticationInfo;
/*    */ import org.apache.shiro.authc.AuthenticationToken;
/*    */ import org.apache.shiro.authc.ExpiredCredentialsException;
/*    */ import org.apache.shiro.authc.LockedAccountException;
/*    */ import org.apache.shiro.authc.SimpleAuthenticationInfo;
/*    */ import org.apache.shiro.authc.UnknownAccountException;
/*    */ import org.apache.shiro.authc.UsernamePasswordToken;
/*    */ import org.apache.shiro.authz.AuthorizationInfo;
/*    */ import org.apache.shiro.authz.SimpleAuthorizationInfo;
/*    */ import org.apache.shiro.realm.AuthorizingRealm;
/*    */ import org.apache.shiro.session.Session;
/*    */ import org.apache.shiro.subject.PrincipalCollection;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiroRealm
/*    */   extends AuthorizingRealm
/*    */ {
/* 32 */   private static final Logger logger = Logger.getLogger(ShiroRealm.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private SysUserService sysUserService;
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private SysPermService sysPermService;
/*    */   
/*    */ 
/*    */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
/*    */   {
/* 45 */     if (!SecurityUtils.getSubject().isAuthenticated()) {
/* 46 */       doClearCache(principals);
/* 47 */       SecurityUtils.getSubject().logout();
/* 48 */       return null;
/*    */     }
/* 50 */     logger.info("授权认证：" + principals.getRealmNames());
/* 51 */     String userName = (String)principals.getPrimaryPrincipal();
/* 52 */     List<SysPerm> perms = this.sysPermService.listByUserName(userName);
/*    */     
/* 54 */     SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
/* 55 */     for (SysPerm perm : perms)
/*    */     {
/* 57 */       info.addStringPermission(perm.getCode());
/*    */     }
/* 59 */     return info;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
/*    */     throws AuthenticationException
/*    */   {
/* 70 */     UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
/*    */     
/*    */     try
/*    */     {
/* 74 */       SysUser user = this.sysUserService.getUserByUserName(token.getUsername());
/*    */       
/* 76 */       if (user == null)
/* 77 */         throw new UnknownAccountException();
/* 78 */       if (user.getStatus().byteValue() != 0) {
/* 79 */         throw new LockedAccountException();
/*    */       }
/* 81 */       Subject subject = SecurityUtils.getSubject();
/* 82 */       Session session = subject.getSession();
/* 83 */       session.setAttribute("SysUser", user);
/* 84 */       return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
/*    */     }
/*    */     catch (ServiceException e)
/*    */     {
/* 88 */       logger.error(e.getMessage(), e);
/* 89 */       throw new ExpiredCredentialsException();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\permission\ShiroRealm.class

 */
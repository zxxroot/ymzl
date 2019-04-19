/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.exception.ImgCodeException;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.exception.SysAccessCodeException;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysAccessCode;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.domain.SysUserRole;
/*     */ import com.rongdu.cashloan.system.security.authentication.encoding.PasswordEncoder;
/*     */ import com.rongdu.cashloan.system.service.SysAccessCodeService;
/*     */ import com.rongdu.cashloan.system.service.SysRoleService;
/*     */ import com.rongdu.cashloan.system.service.SysUserRoleService;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.shiro.SecurityUtils;
/*     */ import org.apache.shiro.authc.ExpiredCredentialsException;
/*     */ import org.apache.shiro.authc.IncorrectCredentialsException;
/*     */ import org.apache.shiro.authc.LockedAccountException;
/*     */ import org.apache.shiro.authc.UnknownAccountException;
/*     */ import org.apache.shiro.authc.UsernamePasswordToken;
/*     */ import org.apache.shiro.session.Session;
/*     */ import org.apache.shiro.subject.Subject;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.security.authentication.AuthenticationManager;
/*     */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.AuthenticationException;
/*     */ import org.springframework.security.core.context.SecurityContext;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysLoginController
/*     */   extends BaseController
/*     */ {
/*  63 */   private Logger logger = LoggerFactory.getLogger(SysLoginController.class);
/*     */   
/*     */   @Resource
/*     */   private SysRoleService sysRoleService;
/*     */   
/*     */   @Resource
/*     */   private SysUserService sysUserService;
/*     */   
/*     */   @Resource
/*     */   private AuthenticationManager authenticationManager;
/*     */   
/*     */   @Resource
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */   @Resource
/*     */   private SysUserRoleService sysUserRoleService;
/*     */   @Resource
/*     */   private SysAccessCodeService sysAccessCodeService;
/*     */   
/*     */   @RequestMapping({"/login.htm"})
/*     */   public void login(HttpServletResponse response, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/*  86 */     response.sendRedirect("/dev/index.html");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/index.htm"})
/*     */   public String index() {
/*  91 */     return "index";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/system/user/login.htm"})
/*     */   public void loginAjax(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password, @RequestParam(value="accessCode", required=false) String accessCode, HttpServletResponse response, HttpServletRequest request, HttpSession session)
/*     */     throws Exception
/*     */   {
/* 100 */     Map<String, Object> res = new HashMap();
/*     */     try {
/* 102 */       Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
/* 103 */       Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
/*     */       
/* 105 */       Subject user = SecurityUtils.getSubject();
/* 106 */       password = this.passwordEncoder.encodePassword(String.valueOf(password));
/* 107 */       UsernamePasswordToken token = new UsernamePasswordToken(username, password);
/* 108 */       token.setRememberMe(true);
/* 109 */       user.login(token);
/* 110 */       SecurityContextHolder.getContext().setAuthentication(authentication);
/* 111 */       session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
/* 112 */       SysUser sysUser = (SysUser)user.getSession().getAttribute("SysUser");
/* 113 */       String accessCodeAble = Global.getValue("access_code_able");
/* 114 */       if (accessCodeAble.equals("10")) {
/* 115 */         validateAccessCode(sysUser, accessCode);
/* 116 */         session.setAttribute("accessCode", accessCode);
/*     */       }
/*     */       
/* 119 */       checkImgCode(request.getParameter("code"), session.getAttribute("code"));
/*     */       
/* 121 */       session.setAttribute("SysUser", sysUser);
/*     */       
/* 123 */       List<SysUserRole> list = this.sysUserRoleService.getSysUserRoleList(sysUser.getId());
/* 124 */       if ((list != null) && (list.size() > 0)) {
/* 125 */         session.setAttribute("roleId", ((SysUserRole)list.get(0)).getRoleId());
/*     */       } else {
/* 127 */         throw new UnknownAccountException("未找到该账号对应的角色");
/*     */       }
/*     */       
/* 130 */       res.put("code", Integer.valueOf(200));
/*     */     } catch (SysAccessCodeException ex) {
/* 132 */       this.logger.error("访问码无效", ex);
/* 133 */       res.put("code", Integer.valueOf(400));
/* 134 */       res.put("msg", "登录失败，访问码无效");
/*     */     } catch (IncorrectCredentialsException ex) {
/* 136 */       this.logger.error("密码错误", ex);
/* 137 */       res.put("code", Integer.valueOf(500));
/* 138 */       res.put("msg", "密码错误请重新输入");
/*     */     } catch (LockedAccountException ex) {
/* 140 */       this.logger.error("该用户已锁定", ex);
/* 141 */       res.put("code", Integer.valueOf(500));
/* 142 */       res.put("msg", "该用户已锁定，请联系管理员！");
/*     */     } catch (AuthenticationException ex) {
/* 144 */       this.logger.error("登录失败", ex);
/* 145 */       res.put("code", Integer.valueOf(400));
/* 146 */       res.put("msg", "登录失败");
/*     */     } catch (ExpiredCredentialsException ex) {
/* 148 */       this.logger.error(ex.getMessage(), ex);
/* 149 */       res.put("code", Integer.valueOf(400));
/* 150 */       res.put("msg", ex.getMessage());
/*     */     } catch (UnknownAccountException ex) {
/* 152 */       this.logger.error(ex.getMessage(), ex);
/* 153 */       res.put("code", Integer.valueOf(400));
/* 154 */       res.put("msg", "账号不存在请核对后重新输入");
/*     */     } catch (ImgCodeException ex) {
/* 156 */       this.logger.error(ex.getMessage(), ex);
/* 157 */       res.put("code", Integer.valueOf(400));
/* 158 */       res.put("msg", "图片验证码错误");
/*     */     }
/*     */     
/* 161 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   private void checkImgCode(String code, Object sessionCode)
/*     */   {
/* 166 */     if ((StringUtil.isBlank(code)) || (code.length() != 4) || (!code.equals(sessionCode))) {
/* 167 */       throw new ImgCodeException("图片验证码错误");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/system/user/imgCode/generate.htm"})
/*     */   public void generate()
/*     */     throws Exception
/*     */   {
/* 178 */     super.generateImgCode();
/*     */   }
/*     */   
/*     */   private void validateAccessCode(SysUser user, String code) {
/* 182 */     Map<String, Object> map = new HashMap();
/* 183 */     map.put("sysUserId", user.getId());
/* 184 */     map.put("code", code);
/* 185 */     SysAccessCode sysAccessCode = this.sysAccessCodeService.findSysAccessCode(map);
/* 186 */     if ((sysAccessCode == null) || 
/* 187 */       (sysAccessCode.getExceedTime().getTime() < new Date().getTime()) || 
/* 188 */       (sysAccessCode.getState().equals("20"))) {
/* 189 */       throw new SysAccessCodeException("访问码无效");
/*     */     }
/*     */   }
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
/*     */   @RequestMapping({"/system/user/switch/role.htm"})
/*     */   public void changeLoginajax(@RequestParam(value="role", required=false) String role, HttpServletResponse response, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/* 209 */     Map<String, Object> res = new HashMap();
/* 210 */     HttpSession session = request.getSession(true);
/* 211 */     session.setAttribute("roleId", Long.valueOf(role.trim()));
/* 212 */     res.put("code", Integer.valueOf(200));
/* 213 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   public void validateRole(SysUser user, Long roleid) throws ServiceException {
/* 217 */     List<SysUserRole> list = this.sysUserRoleService.getSysUserRoleList(user.getId());
/* 218 */     for (SysUserRole role : list) {
/* 219 */       if (role.getRoleId().equals(roleid))
/* 220 */         return;
/*     */     }
/* 222 */     SysRole role = this.sysRoleService.getRoleById(roleid.longValue());
/* 223 */     throw new ServiceException(user.getName() + "不包含[" + role.getName() + "]这个角色");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/login2.htm"})
/*     */   public void sessionout(HttpServletResponse response)
/*     */   {
/* 229 */     Map<String, Object> res = new HashMap();
/* 230 */     res.put("code", Integer.valueOf(400));
/* 231 */     res.put("msg", "登录失败");
/*     */     
/* 233 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/system/user/logout.htm"})
/*     */   public void logout()
/*     */   {
/* 244 */     Map<String, Object> res = new HashMap();
/* 245 */     res.put("code", Integer.valueOf(200));
/* 246 */     res.put("msg", "成功");
/* 247 */     ServletUtils.writeToResponse(this.response, res);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysLoginController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
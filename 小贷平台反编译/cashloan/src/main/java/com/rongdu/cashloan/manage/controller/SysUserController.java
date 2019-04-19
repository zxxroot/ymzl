/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
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
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysUserController
/*     */   extends BaseController
/*     */ {
/*  47 */   private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysUserService sysUserService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysRoleService sysRoleService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/system/modifyPassword.htm"})
/*     */   @RequiresPermission(code="modules:system:modifyPassword", name="修改密码")
/*     */   public void modifyPassword(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="user", required=false) String user)
/*     */     throws Exception
/*     */   {
/*  68 */     Map<String, Object> responseMap = new HashMap();
/*  69 */     Map<String, Object> userMap = (Map)JsonUtil.parse(user, Map.class);
/*  70 */     String oldPassword = this.passwordEncoder.encodePassword(String.valueOf(userMap.get("oldPassword")));
/*  71 */     String newPassword1 = this.passwordEncoder.encodePassword(String.valueOf(userMap.get("newPassword")));
/*  72 */     String newPassword2 = this.passwordEncoder.encodePassword(String.valueOf(userMap.get("newPassword2")));
/*  73 */     SysUser sysUser = getLoginUser(request);
/*     */     
/*  75 */     logger.debug("原始密码" + sysUser.getPassword());
/*  76 */     logger.debug("旧密码" + oldPassword);
/*     */     
/*  78 */     if (!sysUser.getPassword().equals(oldPassword)) {
/*  79 */       responseMap.put("code", Integer.valueOf(500));
/*  80 */       responseMap.put("msg", "原密码输入不正确");
/*  81 */     } else if (!newPassword1.equals(newPassword2)) {
/*  82 */       responseMap.put("code", Integer.valueOf(500));
/*  83 */       responseMap.put("msg", "两个新密码不一致");
/*  84 */     } else if (oldPassword.equals(newPassword1)) {
/*  85 */       responseMap.put("code", Integer.valueOf(500));
/*  86 */       responseMap.put("msg", "新密码不能和旧密码相同");
/*     */     } else {
/*  88 */       sysUser.setPassword(newPassword1);
/*  89 */       this.sysUserService.editUserPassWord(sysUser);
/*  90 */       responseMap.put("code", Integer.valueOf(200));
/*  91 */       responseMap.put("msg", "密码修改成功");
/*     */     }
/*  93 */     ServletUtils.writeToResponse(response, responseMap);
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
/*     */   @RequestMapping({"/modules/manage/system/user/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:user:save", name="增加用户")
/*     */   public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="user", required=false) String user, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/* 109 */     Map<String, Object> responseMap = new HashMap();
/* 110 */     Map<String, Object> userMap = (Map)JsonUtil.parse(user, Map.class);
/*     */     
/* 112 */     SysUser userinfo = getLoginUser(request);
/* 113 */     if (userinfo != null) {
/* 114 */       String loginUserName = userinfo.getName();
/* 115 */       Date curDate = new Date();
/* 116 */       if ("create".equalsIgnoreCase(status)) {
/* 117 */         SysUser sysUser = new SysUser();
/* 118 */         sysUser.setName(String.valueOf(userMap.get("name")));
/* 119 */         sysUser.setJobNumber(String.valueOf(userMap.get("jobNumber")));
/*     */         
/* 121 */         String userName = String.valueOf(userMap.get("userName"));
/* 122 */         SysUser user2 = this.sysUserService.getUserByUserName(userName);
/* 123 */         if (user2 != null) {
/* 124 */           responseMap.put("code", Integer.valueOf(400));
/* 125 */           responseMap.put("msg", "用户名已存在，不能重复");
/*     */         } else {
/* 127 */           sysUser.setUserName(userName);
/* 128 */           Map<String, Object> temp = new HashMap();
/* 129 */           temp.put("parentId", Integer.valueOf(0));
/* 130 */           String email = String.valueOf(userMap.get("email"));
/* 131 */           if (StringUtil.isMail(email)) {
/* 132 */             sysUser.setEmail(email);
/*     */           }
/* 134 */           if (userMap.get("phone") != null) {
/* 135 */             sysUser.setPhone(String.valueOf(userMap.get("phone")));
/*     */           }
/* 137 */           if (userMap.get("remark") != null) {
/* 138 */             sysUser.setRemark(String.valueOf(userMap.get("remark")));
/*     */           }
/* 140 */           String mobile = String.valueOf(userMap.get("mobile"));
/* 141 */           if (StringUtil.isPhone(mobile)) {
/* 142 */             sysUser.setMobile(mobile);
/*     */           }
/* 144 */           sysUser.setAddTime(curDate);
/* 145 */           sysUser.setAddUser(loginUserName);
/* 146 */           sysUser.setUpdateTime(curDate);
/* 147 */           sysUser.setUpdateUser(loginUserName);
/* 148 */           sysUser.setPassword(this.passwordEncoder.encodePassword("123456"));
/* 149 */           sysUser.setStatus(Byte.valueOf((byte)0));
/* 150 */           if (!StringUtil.isBlank((String)userMap.get("officeOver"))) {
/* 151 */             sysUser.setOfficeOver(String.valueOf(userMap.get("officeOver")));
/*     */           }
/*     */           
/* 154 */           userMap.put("position", Integer.valueOf(0));
/* 155 */           this.sysUserService.addUser(sysUser, String.valueOf(userMap.get("roleId")));
/* 156 */           responseMap.put("code", Integer.valueOf(200));
/* 157 */           responseMap.put("msg", "操作成功");
/*     */         }
/* 159 */       } else if ("update".equalsIgnoreCase(status)) {
/* 160 */         Map<String, Object> temp = new HashMap();
/* 161 */         temp.put("parentId", Integer.valueOf(0));
/* 162 */         if (StringUtil.isNotBlank((String)userMap.get("officeOver"))) {
/* 163 */           userMap.put("officeOver", String.valueOf(userMap.get("officeOver")));
/*     */         }
/*     */         
/* 166 */         if (StringUtil.isBlank(String.valueOf(userMap.get("position")))) {
/* 167 */           userMap.put("position", Integer.valueOf(0));
/*     */         }
/*     */         
/* 170 */         SysUser updateUser = getLoginUser(request);
/* 171 */         userMap.put("updateUser", updateUser.getUserName());
/* 172 */         boolean istrue = this.sysUserService.updateSysUserById(userMap).booleanValue();
/* 173 */         if (istrue) {
/* 174 */           responseMap.put("code", Integer.valueOf(200));
/* 175 */           responseMap.put("msg", "操作成功");
/*     */         }
/*     */       } else {
/* 178 */         responseMap.put("code", Integer.valueOf(400));
/* 179 */         responseMap.put("msg", "操作失败");
/*     */       }
/*     */     } else {
/* 182 */       responseMap.put("code", Integer.valueOf(400));
/* 183 */       responseMap.put("msg", "登录过期请重新登录");
/*     */     }
/* 185 */     ServletUtils.writeToResponse(response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/user/update.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:user:update", name="用户修改")
/*     */   public void update(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="ids[]", required=false) String[] ids, @RequestParam(value="status", required=false) String status, @RequestParam(value="password", required=false) String password)
/*     */     throws Exception
/*     */   {
/* 200 */     Map<String, Object> responseMap = new HashMap();
/* 201 */     int successcount = 0;
/* 202 */     String[] arrayOfString; int j = (arrayOfString = ids).length; for (int i = 0; i < j; i++) { String id = arrayOfString[i];
/* 203 */       long userid = Long.parseLong(id);
/* 204 */       SysUser sysUser = this.sysUserService.getUserById(userid);
/* 205 */       if (sysUser != null) {
/* 206 */         if ("lock".equals(status)) {
/* 207 */           sysUser.setStatus(Byte.valueOf((byte)1));
/* 208 */         } else if ("unlock".equals(status)) {
/* 209 */           sysUser.setStatus(Byte.valueOf((byte)0));
/* 210 */         } else if ("editpassword".equals(status)) {
/* 211 */           sysUser.setPassword(this.passwordEncoder.encodePassword(password));
/*     */         }
/* 213 */         sysUser.setUpdateTime(new Date());
/* 214 */         int count = this.sysUserService.userUpdate(sysUser);
/* 215 */         if (count > 0) {
/* 216 */           successcount++;
/*     */         }
/*     */       }
/*     */     }
/* 220 */     if (successcount == ids.length) {
/* 221 */       responseMap.put("code", Integer.valueOf(200));
/* 222 */       responseMap.put("msg", "修改成功");
/*     */     } else {
/* 224 */       responseMap.put("code", Integer.valueOf(400));
/* 225 */       responseMap.put("msg", "修改失败");
/*     */     }
/* 227 */     ServletUtils.writeToResponse(response, responseMap);
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
/*     */   @RequestMapping({"/modules/manage/system/user/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:user:list", name="获取用户列表")
/*     */   public void list(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="user", required=false) String user, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 246 */     Map<String, Object> reposedata = new HashMap();
/* 247 */     Map<String, Object> paramap = (Map)JsonUtil.parse(user, Map.class);
/* 248 */     Page<Map<String, Object>> pages = this.sysUserService.getUserPageList(current, pageSize, paramap);
/* 249 */     reposedata.put("data", pages);
/* 250 */     reposedata.put("page", new RdPage(pages));
/* 251 */     reposedata.put("code", Integer.valueOf(200));
/* 252 */     reposedata.put("msg", "操作成功");
/* 253 */     ServletUtils.writeToResponse(response, reposedata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/user/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:user:find", name="登录用户查询")
/*     */   public void findUser(HttpServletResponse response, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/* 264 */     Map<String, Object> responsemap = new HashMap();
/* 265 */     SysUser sysUser = getLoginUser(request);
/* 266 */     if (sysUser == null) {
/* 267 */       response.sendRedirect("/dev/index.html");
/* 268 */       ServletUtils.writeToResponse(response, responsemap);
/* 269 */       return;
/*     */     }
/* 271 */     List<SysRole> roleList = this.sysRoleService.getRoleListByUserId(sysUser.getId().longValue());
/* 272 */     responsemap.put("name", sysUser.getName());
/* 273 */     responsemap.put("roleList", roleList);
/* 274 */     responsemap.put("code", Integer.valueOf(200));
/* 275 */     responsemap.put("msg", "操作成功");
/* 276 */     ServletUtils.writeToResponse(response, responsemap);
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
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/user/info/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:user:info:find", name="查找用户")
/*     */   public void findUserInfo(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam("roleName") String roleName)
/*     */     throws Exception
/*     */   {
/* 297 */     Map<String, Object> responseMap = new HashMap();
/* 298 */     Map<String, Object> params = new HashMap();
/* 299 */     params.put("roleName", roleName);
/*     */     
/* 301 */     String officeOver = getLoginUser(request).getOfficeOver();
/* 302 */     params.put("officeOver", Arrays.asList(officeOver.split(",")));
/*     */     
/* 304 */     List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/*     */     
/* 306 */     responseMap.put("data", users);
/* 307 */     responseMap.put("code", Integer.valueOf(200));
/* 308 */     responseMap.put("msg", "操作成功");
/* 309 */     ServletUtils.writeToResponse(response, responseMap);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysUserController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysRoleService;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.StringUtil;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysRoleController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private SysRoleService sysRoleService;
/*     */   @Resource
/*     */   private SysUserService sysUserService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/system/role/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:role:list", name="获取所有角色列表")
/*     */   public void list(HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  59 */     Map<String, Object> res = new HashMap();
/*  60 */     Map<String, Object> param = new HashMap();
/*     */     
/*  62 */     List<SysRole> sysRoleList = this.sysRoleService.getList(param);
/*  63 */     res.put("data", sysRoleList);
/*  64 */     res.put("code", Integer.valueOf(200));
/*  65 */     res.put("msg", "操作成功");
/*  66 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/role/delete.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:role:delete", name="角色删除")
/*     */   public void roleDelete(@RequestParam("key") Long id, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  81 */     Map<String, Object> res = new HashMap();
/*  82 */     if (id == null) {
/*  83 */       res.put("code", Integer.valueOf(400));
/*  84 */       res.put("msg", "角色不能为空");
/*  85 */       ServletUtils.writeToResponse(response, res);
/*  86 */       return;
/*     */     }
/*  88 */     Map<String, Object> param = new HashMap();
/*  89 */     param.put("roleId", id);
/*  90 */     param.put("delete", "0");
/*  91 */     int roleNum = this.sysUserService.queryRoleUserIsUse(param);
/*  92 */     if (roleNum >= 1) {
/*  93 */       res.put("code", Integer.valueOf(400));
/*  94 */       res.put("msg", "角色有用户在使用，删除失败");
/*  95 */       ServletUtils.writeToResponse(response, res);
/*  96 */       return;
/*     */     }
/*  98 */     int result = this.sysRoleService.deleteRole(id.longValue());
/*  99 */     if (result > 0) {
/* 100 */       res.put("code", Integer.valueOf(200));
/* 101 */       res.put("msg", "删除成功");
/*     */     } else {
/* 103 */       res.put("code", Integer.valueOf(400));
/* 104 */       res.put("msg", "删除失败");
/*     */     }
/* 106 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/sysUsers/page.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:sysUsers:page", name="获取系统用户列表")
/*     */   public void pageSysUsers(HttpServletResponse response, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 122 */     Map<String, Object> data = new HashMap();
/* 123 */     Map<String, Object> reposedata = new HashMap();
/* 124 */     Page<SysRole> page = this.sysRoleService.getRolePageList(current, pageSize, data);
/* 125 */     reposedata.put("data", page);
/* 126 */     reposedata.put("page", new RdPage(page));
/*     */     
/* 128 */     ServletUtils.writeToResponse(response, reposedata);
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
/*     */   @RequestMapping({"/modules/manage/system/role/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:role:save", name="添加或更新用户")
/*     */   public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response, @RequestParam("form") String data, @RequestParam("status") String status)
/*     */     throws Exception
/*     */   {
/* 145 */     HashMap<String, Object> dataMap = (HashMap)JsonUtil.parse(data, HashMap.class);
/* 146 */     Map<String, Object> responseMap = new HashMap();
/* 147 */     if ("create".equalsIgnoreCase(status)) {
/* 148 */       SysUser loginUser = getLoginUser(request);
/* 149 */       SysRole role = new SysRole();
/* 150 */       role.setAddTime(new Date());
/* 151 */       role.setAddUser(loginUser.getUserName());
/* 152 */       role.setUpdateTime(new Date());
/* 153 */       role.setUpdateUser(loginUser.getUserName());
/* 154 */       role.setName(dataMap.get("name") != null ? String.valueOf(dataMap.get("name")) : "");
/* 155 */       role.setNid(dataMap.get("nid") != null ? String.valueOf(dataMap.get("nid")) : "");
/* 156 */       role.setRemark(dataMap.get("remark") != null ? String.valueOf(dataMap.get("remark")) : "");
/* 157 */       int d = 0;
/* 158 */       if (StringUtil.isNotBlank(dataMap.get("isDelete"))) {
/* 159 */         d = ((Integer)dataMap.get("isDelete")).intValue();
/*     */       }
/* 161 */       role.setIsDelete(Byte.valueOf((byte)d));
/* 162 */       long n = this.sysRoleService.addRole(role);
/* 163 */       if (n > 0L) {
/* 164 */         responseMap.put("code", Integer.valueOf(200));
/* 165 */         responseMap.put("msg", "保存成功");
/*     */       } else {
/* 167 */         responseMap.put("code", Integer.valueOf(400));
/* 168 */         responseMap.put("msg", "保存失败");
/*     */       }
/* 170 */     } else if ("update".equals(status)) {
/* 171 */       int total = this.sysRoleService.updateRole(dataMap);
/* 172 */       if (total > 0) {
/* 173 */         responseMap.put("code", Integer.valueOf(200));
/* 174 */         responseMap.put("msg", "更新成功");
/*     */       } else {
/* 176 */         responseMap.put("code", Integer.valueOf(400));
/* 177 */         responseMap.put("msg", "更新失败");
/*     */       }
/*     */     }
/* 180 */     ServletUtils.writeToResponse(response, responseMap);
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
/*     */   @RequestMapping({"/modules/manage/system/userRole/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:userRole:list", name="查询用户所属角色")
/*     */   public void listUserRoles(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpSession session)
/*     */     throws Exception
/*     */   {
/* 231 */     if ((username != null) && (password != null))
/*     */     {
/* 233 */       List<Map<String, Object>> roles = this.sysRoleService
/* 234 */         .getByUserPassRolesList(username, password);
/*     */       
/* 236 */       Map<String, Object> rec = new HashMap();
/*     */       
/* 238 */       if (roles.size() > 0) {
/* 239 */         rec.put("code", Integer.valueOf(200));
/* 240 */         rec.put("msg", roles);
/* 241 */         ServletUtils.writeToResponse(response, rec);
/*     */       } else {
/* 243 */         rec.put("code", Integer.valueOf(400));
/* 244 */         rec.put("msg", "对不起，角色信息不对");
/* 245 */         ServletUtils.writeToResponse(response, rec);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysRoleController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
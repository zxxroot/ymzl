/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.druid.util.StringUtils;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.rongdu.cashloan.cl.domain.Channel;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.exception.PersistentDataException;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ListUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.Tree;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysMenu;
/*     */ import com.rongdu.cashloan.system.domain.SysPerm;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.model.SysMenuCheck;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysMenuService;
/*     */ import com.rongdu.cashloan.system.service.SysPermService;
/*     */ import com.rongdu.cashloan.system.service.SysRolePermService;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysMenuController
/*     */   extends BaseController
/*     */ {
/*  49 */   private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
/*     */   
/*     */ 
/*     */   private static final int CHOISETREENOCHECKED = 2;
/*     */   
/*     */ 
/*     */   private static final int CHOISOTTHER = 3;
/*     */   
/*     */ 
/*     */   private List<Map<String, Object>> roleIdMenuList;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysMenuService sysMenuService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysPermService sysPermService;
/*     */   
/*     */   @Resource
/*     */   private SysRolePermService sysRolePermService;
/*     */   
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/menu/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:menu:find", name="加载出原有菜单数据")
/*     */   public void find(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id", required=true) Long id)
/*     */     throws Exception
/*     */   {
/*  80 */     Map<String, Object> responseMap = new HashMap();
/*  81 */     long parentId = this.sysMenuService.menuFind(id.longValue()).getParentId();
/*  82 */     if (parentId == 0L) {
/*  83 */       responseMap.put("data", this.sysMenuService.menuFind(id.longValue()));
/*     */     } else {
/*  85 */       responseMap.put("data", null);
/*     */     }
/*  87 */     responseMap.put("code", Integer.valueOf(200));
/*  88 */     responseMap.put("msg", "操作成功");
/*  89 */     ServletUtils.writeToResponse(response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/roleMenu/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:roleMenu:find", name="根据角色查询菜单")
/*     */   public void fetchRoleMenu(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="sysType", required=true) String sysType)
/*     */     throws Exception
/*     */   {
/* 103 */     SysRole sysRole = getRoleForLoginUser(request);
/*     */     
/* 105 */     if (sysType == null)
/* 106 */       throw new BussinessException("请指定登录的系统类型");
/* 107 */     if (!sysType.matches("[\\d,]+")) {
/* 108 */       throw new BussinessException("参数错误");
/*     */     }
/* 110 */     if ((sysRole != null) && (sysRole.getId() != null) && (0L < sysRole.getId().longValue())) {
/* 111 */       List<Map<String, Object>> menus = this.sysMenuService.fetchRoleMenus(sysType, new Long[] { sysRole.getId() });
/* 112 */       menus = ListUtil.treeForExt(menus, null, null, Boolean.valueOf(true));
/* 113 */       Map<String, Object> res = new HashMap();
/* 114 */       res.put("code", Integer.valueOf(200));
/* 115 */       res.put("data", menus);
/* 116 */       ServletUtils.writeToResponse(response, res);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/channel/find2.htm"})
/*     */   public void fetchRoleMenu2(HttpServletRequest request, HttpServletResponse response, @RequestParam("c_id") String code, @RequestParam("c") String uid)
/*     */     throws Exception
/*     */   {
/* 125 */     System.out.println("######find2.htm#code=" + code);
/*     */     
/* 127 */     if ((StringUtils.isEmpty(code)) || (StringUtils.isEmpty(uid))) {
/* 128 */       Map<String, Object> result = new HashMap();
/* 129 */       this.session.setAttribute("channelCode", code);
/* 130 */       result.put("code", Integer.valueOf(400));
/* 131 */       result.put("msg", "失败");
/* 132 */       ServletUtils.writeToResponse(response, result);
/*     */     }
/*     */     
/* 135 */     Channel channel = this.channelService.findByCode(code);
/*     */     
/* 137 */     if ((channel != null) && (channel.getLoginURL() != null) && (channel.getLoginURL().contains(uid))) {
/* 138 */       Map<String, Object> result = new HashMap();
/* 139 */       this.session.setAttribute("channelCode", code);
/* 140 */       result.put("code", Integer.valueOf(200));
/* 141 */       result.put("msg", "登录成功");
/*     */     }
/*     */     else {
/* 144 */       Map<String, Object> result = new HashMap();
/* 145 */       result.put("code", Integer.valueOf(400));
/* 146 */       result.put("msg", "用户登录错误");
/*     */     }
/*     */     
/*     */ 
/* 150 */     Map<String, Object> parent = new HashMap();
/* 151 */     parent.put("parentId", Integer.valueOf(0));
/* 152 */     parent.put("sort", Integer.valueOf(122));
/* 153 */     parent.put("scriptid", "PipelineManage");
/* 154 */     parent.put("value", Integer.valueOf(11244));
/* 155 */     parent.put("label", "渠道管理");
/* 156 */     List<Map> children = new ArrayList();
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
/* 176 */     Map<String, Object> c3 = new HashMap();
/* 177 */     c3.put("parentId", Integer.valueOf(11244));
/* 178 */     c3.put("sort", Integer.valueOf(20));
/* 179 */     c3.put("scriptid", "MySelfChannel");
/* 180 */     c3.put("value", Integer.valueOf(11297));
/* 181 */     c3.put("label", "我的数据");
/* 182 */     children.add(c3);
/* 183 */     parent.put("children", children);
/*     */     
/* 185 */     List list = new ArrayList();
/* 186 */     list.add(parent);
/* 187 */     list = ListUtil.treeForExt(list, null, null, Boolean.valueOf(true));
/* 188 */     Map<String, Object> res = new HashMap();
/* 189 */     res.put("code", Integer.valueOf(200));
/* 190 */     res.put("data", list);
/* 191 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/menu/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:menu:save", name="修改用户权限")
/*     */   public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response, @RequestParam("checkedkey") String checkedkey, @RequestParam("menus") String menus, @RequestParam("roleId") Integer roleId)
/*     */     throws Exception
/*     */   {
/* 210 */     List<Integer> permIds = JSONObject.parseArray(checkedkey, Integer.class);
/* 211 */     List<Long> menuIds = JSONObject.parseArray(menus, Long.class);
/* 212 */     SysUser sysUser = getLoginUser(request);
/* 213 */     String userName = sysUser.getUserName();
/* 214 */     this.sysRolePermService.updatePerms(roleId, permIds, userName);
/* 215 */     this.sysMenuService.saveOrUpdateMenuss(roleId.intValue(), menuIds);
/* 216 */     Map<String, Object> res = new HashMap();
/* 217 */     res.put("code", Integer.valueOf(200));
/* 218 */     res.put("msg", "操作成功");
/* 219 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/roleMenu/fetch.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:roleMenu:fetch", name="当前用户权限")
/*     */   public void findRoleMenuHas(HttpServletRequest request, HttpServletResponse response, long roleId)
/*     */     throws Exception
/*     */   {
/* 237 */     List<Map<String, Object>> menus = this.sysMenuService.fetchRoleMenuHas(Long.valueOf(roleId));
/* 238 */     List<Map<String, Object>> list = this.sysPermService.fetchAll();
/* 239 */     List<SysPerm> perms = this.sysPermService.listByRoleId(Long.valueOf(roleId));
/* 240 */     for (Map<String, Object> perm : list) {
/* 241 */       for (Map<String, Object> menu : menus) {
/* 242 */         if (StringUtil.isNull(perm.get("menuId")).equals(StringUtil.isNull(menu.get("value")))) {
/* 243 */           perm.put("menuName", menu.get("label"));
/* 244 */           perm.put("menuParentId", menu.get("parentId"));
/*     */         }
/*     */       }
/* 247 */       if (perms.size() != 0) {
/* 248 */         for (SysPerm sysPerm : perms) {
/* 249 */           if (sysPerm.getId().toString().equals(perm.get("id").toString())) {
/* 250 */             perm.put("isPerm", Boolean.valueOf(true));
/* 251 */             break;
/*     */           }
/* 253 */           perm.put("isPerm", Boolean.valueOf(false));
/*     */         }
/*     */         
/*     */       } else {
/* 257 */         perm.put("isPerm", Boolean.valueOf(false));
/*     */       }
/*     */     }
/*     */     
/* 261 */     menus = ListUtil.list2Tree(menus, "value", "parentId");
/* 262 */     menus = ListUtil.treeForExt(menus, null, null, Boolean.valueOf(true));
/* 263 */     for (Map<String, Object> parentMenu : menus) {
/* 264 */       List<Map<String, Object>> menuChilds = (List)parentMenu.get("children");
/* 265 */       if (menuChilds != null) {
/* 266 */         for (Object menuChild : menuChilds) {
/* 267 */           List<Map<String, Object>> menuPerms = null;
/* 268 */           int i = 0;
/* 269 */           for (Map<String, Object> perm : list) {
/* 270 */             if (StringUtil.isNull(perm.get("menuId")).equals(StringUtil.isNull(((Map)menuChild).get("value")))) {
/* 271 */               if (menuPerms == null) {
/* 272 */                 menuPerms = new ArrayList();
/*     */               }
/* 274 */               if (perm.get("isPerm").toString().equals("false")) {
/* 275 */                 i++;
/*     */               }
/* 277 */               menuPerms.add(perm);
/*     */             }
/*     */           }
/*     */           
/* 281 */           if (menuPerms != null) {
/* 282 */             ((Map)menuChild).put("children", menuPerms);
/*     */           }
/*     */           
/* 285 */           if (i > 0) {
/* 286 */             ((Map)menuChild).put("checked", Integer.valueOf(0));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 291 */     Map<String, Object> res = new HashMap();
/* 292 */     res.put("code", Integer.valueOf(200));
/* 293 */     res.put("data", menus);
/* 294 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/perm/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:perm:find", name="查询用户权限")
/*     */   public void findAllMenu(HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 307 */     List<Map<String, Object>> list = this.sysMenuService.fetchAllMenu();
/* 308 */     list = ListUtil.list2Tree(list, "value", "parentId");
/* 309 */     list = ListUtil.treeForExt(list, null, null, Boolean.valueOf(true));
/* 310 */     Map<String, Object> res = new HashMap();
/* 311 */     res.put("code", Integer.valueOf(200));
/* 312 */     res.put("data", list);
/* 313 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/menu/findMenuTrees.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:menu:findMenuTrees", name="配置菜单")
/*     */   public void findMenuTrees(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="parentId", required=false) String id, @RequestParam(value="node", required=false) String node)
/*     */     throws Exception
/*     */   {
/*     */     List<SysMenu> menuLists;
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
/*     */     List<SysMenu> menuLists;
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
/* 399 */     if ("root".equalsIgnoreCase(node)) {
/* 400 */       menuLists = this.sysMenuService.getMenuPanelByParentId(getSysUser().getUserName(), id, 
/* 401 */         2, getRole(request));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 407 */       menuLists = this.sysMenuService.getMenuPanelByParentId("system", node, 2, 
/* 408 */         getRole(request));
/*     */     }
/*     */     
/* 411 */     ServletUtils.writeToResponselist(response, menuLists);
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
/*     */   @RequestMapping({"/modules/manage/system/menu/update.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:menu:update", name="新增修改菜单")
/*     */   public void update(HttpServletResponse response, @RequestParam(value="menu", required=false) String data, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/* 428 */     Map<String, Object> dataMap = (Map)JsonUtil.parse(data, Map.class);
/* 429 */     Map<String, Object> responseMap = new HashMap();
/* 430 */     if ("create".equalsIgnoreCase(status)) {
/* 431 */       int n = this.sysMenuService.addMenu(dataMap);
/* 432 */       if (n > 0) {
/* 433 */         responseMap.put("code", Integer.valueOf(200));
/* 434 */         responseMap.put("msg", "保存成功");
/*     */       } else {
/* 436 */         responseMap.put("code", Integer.valueOf(400));
/* 437 */         responseMap.put("msg", "保存失败");
/*     */       }
/* 439 */     } else if ("update".equals(status)) {
/* 440 */       int total = this.sysMenuService.updateMenu(dataMap);
/* 441 */       if (total > 0) {
/* 442 */         responseMap.put("code", Integer.valueOf(200));
/* 443 */         responseMap.put("msg", "保存成功");
/*     */       } else {
/* 445 */         responseMap.put("code", Integer.valueOf(400));
/* 446 */         responseMap.put("msg", "保存失败");
/*     */       }
/*     */     }
/* 449 */     ServletUtils.writeToResponse(response, responseMap);
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
/*     */   public List<SysMenuCheck> getMenuList(String id, HttpServletRequest request)
/*     */     throws ServiceException, PersistentDataException
/*     */   {
/* 513 */     List<SysMenuCheck> menuLists = this.sysMenuService.getMenuPanelByParentId("system", id, 
/* 514 */       3, getRole(request));
/*     */     Iterator localIterator2;
/* 516 */     for (Iterator localIterator1 = menuLists.iterator(); localIterator1.hasNext(); 
/*     */         
/*     */ 
/*     */ 
/* 520 */         localIterator2.hasNext())
/*     */     {
/* 516 */       SysMenuCheck sysMenu = (SysMenuCheck)localIterator1.next();
/*     */       
/* 518 */       sysMenu.setChildren(getMenuList(String.valueOf(sysMenu.getId()), request));
/*     */       
/* 520 */       localIterator2 = this.roleIdMenuList.iterator(); continue;Map<String, Object> sysMenuCheck = (Map)localIterator2.next();
/*     */       
/* 522 */       if (sysMenuCheck.containsValue(Integer.valueOf(Integer.parseInt(String.valueOf(sysMenu.getId()))))) {
/* 523 */         sysMenu.setChecked(true);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 529 */     return menuLists;
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> getRoleIds(String roleId)
/*     */   {
/* 534 */     if (roleId != null) {
/* 535 */       return this.sysMenuService.getRoleIdMenuList(Integer.valueOf(roleId).intValue());
/*     */     }
/*     */     
/*     */ 
/* 539 */     return null;
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
/*     */   @RequestMapping({"/modules/manage/system/menu/combo/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:menu:combo:find", name="菜单下拉框")
/*     */   public void findMenucombo(HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 556 */     Map<String, Object> param = new HashMap();
/* 557 */     param.put("isDelete", Integer.valueOf(0));
/* 558 */     List<SysMenu> sysMenus = this.sysMenuService.getMenuList(param);
/* 559 */     Map<String, Object> res = new HashMap();
/*     */     
/* 561 */     res.put("code", Integer.valueOf(200));
/* 562 */     res.put("data", Tree.TreeList(sysMenus, "id", "text", "parentId"));
/*     */     
/* 564 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysMenuController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
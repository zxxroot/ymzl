/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.ListUtil;
import com.rongdu.cashloan.core.common.util.MapUtil;
import com.rongdu.cashloan.core.common.util.StringUtil;
import com.rongdu.cashloan.system.domain.SysMenu;
import com.rongdu.cashloan.system.domain.SysRoleMenu;
import com.rongdu.cashloan.system.mapper.SysMenuMapper;
import com.rongdu.cashloan.system.mapper.SysRoleMenuMapper;
import com.rongdu.cashloan.system.model.MenuModel;
import com.rongdu.cashloan.system.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
/*     */ @Service("sysMenuServiceImpl")
/*     */ public class SysMenuServiceImpl
/*     */   extends BaseServiceImpl<SysMenu, Long>
/*     */   implements SysMenuService
/*     */ {
/*  34 */   private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private SysMenuMapper sysMenuMapper;
/*     */   
/*     */   @Resource
/*     */   private SysRoleMenuMapper sysRoleMenuMapper;
/*     */   
/*     */   protected String getLoginName()
/*     */   {
/*  44 */     UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/*  45 */     return user.getUsername();
/*     */   }
/*     */   
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public SysMenu menuAdd(SysMenu menu) throws ServiceException {
/*  50 */     menu.setAddUser(getLoginName());
/*  51 */     this.sysMenuMapper.save(menu);
/*  52 */     return menu;
/*     */   }
/*     */   
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public SysMenu menuUpdate(SysMenu menu) throws ServiceException {
/*  57 */     menu.setUpdateUser(getLoginName());
/*  58 */     this.sysMenuMapper.update(menu);
/*  59 */     return menu;
/*     */   }
/*     */   
/*     */   public List<SysMenu> menuUseList(long userId, byte isMenu)
/*     */   {
/*  64 */     return this.sysMenuMapper.menuUseList(userId, isMenu);
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
/*     */   public boolean getMenuPermission(String userName, String href)
/*     */     throws ServiceException
/*     */   {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public SysMenu getMenuByHref(String href) {
/*  88 */     return this.sysMenuMapper.getMenuByHref(href);
/*     */   }
/*     */   
/*     */   public List<MenuModel> getMenuListByRoleIds(List<Long> roleIds) throws ServiceException {
/*  92 */     return this.sysMenuMapper.getMenuListByRoleIds(roleIds);
/*     */   }
/*     */   
/*     */   public SysMenuMapper getSysMenuMapper() {
/*  96 */     return this.sysMenuMapper;
/*     */   }
/*     */   
/*     */   public void setSysMenuMapper(SysMenuMapper sysMenuMapper) {
/* 100 */     this.sysMenuMapper = sysMenuMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<? extends SysMenu> getMenuPanelByParentId(String useName, String parentId, int code, List<Long> roles)
/*     */     throws ServiceException, PersistentDataException
/*     */   {
/* 107 */     return this.sysMenuMapper.getMenuPanelByParentId(useName, parentId, code, 
/* 108 */       roles);
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public int updateMenu(Map<String, Object> menuMap)
/*     */   {
/* 115 */     return this.sysMenuMapper.updateMenu(menuMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int addMenu(Map<String, Object> menuMap)
/*     */   {
/* 122 */     return this.sysMenuMapper.insertmap(menuMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> getRoleIdMenuList(int roleId)
/*     */   {
/* 129 */     return this.sysMenuMapper.getRoleMenuList(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public boolean saveOrUpdate(String roleId, String ids)
/*     */     throws ServiceException, PersistentDataException
/*     */   {
/* 137 */     this.sysMenuMapper.saveOrupdateRoleMenu(roleId, ids);
/*     */     
/* 139 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SysMenu> getMenuList(Map<String, Object> param)
/*     */   {
/* 145 */     return this.sysMenuMapper.getMenuList(param);
/*     */   }
/*     */   
/*     */   public BaseMapper<SysMenu, Long> getMapper()
/*     */   {
/* 150 */     return this.sysMenuMapper;
/*     */   }
/*     */   
/*     */   public SysMenu menuFind(long id) throws ServiceException
/*     */   {
/* 155 */     return null;
/*     */   }
/*     */   
/*     */   public List queryTreeNodeIds(String leafIds)
/*     */     throws PersistentDataException
/*     */   {
/* 161 */     String menuLeafIds = leafIds;
/*     */     
/* 163 */     String[] Ids = menuLeafIds.split(",");
/*     */     
/* 165 */     List rIds = new ArrayList();
/*     */     List<Map<String, Object>> parents;
/* 167 */     do { parents = this.sysMenuMapper.getMenuParentId(Ids);
/* 168 */       rIds.addAll(parents);
/* 169 */       menuLeafIds = StringUtil.toString(MapUtil.collectProperty(parents, "id", false));
/* 170 */       Ids = menuLeafIds.split(",");
/* 171 */     } while (!parents.isEmpty());
/*     */     
/* 173 */     List rlist = MapUtil.collectProperty(rIds, "id", false);
/*     */     String[] arrayOfString1;
/* 175 */     int j = (arrayOfString1 = leafIds.split(",")).length; for (int i = 0; i < j; i++) { String id = arrayOfString1[i];
/* 176 */       rlist.add(id);
/*     */     }
/*     */     
/* 179 */     return rlist;
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> fetchRoleMenus(String sysType, Long... roleids) throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/* 186 */       String roleIds = StringUtil.toStringArray(roleids);
/*     */       
/* 188 */       List<Map<String, Object>> leafMenus = this.sysMenuMapper.getRoleSysMenu(roleIds, sysType);
/*     */       
/* 190 */       String menuLeafIds = StringUtil.toString(MapUtil.collectProperty(leafMenus, "menu_id"));
/*     */       
/* 192 */       String ids = StringUtil.toString(queryTreeNodeIds(menuLeafIds));
/*     */       
/* 194 */       String[] idsArray = ids.split(",");
/*     */       
/* 196 */       List<Map<String, Object>> menuList = this.sysMenuMapper.getMenuByParentIds(idsArray);
/*     */       
/* 198 */       return ListUtil.list2Tree(menuList, "value", "parentId");
/*     */     }
/*     */     catch (Exception e) {
/* 201 */       throw new ServiceException("查询菜单失败", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveOrUpdateMenuss(long roleId, List<Long> menuIds) throws ServiceException
/*     */   {
/* 207 */     this.sysRoleMenuMapper.deleteByRoleId(roleId);
/* 208 */     for (Long menuId : menuIds) {
/* 209 */       SysRoleMenu rm = new SysRoleMenu();
/* 210 */       rm.setMenuId(menuId);
/* 211 */       rm.setRoleId(Long.valueOf(roleId));
/* 212 */       this.sysRoleMenuMapper.save(rm);
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
/*     */   public List<Map<String, Object>> fetchRoleMenuHas(Long roleId)
/*     */     throws ServiceException
/*     */   {
/* 228 */     return this.sysMenuMapper.fetchRoleMenuHas(roleId);
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> fetchAllMenu() throws ServiceException
/*     */   {
/* 233 */     return this.sysMenuMapper.fetchAllMenu();
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysMenuServiceImpl.class

 */
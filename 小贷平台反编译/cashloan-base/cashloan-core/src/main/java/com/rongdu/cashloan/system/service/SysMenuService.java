package com.rongdu.cashloan.system.service;

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysMenu;
import com.rongdu.cashloan.system.model.MenuModel;
import java.util.List;
import java.util.Map;

public abstract interface SysMenuService
{
  public abstract List<MenuModel> getMenuListByRoleIds(List<Long> paramList)
    throws ServiceException;
  
  public abstract SysMenu menuFind(long paramLong)
    throws ServiceException;
  
  public abstract boolean getMenuPermission(String paramString1, String paramString2)
    throws ServiceException;
  
  public abstract SysMenu getMenuByHref(String paramString);
  
  public abstract int updateMenu(Map<String, Object> paramMap);
  
  public abstract List<? extends SysMenu> getMenuPanelByParentId(String paramString1, String paramString2, int paramInt, List<Long> paramList)
    throws ServiceException, PersistentDataException;
  
  public abstract int addMenu(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getRoleIdMenuList(int paramInt);
  
  public abstract boolean saveOrUpdate(String paramString1, String paramString2)
    throws ServiceException, PersistentDataException;
  
  public abstract List<SysMenu> getMenuList(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> fetchRoleMenus(String paramString, Long... paramVarArgs)
    throws ServiceException;
  
  public abstract void saveOrUpdateMenuss(long paramLong, List<Long> paramList)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> fetchRoleMenuHas(Long paramLong)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> fetchAllMenu()
    throws ServiceException;
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysMenuService.class

 */
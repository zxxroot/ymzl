package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysMenu;
import com.rongdu.cashloan.system.model.MenuModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SysMenuMapper
  extends BaseMapper<SysMenu, Long>
{
  public abstract List<SysMenu> menuFindByPid(long paramLong);
  
  public abstract void update(long paramLong);
  
  public abstract List<SysMenu> menuUseList(long paramLong, byte paramByte);
  
  public abstract SysMenu getMenuPermission(String paramString1, String paramString2);
  
  public abstract List<MenuModel> getMenuListByRoleIds(List<Long> paramList);
  
  public abstract SysMenu getMenuByHref(String paramString);
  
  public abstract void editMenuIsDelete(SysMenu paramSysMenu);
  
  public abstract List<? extends SysMenu> getMenuPanelByParentId(String paramString1, String paramString2, int paramInt, List<Long> paramList)
    throws PersistentDataException;
  
  public abstract int updateMenu(Map<String, Object> paramMap);
  
  public abstract int insertmap(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getRoleMenuList(int paramInt);
  
  public abstract boolean saveOrupdateRoleMenu(String paramString1, String paramString2)
    throws PersistentDataException;
  
  public abstract List<SysMenu> getMenuList(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> getMenuInfoById(Long paramLong)
    throws PersistentDataException;
  
  public abstract List<Map<String, Object>> getAllMenuList(Map<String, Object> paramMap)
    throws PersistentDataException;
  
  public abstract List<Map<String, Object>> fetchRoleMenuHas(Long paramLong);
  
  public abstract List<Map<String, Object>> getRoleSysMenu(String paramString1, String paramString2);
  
  public abstract List<Map<String, Object>> getMenuParentId(@Param("menuLeafIds") String[] paramArrayOfString);
  
  public abstract List<Map<String, Object>> getMenuByParentIds(@Param("ids") String[] paramArrayOfString);
  
  public abstract List<Map<String, Object>> fetchAllMenu();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysMenuMapper.class

 */
package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysConfig;
import java.util.List;
import java.util.Map;

public abstract interface SysConfigService
{
  public abstract long insertSysConfig(SysConfig paramSysConfig)
    throws ServiceException;
  
  public abstract long updateSysConfig(SysConfig paramSysConfig)
    throws ServiceException;
  
  public abstract Page<SysConfig> getSysConfigPageList(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract int getTotalCount(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract List<SysConfig> findAll();
  
  public abstract String selectByCode(String paramString);
  
  public abstract List<SysConfig> listByCode(String paramString);
  
  public abstract List<SysConfig> getList(Map<String, Object> paramMap);
  
  public abstract SysConfig findByCode(String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysConfigService.class

 */
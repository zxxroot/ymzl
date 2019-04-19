package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysDict;
import java.util.List;
import java.util.Map;

public abstract interface SysDictService
{
  public abstract List<SysDict> getDictByTypeArr(String... paramVarArgs);
  
  public abstract Long getDictCount(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract long getDictDetailCount(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract boolean addOrModify(SysDict paramSysDict, String paramString)
    throws ServiceException;
  
  public abstract boolean deleteDict(Long paramLong)
    throws ServiceException;
  
  public abstract Page<SysDict> getDictPageList(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract Page<Map<String, Object>> getDictDetailList(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> getDictsCache(String paramString)
    throws ServiceException;
  
  public abstract List<String> getItemVlueByParentId(String paramString)
    throws ServiceException;
  
  public abstract SysDict findByTypeCode(String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysDictService.class

 */
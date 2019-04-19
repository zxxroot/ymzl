package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysDictDetail;
import java.util.List;
import java.util.Map;

public abstract interface SysDictDetailService
  extends BaseService<SysDictDetail, Long>
{
  public abstract Boolean deleteSysDictDetail(Long paramLong)
    throws ServiceException;
  
  public abstract Long getItemCountMap(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract void addOrModify(SysDictDetail paramSysDictDetail, String paramString)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> queryAllDic()
    throws ServiceException;
  
  public abstract Page<SysDictDetail> getDictDetailList(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract SysDictDetail findDetail(String paramString1, String paramString2)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> queryAllDicByParentName(String paramString);
  
  public abstract List<SysDictDetail> listByTypeCode(Map<String, Object> paramMap);
  
  public abstract List<SysDictDetail> listUpdateCode(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysDictDetailService.class

 */
package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysAccessCode;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.model.SysAccessCodeModel;
import java.util.List;
import java.util.Map;

public abstract interface SysAccessCodeService
  extends BaseService<SysAccessCode, Long>
{
  public abstract Page<SysAccessCodeModel> listAccessCodeModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int save(SysAccessCode paramSysAccessCode, String paramString);
  
  public abstract int update(SysAccessCode paramSysAccessCode, String paramString);
  
  public abstract int countCode(long paramLong, String paramString);
  
  public abstract List<SysAccessCode> listSysAccessCode(Long paramLong);
  
  public abstract SysAccessCode findSysAccessCode(Map<String, Object> paramMap);
  
  public abstract int updateState(SysAccessCode paramSysAccessCode);
  
  public abstract List<SysUser> listUserName();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysAccessCodeService.class

 */
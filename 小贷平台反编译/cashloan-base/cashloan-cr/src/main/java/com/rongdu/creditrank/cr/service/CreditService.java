package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.creditrank.cr.domain.Credit;
import com.rongdu.creditrank.cr.model.CreditModel;
import java.util.List;
import java.util.Map;

public abstract interface CreditService
  extends BaseService<Credit, Long>
{
  public abstract Page<CreditModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int updateSelective(long paramLong, double paramDouble, SysUser paramSysUser, String paramString);
  
  public abstract Credit findByPrimary(long paramLong);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract Page<CreditModel> listAll(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Credit> findByConsumerNo(String paramString);
  
  public abstract int updateState(long paramLong, String paramString, SysUser paramSysUser);
  
  public abstract Credit findSelective(Map<String, Object> paramMap);
}

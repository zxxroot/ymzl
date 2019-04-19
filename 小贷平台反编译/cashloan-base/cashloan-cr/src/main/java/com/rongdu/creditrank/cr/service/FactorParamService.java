package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.FactorParam;
import com.rongdu.creditrank.cr.model.FactorParamModel;
import java.util.List;
import java.util.Map;

public abstract interface FactorParamService
  extends BaseService<FactorParam, Long>
{
  public abstract Page<FactorParam> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<FactorParamModel> listSelect(Map<String, Object> paramMap);
  
  public abstract int save(FactorParam paramFactorParam);
  
  public abstract Map<String, Object> deleteSelective(long paramLong)
    throws CreditException;
  
  public abstract FactorParam findByPrimary(long paramLong);
  
  public abstract int deleteSelective(Long paramLong);
  
  public abstract int findMaxScore(long paramLong);
}

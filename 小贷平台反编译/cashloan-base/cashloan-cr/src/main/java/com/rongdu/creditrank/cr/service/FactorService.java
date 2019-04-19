package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.Factor;
import com.rongdu.creditrank.cr.model.FactorModel;
import java.util.List;
import java.util.Map;

public abstract interface FactorService
  extends BaseService<Factor, Long>
{
  public abstract Factor findByFactorName(String paramString);
  
  public abstract Page<FactorModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<FactorModel> listSelect(Map<String, Object> paramMap);
  
  public abstract Factor findByPrimary(long paramLong);
  
  public abstract List<Factor> findByItemId(long paramLong);
  
  public abstract Map<String, Object> save(Map<String, Object> paramMap, List<Map<String, Object>> paramList)
    throws CreditException;
  
  public abstract Map<String, Object> updateSelective(Map<String, Object> paramMap, List<Map<String, Object>> paramList)
    throws CreditException;
  
  public abstract Map<String, Object> deleteSelective(long paramLong)
    throws CreditException;
  
  public abstract int deleteSelective(Long paramLong);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract int findSumScore(long paramLong);
  
  public abstract List<FactorModel> listFactorModel(Map<String, Object> paramMap);
}

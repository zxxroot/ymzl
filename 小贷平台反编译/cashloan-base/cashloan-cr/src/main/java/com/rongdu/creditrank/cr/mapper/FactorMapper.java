package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Factor;
import com.rongdu.creditrank.cr.model.FactorModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface FactorMapper
  extends BaseMapper<Factor, Long>
{
  public abstract Factor findByFactorName(String paramString);
  
  public abstract List<FactorModel> listSelect(Map<String, Object> paramMap);
  
  public abstract List<Factor> findByItemId(long paramLong);
  
  public abstract Factor findByCardId(long paramLong);
  
  public abstract int deleteSelective(long paramLong);
  
  public abstract int findSumScore(long paramLong);
  
  public abstract List<FactorModel> listFactorModel(Map<String, Object> paramMap);
}

package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.FactorParam;
import com.rongdu.creditrank.cr.model.FactorParamModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface FactorParamMapper
  extends BaseMapper<FactorParam, Long>
{
  public abstract List<FactorParamModel> listSelect(Map<String, Object> paramMap);
  
  public abstract int deleteSelective(long paramLong);
  
  public abstract int findMaxScore(long paramLong);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\FactorParamMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.RuleEngineInfo;

@RDBatisDao
public abstract interface RuleEngineInfoMapper
  extends BaseMapper<RuleEngineInfo, Long>
{
  public abstract int insert(RuleEngineInfo paramRuleEngineInfo);
  
  public abstract int deleteInfoByRuleId(long paramLong);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\RuleEngineInfoMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
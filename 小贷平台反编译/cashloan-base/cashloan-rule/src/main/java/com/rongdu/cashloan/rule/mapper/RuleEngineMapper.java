package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.RuleEngine;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface RuleEngineMapper
  extends BaseMapper<RuleEngine, Long>
{
  public abstract List<RuleEngine> listSelective(Map<String, Object> paramMap);
  
  public abstract RuleEngine selectByPrimary(Long paramLong);
  
  public abstract int insertId(RuleEngine paramRuleEngine);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract String findValidValue(@Param("statement") String paramString);
  
  public abstract List<RuleEngine> listByPage(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\RuleEngineMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
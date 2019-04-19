package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface RuleEngineConfigMapper
  extends BaseMapper<RuleEngineConfig, Long>
{
  public abstract List<Map<String, Object>> findTable();
  
  public abstract List<Map<String, Object>> findColumnByName(Map<String, Object> paramMap);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<RuleEngineConfig> listSelective(Map<String, Object> paramMap);
  
  public abstract int deleteByRuleId(Long paramLong);
  
  public abstract int insert(RuleEngineConfig paramRuleEngineConfig);
  
  public abstract int updateByRuleEnginId(Map<String, Object> paramMap);
  
  public abstract List<RuleEngineConfig> findRuleEnginConfigForBorrow(@Param("adaptedId") String paramString);
  
  public abstract int deleteById(Long paramLong);
  
  public abstract List<Map<String, Object>> findTableByName(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\RuleEngineConfigMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
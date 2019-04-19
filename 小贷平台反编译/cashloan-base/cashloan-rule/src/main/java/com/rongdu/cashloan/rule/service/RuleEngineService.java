package com.rongdu.cashloan.rule.service;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.RuleEngine;
import java.util.List;
import java.util.Map;

public abstract interface RuleEngineService
  extends BaseService<RuleEngine, Long>
{
  public abstract Page<RuleEngine> findListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int saveOrUpate(Map<String, Object> paramMap);
  
  public abstract RuleEngine findById(Long paramLong);
  
  public abstract int updateByRule(Map<String, Object> paramMap);
  
  public abstract List<RuleEngine> selectList(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findAllRule(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\RuleEngineService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
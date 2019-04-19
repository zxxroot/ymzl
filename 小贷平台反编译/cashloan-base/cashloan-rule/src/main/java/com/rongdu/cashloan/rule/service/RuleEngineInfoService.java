package com.rongdu.cashloan.rule.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.RuleEngineInfo;
import java.util.List;
import java.util.Map;

public abstract interface RuleEngineInfoService
  extends BaseService<RuleEngineInfo, Long>
{
  public abstract int saveIntegralInfo(Map<String, Object> paramMap, List paramList);
  
  public abstract List<RuleEngineInfo> findByMap(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\RuleEngineInfoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
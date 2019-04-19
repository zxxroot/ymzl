package com.rongdu.cashloan.rule.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public abstract interface RuleEngineConfigService
  extends BaseService<RuleEngineConfig, Long>
{
  public abstract List<RuleEngineConfig> findByMap(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findColumnByName(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findTable();
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findAllInfo(Map<String, Object> paramMap);
  
  public abstract int saveOrUpate(Map<String, Object> paramMap, List paramList, String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract List<Map<String, Object>> findTableByName(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\RuleEngineConfigService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
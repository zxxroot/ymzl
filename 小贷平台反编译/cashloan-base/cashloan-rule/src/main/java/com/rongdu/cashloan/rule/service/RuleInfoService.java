package com.rongdu.cashloan.rule.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.RuleInfo;
import java.util.List;
import java.util.Map;

public abstract interface RuleInfoService
  extends BaseService<RuleInfo, Long>
{
  public abstract List<RuleInfo> findAll(Map<String, Object> paramMap);
  
  public abstract Page<RuleInfo> ruleList(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract boolean checkTable(List<RuleInfo> paramList, String paramString);
  
  public abstract boolean checkColumn(List<RuleInfo> paramList, String paramString1, String paramString2);
  
  public abstract int modifyInfoState(Long paramLong, String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\RuleInfoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
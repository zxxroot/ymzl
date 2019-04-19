package com.rongdu.cashloan.rule.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
import com.rongdu.cashloan.rule.model.BorrowRuleConfigModel;
import java.util.List;
import java.util.Map;

public abstract interface BorrowRuleConfigService
  extends BaseService<BorrowRuleConfig, Long>
{
  public abstract List<BorrowRuleConfigModel> findConfig(Map<String, Object> paramMap);
  
  public abstract void deleteByMap(Map<String, Object> paramMap);
  
  public abstract List<BorrowRuleConfig> findBorrowRuleId(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\BorrowRuleConfigService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
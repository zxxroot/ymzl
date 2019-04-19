package com.rongdu.cashloan.rule.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
import com.rongdu.cashloan.rule.domain.BorrowRuleEngine;
import java.util.List;
import java.util.Map;

public abstract interface BorrowRuleEngineService
  extends BaseService<BorrowRuleEngine, Long>
{
  public abstract Page<BorrowRuleEngine> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int insert(BorrowRuleEngine paramBorrowRuleEngine);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract int deleteById(long paramLong);
  
  public abstract int update(BorrowRuleEngine paramBorrowRuleEngine);
  
  public abstract int update(BorrowRuleEngine paramBorrowRuleEngine, List<BorrowRuleConfig> paramList);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\BorrowRuleEngineService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
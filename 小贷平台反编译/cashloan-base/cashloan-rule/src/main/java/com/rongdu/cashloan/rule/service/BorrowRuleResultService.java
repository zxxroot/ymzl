package com.rongdu.cashloan.rule.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
import java.util.Map;

public abstract interface BorrowRuleResultService
  extends BaseService<BorrowRuleResult, Long>
{
  public abstract Page<BorrowRuleResult> borrowRuleResult(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\BorrowRuleResultService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
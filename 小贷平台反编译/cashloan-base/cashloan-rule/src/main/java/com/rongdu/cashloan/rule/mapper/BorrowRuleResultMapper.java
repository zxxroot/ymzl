package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
import com.rongdu.cashloan.rule.model.ManageReviewModel;
import com.rongdu.cashloan.rule.model.ManageRuleResultModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface BorrowRuleResultMapper
  extends BaseMapper<BorrowRuleResult, Long>
{
  public abstract List<ManageReviewModel> findRuleResult(long paramLong);
  
  public abstract List<ManageRuleResultModel> findResult(long paramLong);
  
  public abstract List<BorrowRuleResult> findRule(long paramLong1, long paramLong2);
  
  public abstract List<BorrowRuleResult> findRule(Map<String, Object> paramMap);
  
  public abstract void delete(BorrowRuleResult paramBorrowRuleResult);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\BorrowRuleResultMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
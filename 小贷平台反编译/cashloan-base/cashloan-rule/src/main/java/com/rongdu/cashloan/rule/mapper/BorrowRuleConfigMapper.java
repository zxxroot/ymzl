package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface BorrowRuleConfigMapper
  extends BaseMapper<BorrowRuleConfig, Long>
{
  public abstract int deleteByBorrowRuleId(Map<String, Object> paramMap);
  
  public abstract void deleteById(Long paramLong);
  
  public abstract void deleteByMap(Map<String, Object> paramMap);
  
  public abstract List<BorrowRuleConfig> findBorrowRuleId(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\BorrowRuleConfigMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
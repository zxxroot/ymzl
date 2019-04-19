package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.BorrowRuleEngine;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface BorrowRuleEngineMapper
  extends BaseMapper<BorrowRuleEngine, Long>
{
  public abstract int deleteById(long paramLong);
  
  public abstract List<BorrowRuleEngine> listByBorrowType(@Param("borrowType") String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\BorrowRuleEngineMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
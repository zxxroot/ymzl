package com.rongdu.cashloan.rule.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rule.domain.RuleInfo;
import java.util.Map;

@RDBatisDao
public abstract interface RuleInfoMapper
  extends BaseMapper<RuleInfo, Long>
{
  public abstract int delInfoById(Long paramLong);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\mapper\RuleInfoMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
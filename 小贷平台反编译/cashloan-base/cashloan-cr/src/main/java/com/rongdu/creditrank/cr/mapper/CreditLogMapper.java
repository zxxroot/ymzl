package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.CreditLog;
import com.rongdu.creditrank.cr.model.CreditLogModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface CreditLogMapper
  extends BaseMapper<CreditLog, Long>
{
  public abstract List<CreditLogModel> findLog(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\CreditLogMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorReqLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface OperatorReqLogMapper
  extends BaseMapper<OperatorReqLog, Long>
{
  public abstract String findOrderByUserId(Long paramLong);
  
  public abstract List<OperatorReqLog> listByUserId(Map<String, Object> paramMap);
  
  public abstract OperatorReqLog findLastRecord(Map<String, Object> paramMap);
}

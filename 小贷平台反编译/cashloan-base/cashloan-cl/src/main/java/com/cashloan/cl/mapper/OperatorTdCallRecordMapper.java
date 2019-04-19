package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorTdCallRecord;
import com.cashloan.cl.domain.OperatorVoices;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface OperatorTdCallRecordMapper
  extends BaseMapper<OperatorTdCallRecord, Long>
{
  public abstract List<OperatorVoices> listOperatorVoicesModel(Map<String, Object> paramMap);
}

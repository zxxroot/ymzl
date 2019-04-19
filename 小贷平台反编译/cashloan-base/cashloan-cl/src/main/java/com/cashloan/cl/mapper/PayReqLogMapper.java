package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.PayReqLog;
import com.cashloan.cl.model.ManagePayReqLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface PayReqLogMapper
  extends BaseMapper<PayReqLog, Long>
{
  public abstract List<ManagePayReqLogModel> page(Map<String, Object> paramMap);
  
  public abstract ManagePayReqLogModel findDetail(Long paramLong);
}

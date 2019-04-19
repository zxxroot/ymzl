package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.PayRespLog;
import com.cashloan.cl.model.ManagePayRespLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface PayRespLogMapper
  extends BaseMapper<PayRespLog, Long>
{
  public abstract List<ManagePayRespLogModel> page(Map<String, Object> paramMap);
  
  public abstract ManagePayRespLogModel findDetail(Long paramLong);
}

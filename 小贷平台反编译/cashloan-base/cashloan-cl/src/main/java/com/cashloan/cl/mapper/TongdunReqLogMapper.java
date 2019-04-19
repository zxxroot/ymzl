package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.TongdunReqLog;
import com.cashloan.cl.model.TongdunReqLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface TongdunReqLogMapper
  extends BaseMapper<TongdunReqLog, Long>
{
  public abstract List<TongdunReqLogModel> listModelByMap(Map<String, Object> paramMap);
  
  public abstract TongdunReqLogModel findModelById(long paramLong);
}

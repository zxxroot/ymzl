package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.PayLog;
import com.cashloan.cl.model.ManagePayLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface PayLogMapper
  extends BaseMapper<PayLog, Long>
{
  public abstract List<ManagePayLogModel> page(Map<String, Object> paramMap);
  
  public abstract ManagePayLogModel findDetail(Long paramLong);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract List<PayLog> findCheckList(Map<String, Object> paramMap);
  
  public abstract PayLog findLatestOne(Map<String, Object> paramMap);
  
  public abstract int doRepaymentCount(long paramLong);
  
  public abstract int findPayLogCount(Map<String, Object> paramMap);
}

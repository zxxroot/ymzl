package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorReqLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface OperatorReqLogService
  extends BaseService<OperatorReqLog, Long>
{
  public abstract OperatorReqLog findSelective(Map<String, Object> paramMap);
  
  public abstract String findOrderByUserId(Long paramLong);
  
  public abstract boolean checkUserOperator(long paramLong);
  
  public abstract OperatorReqLog findLastRecord(Map<String, Object> paramMap);
}


/*OperatorReqLogService.class

 */
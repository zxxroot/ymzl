package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.OperatorReqLog;
import com.cashloan.cl.domain.OperatorTdBasic;
import com.cashloan.cl.domain.OperatorTdCallInfo;
import com.cashloan.cl.domain.OperatorVoices;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface OperatorTdBasicService
  extends BaseService<OperatorTdBasic, Long>
{
  public abstract void saveTdOperatorInfos(Map<String, Object> paramMap, Long paramLong, OperatorReqLog paramOperatorReqLog);
  
  public abstract void saveHLOperatorInfos(Map<String, Object> paramMap, Long paramLong, OperatorReqLog paramOperatorReqLog);
  
  public abstract OperatorTdCallInfo findOperatorTdCallInfos(Map<String, Object> paramMap);
  
  public abstract Page<OperatorVoices> findPageOperatorTdCallRecord(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract void saveOperatorReportInfos(Map<String, Object> paramMap, Long paramLong, OperatorReqLog paramOperatorReqLog);
  
  public abstract void deleteOperatorData(Long paramLong);
  
  public abstract void deleteOperatorReportData(Long paramLong);
  
  public abstract void saveWkOperatorInfos(Map<String, Object> paramMap, Long paramLong);
}

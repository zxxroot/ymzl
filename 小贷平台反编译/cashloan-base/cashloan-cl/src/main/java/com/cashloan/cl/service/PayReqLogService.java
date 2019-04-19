package com.cashloan.cl.service;

import com.cashloan.cl.domain.PayReqLog;
import com.cashloan.cl.model.ManagePayReqLogModel;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.Map;

public abstract interface PayReqLogService
  extends BaseService<PayReqLog, Long>
{
  public abstract boolean save(PayReqLog paramPayReqLog);
  
  public abstract PayReqLog findByOrderNo(String paramString);
  
  public abstract Page<ManagePayReqLogModel> page(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract ManagePayReqLogModel findDetail(Long paramLong);
}


/*PayReqLogService.class

 */
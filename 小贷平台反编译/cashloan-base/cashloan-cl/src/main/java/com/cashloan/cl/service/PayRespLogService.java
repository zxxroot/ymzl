package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.PayRespLog;
import com.cashloan.cl.model.ManagePayRespLogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface PayRespLogService
  extends BaseService<PayRespLog, Long>
{
  public abstract boolean save(PayRespLog paramPayRespLog);
  
  public abstract Page<ManagePayRespLogModel> page(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract ManagePayRespLogModel findDetail(Long paramLong);
}


/*PayRespLogService.class

 */
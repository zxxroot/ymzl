package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UrgeRepayOrder;
import com.cashloan.cl.domain.UrgeRepayOrderLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface UrgeRepayOrderLogService
  extends BaseService<UrgeRepayOrderLog, Long>
{
  public abstract Page<UrgeRepayOrderLog> list(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<UrgeRepayOrderLog> getLogByParam(Map<String, Object> paramMap);
  
  public abstract int saveOrderInfo(UrgeRepayOrderLog paramUrgeRepayOrderLog, UrgeRepayOrder paramUrgeRepayOrder);
}


/*UrgeRepayOrderLogService.class

 */
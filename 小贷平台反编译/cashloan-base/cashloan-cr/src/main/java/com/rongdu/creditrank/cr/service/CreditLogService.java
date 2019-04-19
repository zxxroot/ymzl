package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.CreditLog;
import com.rongdu.creditrank.cr.model.CreditLogModel;
import java.util.Map;

public abstract interface CreditLogService
  extends BaseService<CreditLog, Long>
{
  public abstract int save(CreditLog paramCreditLog);
  
  public abstract Page<CreditLogModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}

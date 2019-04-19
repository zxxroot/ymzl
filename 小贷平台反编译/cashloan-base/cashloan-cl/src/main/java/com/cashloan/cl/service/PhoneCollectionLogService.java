package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.PhoneCollectionLog;
import com.cashloan.cl.model.PhoneCollectionLogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface PhoneCollectionLogService
  extends BaseService<PhoneCollectionLog, Long>
{
  public abstract Page<PhoneCollectionLogModel> list(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}

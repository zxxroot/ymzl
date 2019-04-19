package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepTripInfo;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorRepTripInfoService
  extends BaseService<OperatorRepTripInfo, Long>
{
  public abstract List<OperatorRepTripInfo> listSelective(Map<String, Object> paramMap);
}
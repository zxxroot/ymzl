package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepContactRegion;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorRepContactRegionService
  extends BaseService<OperatorRepContactRegion, Long>
{
  public abstract List<OperatorRepContactRegion> listSelective(Map<String, Object> paramMap);
}

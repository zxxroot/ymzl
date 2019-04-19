package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorCellBehavior;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorCellBehaviorService
  extends BaseService<OperatorCellBehavior, Long>
{
  public abstract List<OperatorCellBehavior> listSelective(Map<String, Object> paramMap);
}

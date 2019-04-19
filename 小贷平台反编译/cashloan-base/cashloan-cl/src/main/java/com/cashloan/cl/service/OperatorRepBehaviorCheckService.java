package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepBehaviorCheck;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorRepBehaviorCheckService
  extends BaseService<OperatorRepBehaviorCheck, Long>
{
  public abstract List<OperatorRepBehaviorCheck> listSelective(Map<String, Object> paramMap);
}

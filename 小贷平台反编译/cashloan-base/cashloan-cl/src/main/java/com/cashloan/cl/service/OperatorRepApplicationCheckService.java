package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepApplicationCheck;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorRepApplicationCheckService
  extends BaseService<OperatorRepApplicationCheck, Long>
{
  public abstract List<OperatorRepApplicationCheck> listSelective(Map<String, Object> paramMap);
}

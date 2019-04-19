package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepPerson;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface OperatorRepPersonService
  extends BaseService<OperatorRepPerson, Long>
{
  public abstract OperatorRepPerson findSelective(Map<String, Object> paramMap);
}


/*OperatorRepPersonService.class

 */
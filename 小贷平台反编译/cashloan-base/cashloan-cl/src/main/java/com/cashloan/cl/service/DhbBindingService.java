package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbBinding;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface DhbBindingService
  extends BaseService<DhbBinding, Long>
{
  public abstract DhbBinding findSelective(Map<String, Object> paramMap);
}


/*DhbBindingService.class

 */
package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbHistoryOrg;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface DhbHistoryOrgService
  extends BaseService<DhbHistoryOrg, Long>
{
  public abstract DhbHistoryOrg findSelective(Map<String, Object> paramMap);
}


/*DhbHistoryOrgService.class

 */
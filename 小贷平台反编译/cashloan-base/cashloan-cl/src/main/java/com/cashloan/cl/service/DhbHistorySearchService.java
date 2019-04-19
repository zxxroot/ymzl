package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbHistorySearch;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface DhbHistorySearchService
  extends BaseService<DhbHistorySearch, Long>
{
  public abstract DhbHistorySearch findSelective(Map<String, Object> paramMap);
}


/*DhbHistorySearchService.class

 */
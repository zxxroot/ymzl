package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbRiskBlacklist;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface DhbRiskBlacklistService
  extends BaseService<DhbRiskBlacklist, Long>
{
  public abstract DhbRiskBlacklist findSelective(Map<String, Object> paramMap);
}

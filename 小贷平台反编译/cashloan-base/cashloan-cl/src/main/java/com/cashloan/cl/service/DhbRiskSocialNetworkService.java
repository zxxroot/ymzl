package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbRiskSocialNetwork;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface DhbRiskSocialNetworkService
  extends BaseService<DhbRiskSocialNetwork, Long>
{
  public abstract DhbRiskSocialNetwork findSelective(Map<String, Object> paramMap);
}

package com.cashloan.cl.service;

import com.cashloan.cl.domain.YoudunUserFeatures;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface YoudunUserFeaturesService
  extends BaseService<YoudunUserFeatures, Long>
{
  public abstract Map<String, Object> udcredit(Long paramLong)
    throws Exception;
}

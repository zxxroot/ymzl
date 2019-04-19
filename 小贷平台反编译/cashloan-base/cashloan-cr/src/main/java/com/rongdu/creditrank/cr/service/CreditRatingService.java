package com.rongdu.creditrank.cr.service;

import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.CrResult;

public abstract interface CreditRatingService
  extends BaseService<CrResult, Long>
{
  public abstract CrResult saveCreditRating(String paramString, Long paramLong)
    throws CreditException;
}

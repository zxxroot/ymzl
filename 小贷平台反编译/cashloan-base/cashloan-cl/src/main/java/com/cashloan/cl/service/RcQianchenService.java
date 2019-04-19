package com.cashloan.cl.service;

import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface RcQianchenService
{
  public abstract String qianchenRiskRequest(Long paramLong, Borrow paramBorrow, String paramString1, String paramString2, TppBusiness paramTppBusiness)
    throws BussinessException;
}

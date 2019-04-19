package com.cashloan.cl.service;

import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface YoudunModelService
{
  public abstract int queryYouDModel(Borrow paramBorrow, TppBusiness paramTppBusiness);
}

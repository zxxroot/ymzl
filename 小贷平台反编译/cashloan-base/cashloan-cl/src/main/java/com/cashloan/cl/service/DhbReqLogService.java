package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbReqLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface DhbReqLogService
  extends BaseService<DhbReqLog, Long>
{
  public abstract int queryDhbSauron(Borrow paramBorrow, TppBusiness paramTppBusiness);
}

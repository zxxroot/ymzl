package com.cashloan.cl.service;

import com.cashloan.cl.domain.FireeyesBlackLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface FireeyesBlackLogService
  extends BaseService<FireeyesBlackLog, Long>
{
  public abstract int queryFireeyesBlack(Borrow paramBorrow, TppBusiness paramTppBusiness);
}


/*FireeyesBlackLogService.class

 */
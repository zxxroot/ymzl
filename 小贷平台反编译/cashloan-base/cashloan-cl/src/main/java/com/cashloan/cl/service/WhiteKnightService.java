package com.cashloan.cl.service;

import com.cashloan.cl.domain.WhiteKnight;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface WhiteKnightService
  extends BaseService<WhiteKnight, Long>
{
  public abstract int queryWhiteKnight(Borrow paramBorrow, TppBusiness paramTppBusiness);
  
  public abstract String invoke(String paramString1, String paramString2);
}


/*WhiteKnightService.class

 */
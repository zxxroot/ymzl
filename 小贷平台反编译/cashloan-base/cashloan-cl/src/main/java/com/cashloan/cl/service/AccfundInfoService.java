package com.cashloan.cl.service;

import com.cashloan.cl.domain.AccfundInfo;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Date;

public abstract interface AccfundInfoService
  extends BaseService<AccfundInfo, Long>
{
  public abstract void saveAccfundInfos(String paramString, Long paramLong, Date paramDate);
}


/*AccfundInfoService.class

 */
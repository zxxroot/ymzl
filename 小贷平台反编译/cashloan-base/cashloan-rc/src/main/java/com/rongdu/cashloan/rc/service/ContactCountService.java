package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.ContactCount;

public abstract interface ContactCountService
  extends BaseService<ContactCount, Long>
{
  public abstract int save();
  
  public abstract int countContacts(Long paramLong);
}

package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorBasic;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.List;

public abstract interface OperatorBasicService
  extends BaseService<OperatorBasic, Long>
{
  public abstract void saveRecords(List<OperatorBasic> paramList)
    throws BussinessException;
  
  public abstract void countOperatorVoice(Long paramLong)
    throws BussinessException;
  
  public abstract void countOperatorBorrow(Long paramLong)
    throws BussinessException;
}

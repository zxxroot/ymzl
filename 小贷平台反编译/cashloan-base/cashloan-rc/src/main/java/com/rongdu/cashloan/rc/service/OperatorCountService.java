package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.model.OperatorCountModel;

public abstract interface OperatorCountService
  extends BaseService<OperatorCountModel, String>
{
  public abstract int operatorCountVoice(Long paramLong);
}

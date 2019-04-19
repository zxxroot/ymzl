package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorBills;
import com.cashloan.cl.model.OperatorBillsModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;

public abstract interface OperatorBillsService
  extends BaseService<OperatorBills, Long>
{
  public abstract void saveRecords(List<OperatorBillsModel> paramList)
    throws Exception;
}


/*OperatorBillsService.class

 */
package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ProfitAmount;
import com.cashloan.cl.model.ManageProfitAmountModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;

public abstract interface ProfitAmountService
  extends BaseService<ProfitAmount, Long>
{
  public abstract int cash(long paramLong, double paramDouble);
  
  public abstract ProfitAmount find(long paramLong);
  
  public abstract Page<ManageProfitAmountModel> findAmount(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Page<ManageProfitAmountModel> findSysAmount(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<ProfitAmount> listNoCash();
}


/*ProfitAmountService.class

 */
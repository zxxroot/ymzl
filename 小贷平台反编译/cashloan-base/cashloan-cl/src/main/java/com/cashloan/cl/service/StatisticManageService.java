package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.model.DayNeedAmountModel;
import com.cashloan.cl.model.ExpendDetailModel;
import com.cashloan.cl.model.IncomeAndExpendModel;
import com.cashloan.cl.model.IncomeDetailModel;
import java.util.Map;

public abstract interface StatisticManageService
{
  public abstract Page<IncomeAndExpendModel> repayIncomeAndExpend(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Page<DayNeedAmountModel> dayNeedAmount(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Page<IncomeDetailModel> incomeDetail(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Page<ExpendDetailModel> expendDetail(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Double incomeSum(Map<String, Object> paramMap);
  
  public abstract Double expendSum(Map<String, Object> paramMap);
}

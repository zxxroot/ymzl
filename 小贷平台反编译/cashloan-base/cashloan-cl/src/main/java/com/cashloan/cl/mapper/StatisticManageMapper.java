package com.cashloan.cl.mapper;

import com.cashloan.cl.model.DayNeedAmountModel;
import com.cashloan.cl.model.ExpendDetailModel;
import com.cashloan.cl.model.IncomeAndExpendModel;
import com.cashloan.cl.model.IncomeDetailModel;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface StatisticManageMapper {
  public abstract List<IncomeAndExpendModel> repayIncomeAndExpend(Map<String, Object> paramMap);

  public abstract List<DayNeedAmountModel> dayNeedAmount(Map<String, Object> paramMap);

  public abstract List<IncomeDetailModel> incomeDetail(Map<String, Object> paramMap);

  public abstract Double incomeSum(Map<String, Object> paramMap);

  public abstract List<ExpendDetailModel> expendDetail(Map<String, Object> paramMap);

  public abstract Double expendSum(Map<String, Object> paramMap);
}

package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ProfitAmount;
import com.cashloan.cl.model.ManageProfitAmountModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ProfitAmountMapper
  extends BaseMapper<ProfitAmount, Long>
{
  public abstract List<ManageProfitAmountModel> findAmount(Map<String, Object> paramMap);
  
  public abstract List<ManageProfitAmountModel> findSysAmount(Map<String, Object> paramMap);
  
  public abstract List<ProfitAmount> listNoCash();
  
  public abstract int addNocashedAmount(Map<String, Object> paramMap);
}

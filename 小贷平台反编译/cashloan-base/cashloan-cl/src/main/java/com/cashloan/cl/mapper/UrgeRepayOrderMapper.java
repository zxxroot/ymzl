package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UrgeRepayOrder;
import com.cashloan.cl.model.UrgeRepayCountModel;
import com.cashloan.cl.model.UrgeRepayOrderModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UrgeRepayOrderMapper
  extends BaseMapper<UrgeRepayOrder, Long>
{
  public abstract List<UrgeRepayOrder> listSelective(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayOrderModel> listModel(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayOrder> listAll(Map<String, Object> paramMap);
  
  public abstract String allOrderCount(Map<String, Object> paramMap);
  
  public abstract String successCount(Map<String, Object> paramMap);
  
  public abstract String count(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayOrder> listOrder(Map<String, Object> paramMap);
  
  public abstract String newOrderByUser(Map<String, Object> paramMap);
  
  public abstract String repayOrderByUser(Map<String, Object> paramMap);
  
  public abstract String successOrderByUser(Map<String, Object> paramMap);
  
  public abstract String failOrderByUser(Map<String, Object> paramMap);
  
  public abstract String countByUser(Map<String, Object> paramMap);
  
  public abstract String allOrderSum(Map<String, Object> paramMap);
  
  public abstract String allSuccessSum(Map<String, Object> paramMap);
  
  public abstract String allFailSum(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayCountModel> listSysUserByRole(Map<String, Object> paramMap);
  
  public abstract int countOrder(Map<String, Object> paramMap);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayOrderModel> allSelective(Map<String, Object> paramMap);
  
  public abstract int updateOrderState(Map<String, Object> paramMap);
  
  public abstract UrgeRepayOrder findByPrimary(Map<String, Object> paramMap);
  
  public abstract List<Long> listUrge(Map<String, Object> paramMap);
}

package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UrgeRepayOrder;
import com.cashloan.cl.model.ManageRepayOrderTotalModel;
import com.cashloan.cl.model.ManageUrgeRepayTotalModel;
import com.cashloan.cl.model.UrgeRepayCountModel;
import com.cashloan.cl.model.UrgeRepayOrderModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface UrgeRepayOrderService
  extends BaseService<UrgeRepayOrder, Long>
{
  public abstract Page<UrgeRepayOrder> list(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<UrgeRepayOrderModel> listAll(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<UrgeRepayOrderModel> listModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<UrgeRepayOrderModel> listModel(Map<String, Object> paramMap);
  
  public abstract int orderAllotUser(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> saveOrder(Long paramLong);
  
  public abstract List<UrgeRepayOrder> listAll(HashMap<String, Object> paramHashMap);
  
  public abstract Page<UrgeRepayCountModel> memberCount(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<UrgeRepayCountModel> orderCount(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayCountModel> urgeCount(Map<String, Object> paramMap);
  
  public abstract List<UrgeRepayCountModel> memberDayCount(Map<String, Object> paramMap);
  
  public abstract UrgeRepayOrder findByBorrowId(long paramLong);
  
  public abstract int updateLate(Map<String, Object> paramMap);
  
  public abstract UrgeRepayOrder findOrderByMap(Map<String, Object> paramMap);
  
  public abstract List<?> listUrgeRepayOrder(Map<String, Object> paramMap);
  
  public abstract List<?> listUrgeLog(Map<String, Object> paramMap);
  
  public abstract ManageUrgeRepayTotalModel totalUrgeRepay(Map<String, Object> paramMap);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract String updateOrderState(Long paramLong, String paramString);
  
  public abstract ManageRepayOrderTotalModel totalUrgeRepayOrder(Map<String, Object> paramMap);
  
  public abstract List<Long> listUrge(Map<String, Object> paramMap);
}


/*UrgeRepayOrderService.class

 */
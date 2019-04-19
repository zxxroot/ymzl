package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.model.OperatorCountModel;
import java.util.Date;
import java.util.Map;

@RDBatisDao
public abstract interface OperatorCountMapper
  extends BaseMapper<OperatorCountModel, String>
{
  public abstract OperatorCountModel operatorVoicesInfo(Map<String, Object> paramMap);
  
  public abstract Double operatorMonthAmt(String paramString);
  
  public abstract Date operatorJoinDate(String paramString);
  
  public abstract OperatorCountModel operatorVoicesPhone(Map<String, Object> paramMap);
  
  public abstract OperatorCountModel concatsBorrowInfo(Map<String, Object> paramMap);
  
  public abstract Integer emerConcatTimes(Map<String, Object> paramMap);
}

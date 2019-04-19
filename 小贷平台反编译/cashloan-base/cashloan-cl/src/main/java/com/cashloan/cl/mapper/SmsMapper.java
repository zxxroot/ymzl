package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.Sms;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.Map;

@RDBatisDao
public abstract interface SmsMapper
  extends BaseMapper<Sms, Long>
{
  public abstract Sms findTimeMsg(Map<String, Object> paramMap);
  
  public abstract int countDayTime(Map<String, Object> paramMap);
}

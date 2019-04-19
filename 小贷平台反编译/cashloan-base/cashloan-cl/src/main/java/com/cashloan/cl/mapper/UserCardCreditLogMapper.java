package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserCardCreditLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.Map;

@RDBatisDao
public abstract interface UserCardCreditLogMapper
  extends BaseMapper<UserCardCreditLog, Long>
{
  public abstract int countByUserId(Map<String, Object> paramMap);
}

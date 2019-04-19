package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserPhoneBlacklist;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface UserPhoneBlacklistMapper
  extends BaseMapper<UserPhoneBlacklist, Long>
{
  public abstract UserPhoneBlacklist getByPhone(@Param("phone") String paramString);
}

package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserEmerContacts;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserEmerContactsMapper
  extends BaseMapper<UserEmerContacts, Long>
{
  public abstract List<UserEmerContacts> getUserEmerContactsByUserId(Map<String, Object> paramMap);
}

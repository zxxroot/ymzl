package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserAuth;
import com.cashloan.cl.model.UserAuthModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserAuthMapper
  extends BaseMapper<UserAuth, Long>
{
  public abstract List<UserAuthModel> listUserAuthModel(Map<String, Object> paramMap);
  
  public abstract int updateByUserId(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> executeSql(Map<String, Object> paramMap);
  
  public abstract int updatePhoneState(Map<String, Object> paramMap);
}

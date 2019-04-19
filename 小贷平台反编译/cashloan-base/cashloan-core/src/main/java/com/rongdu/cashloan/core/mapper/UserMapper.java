package com.rongdu.cashloan.core.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.model.CloanUserModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserMapper
  extends BaseMapper<User, Long>
{
  public abstract List<CloanUserModel> listModel(Map<String, Object> paramMap);
  
  public abstract CloanUserModel getModel(Long paramLong);
  
  public abstract List<Map<String, Object>> queryAllDic();
  
  public abstract User findByLoginName(String paramString);
  
  public abstract int updateLevel(User paramUser);
  
  public abstract List<User> findUserLevel(Map<String, Object> paramMap);
  
  public abstract int updateByUuid(Map<String, Object> paramMap);
  
  public abstract long todayCount();
}

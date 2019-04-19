package com.rongdu.cashloan.core.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.model.ManagerUserModel;
import com.rongdu.cashloan.core.model.UserWorkInfoModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface UserBaseInfoMapper
  extends BaseMapper<UserBaseInfo, Long>
{
  public abstract List<Map<String, Object>> getDictsCache(String paramString);
  
  public abstract ManagerUserModel getBaseModelByUserId(Long paramLong);
  
  public abstract UserBaseInfo findUserImags(@Param("userId") Long paramLong);
  
  public abstract UserWorkInfoModel findWorkInfo(@Param("userId") Long paramLong);
  
  public abstract UserBaseInfo findByUserId(@Param("userId") Long paramLong);
  
  public abstract List<String> getUnRepayPhone();
}

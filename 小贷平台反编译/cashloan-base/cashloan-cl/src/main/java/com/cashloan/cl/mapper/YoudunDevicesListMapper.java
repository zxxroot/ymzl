package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunDevicesList;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface YoudunDevicesListMapper
  extends BaseMapper<YoudunDevicesList, Long>
{
  public abstract List<YoudunDevicesList> findByUserId(@Param("userId") Long paramLong);
}

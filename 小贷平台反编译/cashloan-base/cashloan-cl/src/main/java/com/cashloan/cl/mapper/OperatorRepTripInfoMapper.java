package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorRepTripInfo;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface OperatorRepTripInfoMapper
  extends BaseMapper<OperatorRepTripInfo, Long>
{
  public abstract int countTable(String paramString);
  
  public abstract void createTable(@Param("tableName") String paramString);
  
  public abstract int saveShard(@Param("tableName") String paramString, @Param("item") OperatorRepTripInfo paramOperatorRepTripInfo);
  
  public abstract List<OperatorRepTripInfo> listShardSelective(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract void deleteShardByUserId(@Param("tableName") String paramString, @Param("userId") Long paramLong);
}

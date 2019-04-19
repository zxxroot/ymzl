package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorVoices;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface OperatorVoicesMapper
  extends BaseMapper<OperatorVoices, Long>
{
  public abstract int countTable(String paramString);
  
  public abstract void createTable(@Param("tableName") String paramString);
  
  public abstract int saveShard(@Param("tableName") String paramString, @Param("item") OperatorVoices paramOperatorVoices);
  
  public abstract List<OperatorVoices> listShardSelective(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract Map<String, Object> operatorVoicesCount(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract List<Map<String, String>> listDistinctService(@Param("tableName") String paramString1, @Param("cloumn") String paramString2, @Param("params") Map<String, Object> paramMap);
  
  public abstract int updateSelective(@Param("tableName") String paramString, @Param("params") HashMap<String, Object> paramHashMap);
  
  public abstract List<Map<String, String>> listServiceContact(@Param("tableName1") String paramString1, @Param("tableName2") String paramString2, @Param("params") HashMap<String, Object> paramHashMap);
  
  public abstract void deleteShardByUserId(@Param("tableName") String paramString, @Param("userId") Long paramLong);
  
  public abstract List<OperatorVoices> ShardDetailSelective(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract int recordsCount(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
}

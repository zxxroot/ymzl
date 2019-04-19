package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserContacts;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserContactsMapper
  extends BaseMapper<UserContacts, Long>
{
  public abstract int countTable(String paramString);
  
  public abstract void createTable(@Param("tableName") String paramString);
  
  public abstract int saveShard(@Param("tableName") String paramString, @Param("item") UserContacts paramUserContacts);
  
  public abstract int deleteShardByUserId(@Param("tableName") String paramString, @Param("userId") long paramLong);
  
  public abstract List<UserContacts> listShardSelective(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract int update(@Param("tableName") String paramString, @Param("item") UserContacts paramUserContacts);
  
  public abstract int updateVoicesCount(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);
  
  public abstract Map<String, Object> findRepeatCount(@Param("tableName") String paramString1, @Param("userId") String paramString2, @Param("name") String paramString3);
}

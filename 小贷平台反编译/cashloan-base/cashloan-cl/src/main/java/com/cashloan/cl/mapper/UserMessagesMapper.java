package com.cashloan.cl.mapper;


import com.cashloan.cl.domain.UserMessages;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserMessagesMapper
  extends BaseMapper<UserMessages, Long>
{
  public abstract int countTable(String paramString);
  
  public abstract void createTable(@Param("tableName") String paramString);
  
  public abstract int saveShard(@Param("tableName") String paramString, @Param("item") UserMessages paramUserMessages);
  
  public abstract List<UserMessages> listShardSelective(@Param("tableName") String paramString, @Param("params") Map<String, Object> paramMap);

  public abstract void deleteShardByUserId(@Param("tableName") String paramString, @Param("userId") long paramLong);
}

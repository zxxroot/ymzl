package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysDict;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SysDictMapper
  extends BaseMapper<SysDict, Long>
{
  public abstract List<String> getTypeList();
  
  public abstract List<SysDict> getDictByTypeArr(Map<String, Object> paramMap);
  
  public abstract Long saveOrUpdate(Map<String, Object> paramMap, String paramString);
  
  public abstract List<Map<String, Object>> getDictsCache(String paramString);
  
  public abstract List<SysDict> getItemListByMap(Map<String, Object> paramMap);
  
  public abstract Long getCount(Map<String, Object> paramMap);
  
  public abstract long deleteById(Long paramLong);
  
  public abstract SysDict findByTypeCode(@Param("code") String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysDictMapper.class

 */
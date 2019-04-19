package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysDictDetail;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SysDictDetailMapper
  extends BaseMapper<SysDictDetail, Long>
{
  public abstract int deleteByPrimary(Long paramLong);
  
  public abstract Long getCount(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> queryAllDic();
  
  public abstract List<Map<String, Object>> getPageListMap(Map<String, Object> paramMap);
  
  public abstract List<String> getItemVlueByParentId(String paramString);
  
  public abstract SysDictDetail findDetail(@Param("code") String paramString1, @Param("parentName") String paramString2);
  
  public abstract List<Map<String, Object>> queryAllDicByParentName(@Param("parentName") String paramString);
  
  public abstract List<SysDictDetail> listByTypeCode(Map<String, Object> paramMap);
  
  public abstract List<SysDictDetail> listUpdateCode(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysDictDetailMapper.class

 */
package com.rongdu.cashloan.system.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysConfig;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SysConfigMapper
  extends BaseMapper<SysConfig, Long>
{
  public abstract List<SysConfig> select(Map<String, Object> paramMap, PageBounds paramPageBounds);
  
  public abstract Integer total(Map<String, Object> paramMap);
  
  public abstract List<SysConfig> findAll();
  
  public abstract SysConfig selectByCode(@Param("code") String paramString);
  
  public abstract List<SysConfig> listByCode(String paramString);
  
  public abstract List<SysConfig> getList(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysConfigMapper.class

 */
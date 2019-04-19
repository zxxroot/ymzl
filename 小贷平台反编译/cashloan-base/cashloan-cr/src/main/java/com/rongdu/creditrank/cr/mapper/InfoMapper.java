package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Info;
import com.rongdu.creditrank.cr.model.InfoModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface InfoMapper
  extends BaseMapper<Info, Long>
{
  public abstract Info findByTbNid(String paramString);
  
  public abstract List<InfoModel> listSelect(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findTable();
  
  public abstract List<Map<String, Object>> findColumnByName(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\InfoMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
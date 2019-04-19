package com.rongdu.cashloan.core.common.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface BaseMapper<T, ID extends Serializable>
{
  public abstract int save(T paramT);
  
  public abstract void saveRecord(T paramT);
  
  public abstract int update(T paramT);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract T findSelective(Map<String, Object> paramMap);
  
  public abstract T findSelective2(Map<String, Object> paramMap);
  
  public abstract T findByPrimary(ID paramID);
  
  public abstract List<T> listSelective(Map<String, Object> paramMap);
}
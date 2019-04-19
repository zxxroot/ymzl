package com.rongdu.cashloan.core.common.service;

import java.io.Serializable;

public abstract interface BaseService<T, ID extends Serializable>
{
  public abstract int insert(T paramT);
  
  public abstract int updateById(T paramT);
  
  public abstract T getById(ID paramID);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\service\BaseService.class

 */
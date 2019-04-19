package com.rongdu.cashloan.core.common.util.factory;

import com.rongdu.cashloan.core.common.exception.ObjectNotFoundException;

public abstract interface ObjectFactory<T>
{
  public abstract T getObject(Object paramObject)
    throws ObjectNotFoundException;
}


/* factory\ObjectFactory.class

 */
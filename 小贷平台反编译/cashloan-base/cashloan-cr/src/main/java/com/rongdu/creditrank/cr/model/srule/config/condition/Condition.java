package com.rongdu.creditrank.cr.model.srule.config.condition;

import com.rongdu.creditrank.cr.model.srule.utils.ConditionOpt;

public abstract interface Condition<T>
{
  public abstract Condition<T> opt(ConditionOpt paramConditionOpt);
  
  public abstract Condition<T> value(T paramT);
  
  public abstract ConditionOpt getOpt();
  
  public abstract T getValue();
}

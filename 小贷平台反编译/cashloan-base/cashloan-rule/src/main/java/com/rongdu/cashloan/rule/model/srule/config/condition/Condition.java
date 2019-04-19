package com.rongdu.cashloan.rule.model.srule.config.condition;

import com.rongdu.cashloan.rule.model.srule.utils.ConditionOpt;

public abstract interface Condition<T>
{
  public abstract Condition<T> opt(ConditionOpt paramConditionOpt);
  
  public abstract Condition<T> value(T paramT);
  
  public abstract ConditionOpt getOpt();
  
  public abstract T getValue();
}

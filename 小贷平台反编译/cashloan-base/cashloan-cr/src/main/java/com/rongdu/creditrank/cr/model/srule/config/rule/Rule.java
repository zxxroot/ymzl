package com.rongdu.creditrank.cr.model.srule.config.rule;

import com.rongdu.creditrank.cr.model.srule.exception.RuleValueException;

public abstract interface Rule
{
  public abstract void matchTo(Object paramObject)
    throws RuleValueException;
  
  public abstract boolean beginMatch()
    throws RuleValueException;
  
  public abstract long getId();
  
  public abstract String getColumn();
  
  public abstract String getName();
}

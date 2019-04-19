package com.rongdu.creditrank.cr.model.srule.config.rule;

import com.rongdu.creditrank.cr.model.srule.config.condition.Condition;
import com.rongdu.creditrank.cr.model.srule.utils.RulePolicy;
import java.util.List;
import java.util.Map;

public abstract interface RuleBasic<T>
{
  public abstract void setId(long paramLong);
  
  public abstract void setColumn(String paramString);
  
  public abstract void setName(String paramString);
  
  public abstract void setValueType(Class<T> paramClass);
  
  public abstract void setConditions(List<Condition<T>> paramList);
  
  public abstract void setRulePolicy(RulePolicy paramRulePolicy);
  
  public abstract void setPreLoad(Map<T, Integer> paramMap);
}

package com.rongdu.cashloan.rule.model.srule.config.builder;

import com.rongdu.cashloan.rule.model.srule.config.condition.ConditionItem;

public abstract interface RuleBuilder<T>
{
  public abstract ConditionItem newConditionItems();
  
  public abstract RuleConfigurer<T> newRule(long paramLong, String paramString, ConditionItem paramConditionItem)
    throws IllegalAccessException, InstantiationException;
}


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\model\srule\config\builder\RuleBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
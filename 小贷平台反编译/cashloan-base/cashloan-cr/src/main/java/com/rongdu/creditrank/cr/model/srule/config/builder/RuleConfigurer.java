package com.rongdu.creditrank.cr.model.srule.config.builder;

import com.rongdu.creditrank.cr.model.srule.utils.RulePolicy;
import java.util.Map;

public abstract interface RuleConfigurer<H>
  extends Builder
{
  public abstract RuleConfigurer<H> rulePolicy(RulePolicy paramRulePolicy);
  
  public abstract RuleConfigurer<H> preLoad(Map<H, Integer> paramMap);
  
  public abstract RuleConfigurer<H> name(String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\model\srule\config\builder\RuleConfigurer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
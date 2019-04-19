package com.rongdu.creditrank.cr.model.srule.config.core;

import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
import com.rongdu.creditrank.cr.model.srule.exception.RuleNotFoundException;
import java.util.List;
import java.util.Map;

public abstract interface RulesLogic
{
  public abstract boolean doLogic(List<Rule> paramList);
  
  public abstract Map<Long, Boolean> rulesResult()
    throws RuleNotFoundException;
}

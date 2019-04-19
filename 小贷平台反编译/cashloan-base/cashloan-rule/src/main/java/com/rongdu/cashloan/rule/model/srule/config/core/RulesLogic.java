package com.rongdu.cashloan.rule.model.srule.config.core;

import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
import com.rongdu.cashloan.rule.model.srule.exception.RuleNotFoundException;
import java.util.List;
import java.util.Map;

public abstract interface RulesLogic
{
  public abstract boolean doLogic(List<Rule> paramList);
  
  public abstract Map<Long, Boolean> rulesResult()
    throws RuleNotFoundException;
}

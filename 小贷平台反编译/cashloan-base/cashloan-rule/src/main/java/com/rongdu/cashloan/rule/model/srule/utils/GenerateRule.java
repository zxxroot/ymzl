package com.rongdu.cashloan.rule.model.srule.utils;

import com.rongdu.cashloan.rule.model.srule.config.builder.RuleBuilder;
import com.rongdu.cashloan.rule.model.srule.config.builder.RuleBuilderCreator;
import com.rongdu.cashloan.rule.model.srule.config.condition.ConditionItem;
import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
import com.rongdu.cashloan.rule.model.srule.model.Formula;
import com.rongdu.cashloan.rule.model.srule.model.SimpleRule;
import tool.util.StringUtil;

public class GenerateRule {
    public static boolean genTextResult(String rule, String scop, String value) {
        return comparText(rule, scop, value);
    }

    public static boolean comparText(String formula, String scop, String value) {
        boolean result = false;
        if (Formula.include.getName().equals(formula)) {
            result = StringUtil.contains(scop, value);
        } else if (Formula.exclude.getName().equals(formula)) {
            result = !StringUtil.contains(scop, value);
        } else if (Formula.equal.getName().equals(formula)) {
            result = StringUtil.equals(scop, value);
        } else if (Formula.not_equal.getName().equals(formula)) {
            result = !StringUtil.equals(scop, value);

        } else if ((StringUtil.isNumber(scop)) && (StringUtil.isNumber(scop))) {
            SimpleRule simpleRule = new SimpleRule(Long.valueOf(0L), "name", formula, value, scop, "int", "");
            Rule rule = genNumRule(simpleRule);
            result = rule.beginMatch();
        }

        return result;
    }

    public static Rule genNumRule(Long id, String colName, String rule, String scop, Double value) {
        RuleBuilder<Double> builder = RuleBuilderCreator.numRuleBuilder();
        ConditionItem items = builder.newConditionItems();
        items.add(rule, Double.valueOf(scop));
        Rule rtRule = null;
        try {
            rtRule = builder.newRule(id.longValue(), colName, items).rulePolicy(RulePolicy.MATCHALL).build();
            rtRule.matchTo(value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtRule;
    }

    public static boolean genTextResult(SimpleRule rule) {
        return comparText(rule.getFormula(), rule.getRange(), rule.getValue());
    }


    public static Rule genNumRule(SimpleRule rule) {
        RuleBuilder<Double> builder = RuleBuilderCreator.numRuleBuilder();
        ConditionItem items = buildNumItems(builder, rule.getFormula(), rule.getRange());
        Rule rtRule = null;
        try {
            rtRule = builder.newRule(rule.getRuleId().longValue(), rule.getName(), items).rulePolicy(RulePolicy.MATCHALL).build();
            rtRule.matchTo(Double.valueOf(rule.getValue()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtRule;
    }


    public static ConditionItem buildNumItems(RuleBuilder<Double> builder, String formula, String range) {
        ConditionItem items = builder.newConditionItems();
        if (Formula.greater.getName().equals(formula)) {
            items.add(Formula.greater.getName(), Double.valueOf(range));
        } else if (Formula.less.getName().equals(formula)) {
            items.add(Formula.less.getName(), Double.valueOf(range));
        } else if (Formula.equal.getName().equals(formula)) {
            items.add(Formula.equal.getName(), Double.valueOf(range));
        } else if (Formula.not_equal.getName().equals(formula)) {
            items.add(Formula.not_equal.getName(), Double.valueOf(range));
        } else if (Formula.greater_equal.getName().equals(formula)) {
            items.add(Formula.greater_equal.getName(), Double.valueOf(range));
        } else if (Formula.less_equal.getName().equals(formula)) {
            items.add(Formula.less_equal.getName(), Double.valueOf(range));
        } else if (Formula.greater_equal_and_less_equal.getName().equals(formula)) {
            String[] ranges = range.trim().split(",");
            items.add(Formula.greater_equal.getName(), Double.valueOf(ranges[0]));
            items.add(Formula.less_equal.getName(), Double.valueOf(ranges[1]));
        } else if (Formula.greater_equal_and_less.getName().equals(formula)) {
            String[] ranges = range.trim().split(",");
            items.add(Formula.greater_equal.getName(), Double.valueOf(ranges[0]));
            items.add(Formula.less.getName(), Double.valueOf(ranges[1]));
        } else if (Formula.greater_and_less_equal.getName().equals(formula)) {
            String[] ranges = range.trim().split(",");
            items.add(Formula.greater.getName(), Double.valueOf(ranges[0]));
            items.add(Formula.less_equal.getName(), Double.valueOf(ranges[1]));
        } else if (Formula.greater_and_less.getName().equals(formula)) {
            String[] ranges = range.trim().split(",");
            items.add(Formula.greater.getName(), Double.valueOf(ranges[0]));
            items.add(Formula.less.getName(), Double.valueOf(ranges[1]));
        }
        return items;
    }
}

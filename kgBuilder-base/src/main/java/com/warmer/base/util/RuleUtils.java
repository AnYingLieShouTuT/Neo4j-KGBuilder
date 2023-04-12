package com.warmer.base.util;

import java.util.*;

public class RuleUtils {
    private static final String AND = "AND";
    private static final String OR = "OR";
    private static final String NOT = "NOT";

    public static void parseRules(String ruleString, List<String> andRules, List<String> orRules, List<String> notRules) {
        String[] rules = ruleString.split("\\s+");
        for (int i = 0; i < rules.length; i++) {
            String rule = rules[i].trim();
            if (rule.isEmpty()) {
                continue;
            }
            if (rule.equalsIgnoreCase(AND)) {
                addRule(i, rules, andRules);
            } else if (rule.equalsIgnoreCase(OR)) {
                addRule(i, rules, orRules);
            } else if (rule.equalsIgnoreCase(NOT)) {
                addRule(i, rules, notRules);
            }
        }
    }

    private static void addRule(int index, String[] rules, List<String> targetList) {
        for (int i = index + 1; i < rules.length; i++) {
            String rule = rules[i].trim();
            if (rule.isEmpty() || rule.equalsIgnoreCase(AND) || rule.equalsIgnoreCase(OR) || rule.equalsIgnoreCase(NOT)) {
                break;
            }
            targetList.add(rule);
        }
    }

}

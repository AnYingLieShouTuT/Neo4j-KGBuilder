package com.warmer.base.util;

import java.util.*;

public class RuleUtils {
    private static final String AND = "AND";
    private static final String OR = "OR";
    private static final String NOT = "NOT";

    public static void parseRules(String ruleString, List<String> andRules, List<String> orRules, List<String> notRules) {
        String[] rules = ruleString.split("\\s+");
        if (rules.length == 1 && !rules[0].isEmpty()) {
            andRules.add(ruleString.trim());
        }
        System.out.println(Arrays.toString(rules));
        int flag = 0;
        for (int i = 0; i < rules.length; i++) {
            String rule = rules[i].trim();
            if (rule.isEmpty()) {
                continue;
            }
            if (rule.equalsIgnoreCase(AND)) {
                if (flag == 0) {
                    andRules.add(rules[i - 1].trim());
                    flag = 1;
                }
                addRule(i, rules, andRules);
            } else if (rule.equalsIgnoreCase(OR)) {
                if (flag == 0) {
                    orRules.add(rules[i - 1].trim());
                    flag = 1;
                }
                addRule(i, rules, orRules);
            } else if (rule.equalsIgnoreCase(NOT)) {
                if (flag == 0) {
                    notRules.add(rules[i - 1].trim());
                    flag = 1;
                }
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

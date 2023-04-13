package com.warmer.web.request;

import lombok.Data;

@Data
public class BatchCreateRuleNodeItem {
    private String domain;
    private Integer ruleId;
    private String sourceId;
    private String sourceName;
    private Integer entityType;
    private String targetNames;
    private String[] sourceNames;
    private String relation;
}

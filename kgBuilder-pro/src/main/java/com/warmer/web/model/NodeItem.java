package com.warmer.web.model;

import lombok.Data;

@Data
public class NodeItem {
    private long uuid;
    private String name;//显示名称
    private String domain;//领域
    private String color;//颜色
    private Integer r;//半径
    private long isRule;//是否是规则节点，0-普通节点 1-规则节点 2-原子指标
    private long ruleId;//规则编号

    public NodeItem() {

    }

    public NodeItem(long uuid, String name, String color) {
        this.uuid = uuid;
        this.name = name;
        this.color = color;
    }

    public NodeItem(long uuid, String name, String color, Integer r) {
        this.uuid = uuid;
        this.name = name;
        this.color = color;
        this.r = r;
    }

    public NodeItem(long uuid, String name, String color, Integer r, String domain) {
        this.uuid = uuid;
        this.name = name;
        this.color = color;
        this.r = r;
        this.domain = domain;
    }
}

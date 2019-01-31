package com.dhbw.thinf.compilerbau.node;

public class UnaryOpNode {
    private String operator;
    private IVisitable subNode;

    public UnaryOpNode(String operator, IVisitable subNode) {
        this.operator = operator;
        this.subNode = subNode;
    }
}

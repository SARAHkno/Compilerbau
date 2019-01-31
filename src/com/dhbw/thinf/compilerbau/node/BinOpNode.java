package com.dhbw.thinf.compilerbau.node;

public class BinOpNode extends SyntaxNode {
    private String operator;
    private IVisitable left;
    private IVisitable right;

    public BinOpNode(String operator, IVisitable left, IVisitable right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }
}

package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public class BinOpNode extends SyntaxNode {
    private String operator;
    private IVisitable left;
    private IVisitable right;

    public BinOpNode(String operator, IVisitable left, IVisitable right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }

    public String getOperator() {
        return operator;
    }

    public IVisitable getLeft() {
        return left;
    }

    public IVisitable getRight() {
        return right;
    }
}

package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public class UnaryOpNode extends SyntaxNode implements IUnaryOpNode{
    private String operator;
    private IVisitable subNode;

    public UnaryOpNode(String operator, IVisitable subNode) {
        this.operator = operator;
        this.subNode = subNode;
    }

    public String getOperator() {
        return operator;
    }

    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }

    public IVisitable getSubNode() {
        return subNode;
    }
}

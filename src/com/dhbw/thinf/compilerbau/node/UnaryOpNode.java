package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public class UnaryOpNode extends SyntaxNode{
    private String operator;
    private IVisitable subNode;

    public UnaryOpNode(String operator, IVisitable subNode) {
        this.operator = operator;
        this.subNode = subNode;
    }

    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
}

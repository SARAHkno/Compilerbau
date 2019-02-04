package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public class OperandNode extends SyntaxNode {
    private int position;
    private String symbol;

    public OperandNode(String symbol) {
        position = -1;
        this.symbol = symbol;
    }
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPosition() {
        return position;
    }
}

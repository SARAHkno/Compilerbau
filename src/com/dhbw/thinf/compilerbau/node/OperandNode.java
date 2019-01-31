package com.dhbw.thinf.compilerbau.node;

public class OperandNode extends SyntaxNode {
    private int position;
    private String symbol;

    public OperandNode(String symbol) {
        position = -1;
        this.symbol = symbol;
    }
}

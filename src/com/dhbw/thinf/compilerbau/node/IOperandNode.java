package com.dhbw.thinf.compilerbau.node;

public interface IOperandNode extends IVisitable {

    void setPosition(int position);
    String getSymbol();
    int getPosition();

}

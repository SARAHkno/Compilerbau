package com.dhbw.thinf.compilerbau.node;

public interface IBinOpNode extends IVisitable{

     String getOperator();
     IVisitable getLeft();
     IVisitable getRight();

}

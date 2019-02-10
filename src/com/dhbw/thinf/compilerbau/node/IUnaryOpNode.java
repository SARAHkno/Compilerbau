package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public interface IUnaryOpNode extends IVisitable{

     String getOperator();
     void accept(IVisitor visitor);
     IVisitable getSubNode();
}

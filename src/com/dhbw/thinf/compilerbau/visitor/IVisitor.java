package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.IBinOpNode;
import com.dhbw.thinf.compilerbau.node.IOperandNode;
import com.dhbw.thinf.compilerbau.node.IUnaryOpNode;

public interface IVisitor {
    void visit(IOperandNode node);
    void visit(IBinOpNode node);
    void visit(IUnaryOpNode node);
}

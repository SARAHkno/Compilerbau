package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;

public interface IVisitor {
    void visit(OperandNode node);
    void visit(BinOpNode node);
    void visit(UnaryOpNode node);
}

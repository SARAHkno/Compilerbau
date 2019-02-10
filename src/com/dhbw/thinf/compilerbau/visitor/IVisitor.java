package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.IVisitable;

public interface IVisitor {
    void visit(IVisitable node);
}
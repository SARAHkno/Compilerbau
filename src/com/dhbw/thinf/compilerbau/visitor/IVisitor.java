package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.SyntaxNode;

public interface IVisitor {
    void visit(SyntaxNode node);
}

package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.IVisitable;

public interface IDepthFirstIterator {
    void traverse(IVisitable root, IVisitor visitor);
}

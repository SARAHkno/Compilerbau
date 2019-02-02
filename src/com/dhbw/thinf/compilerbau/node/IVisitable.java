package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

public interface IVisitable {
    void accept(IVisitor visitor);
}

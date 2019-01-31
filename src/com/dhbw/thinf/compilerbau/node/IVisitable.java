package com.dhbw.thinf.compilerbau.node;

public interface IVisitable {
    void accept(IVisitor visitor);
}

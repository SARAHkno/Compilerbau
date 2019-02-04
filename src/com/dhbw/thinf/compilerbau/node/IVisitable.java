package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

import java.util.HashSet;

public interface IVisitable {
    void accept(IVisitor visitor);
    boolean getNullable();
    HashSet<Integer> getFirstpos();
    HashSet<Integer> getLastpos();
}

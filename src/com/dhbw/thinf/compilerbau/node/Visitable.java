package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;

import java.util.Set;

public class Visitable implements IVisitable {
    @Override
    public void accept(IVisitor visitor) {

    }

    @Override
    public boolean getNullable() {
        return false;
    }

    @Override
    public Set<Integer> getFirstpos() {
        return null;
    }

    @Override
    public Set<Integer> getLastpos() {
        return null;
    }
}

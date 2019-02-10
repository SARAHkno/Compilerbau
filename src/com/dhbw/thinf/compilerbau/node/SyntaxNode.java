package com.dhbw.thinf.compilerbau.node;

import java.util.HashSet;
import java.util.Set;

public abstract class SyntaxNode implements IVisitable {

    protected boolean nullable;
    protected final Set<Integer> firstpos = new HashSet<>();
    protected final Set<Integer> lastpos  = new HashSet<>();

    @Override
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public void addFirstpos (int newFirstpos){
        firstpos.add(newFirstpos);
    }

    @Override
    public void addLastpos (int newLastpos){
        lastpos.add(newLastpos);
    }

    @Override
    public boolean getNullable() {
        return nullable;
    }

    @Override
    public Set<Integer> getFirstpos() {
        return firstpos;
    }

    @Override
    public Set<Integer> getLastpos() {
        return lastpos;
    }
}

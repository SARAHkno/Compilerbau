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
    public void addFirstposSet(Set<Integer> firstpos){
        this.firstpos.addAll(firstpos);
    }

    @Override
    public void addLastposSet(Set<Integer> lastpos){
        this.lastpos.addAll(lastpos);
    }

    @Override
    public void addFirstpos(int position) {
        firstpos.add(position);
    }

    @Override
    public void addLastpos(int position) {
        lastpos.add(position);
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

package com.dhbw.thinf.compilerbau.node;

import java.util.HashSet;
import java.util.Set;

public abstract class SyntaxNode implements IVisitable {

    protected Boolean nullable;
    protected final Set<Integer> firstpos = new HashSet<>();
    protected final Set<Integer> lastpos  = new HashSet<>();

    public void setNullable(boolean b){
        nullable = b;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public void addFirstpos (Integer newFirstpos){
        firstpos.add(newFirstpos);
    }

    public void addLastpos (Integer newLastpos){
        lastpos.add(newLastpos);
    }

    public boolean getNullable() {
        return nullable;
    }

    public Set<Integer> getFirstpos() {
        return firstpos;
    }

    public Set<Integer> getLastpos() {
        return lastpos;
    }
}

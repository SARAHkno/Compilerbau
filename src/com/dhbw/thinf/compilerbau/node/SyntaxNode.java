package com.dhbw.thinf.compilerbau.node;

import java.util.HashSet;
import java.util.Set;

public abstract class SyntaxNode implements IVisitable {
    protected Boolean nullable;
    protected final Set<Integer> firstpos = new HashSet<>();
    protected final Set<Integer> lastpos  = new HashSet<>();

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

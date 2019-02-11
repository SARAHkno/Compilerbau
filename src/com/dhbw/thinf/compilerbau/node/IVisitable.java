package com.dhbw.thinf.compilerbau.node;

import com.dhbw.thinf.compilerbau.visitor.IVisitor;
import java.util.Set;

public interface IVisitable {
    void accept(IVisitor visitor);
    boolean getNullable();
    void setNullable(boolean nullable);
    Set<Integer> getFirstpos();
    Set<Integer> getLastpos();
    void addFirstpos(int position);
    void addLastpos(int position);
}
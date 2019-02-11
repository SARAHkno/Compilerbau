package com.dhbw.thinf.compilerbau.dea;

import java.util.Set;

class DFAState implements Comparable<DFAState> {
    private final int index;
    private final boolean isAcceptingState;
    private final Set<Integer> positionSet;

    public DFAState(int index, boolean isAcceptingState, Set<Integer> positionSet) {
        this.index = index;
        this.isAcceptingState = isAcceptingState;
        this.positionSet = positionSet;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(object == null) {
                return false;
        }
        if(getClass() != object.getClass()) {
            return false;
        }
        DFAState other = (DFAState)object;
        return (other.index == this.index);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.index;
        return result;
    }

    @Override
    public int compareTo(DFAState other) {
        return (this.index - other.index);
    }
}
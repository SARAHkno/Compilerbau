package com.dhbw.thinf.compilerbau.visitor;

import java.util.HashSet;
import java.util.Set;

class FollowposTableEntry {

    private final int position;
    private final String symbol;
    public final Set<Integer> followPos;

    public FollowposTableEntry(int position, String symbol){
        this.position = position;
        this.symbol = symbol;
        this.followPos = new HashSet<>();
    }
}

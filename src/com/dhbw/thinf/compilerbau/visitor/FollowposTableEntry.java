package com.dhbw.thinf.compilerbau.visitor;

import java.util.HashSet;
import java.util.Set;

public class FollowposTableEntry {

    private int position;
    private String symbol;
    private Set<Integer> followPos;

    public FollowposTableEntry(int position, String symbol){
        this.position = position;
        this.symbol = symbol;
        this.followPos = new HashSet<>();
    }

    public void addAllFollowPos(Set<Integer> followPos) {
        this.followPos.addAll(followPos);
    }
}
package com.dhbw.thinf.compilerbau.visitor;

import java.util.HashSet;
import java.util.Set;

public class FollowposTableEntry {

    public  int position;
    public  String symbol;
    public  Set<Integer> followPos;

    public FollowposTableEntry(int position, String symbol){
        this.position = position;
        this.symbol = symbol;
        this.followPos = new HashSet<>();
    }
}
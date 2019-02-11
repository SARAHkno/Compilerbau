package com.dhbw.thinf.compilerbau.dea;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DeaBuilder implements IDeaBuilder {
    private SortedMap<DFAState, Map<Character, DFAState>> stateTransitionTable;

    public DeaBuilder(){
        stateTransitionTable = new TreeMap<>();
    }
}

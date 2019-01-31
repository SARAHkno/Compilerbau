package com.dhbw.thinf.compilerbau.Parser;

import com.dhbw.thinf.compilerbau.node.INode;
import java.util.TreeMap;

public class TopDownParser {
    private TreeMap<Integer, INode> syntaxtTree;

    public TopDownParser() {
        syntaxtTree = new TreeMap<>();
    }
}

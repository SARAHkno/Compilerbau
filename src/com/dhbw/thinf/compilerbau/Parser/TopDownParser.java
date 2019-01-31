package com.dhbw.thinf.compilerbau.Parser;

import com.dhbw.thinf.compilerbau.node.SyntaxNode;
import java.util.TreeMap;

public class TopDownParser {
    private TreeMap<Integer, SyntaxNode> syntaxtTree;

    public TopDownParser() {
        syntaxtTree = new TreeMap<>();
    }
}

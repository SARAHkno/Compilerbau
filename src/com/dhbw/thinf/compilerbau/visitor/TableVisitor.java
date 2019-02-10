package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.*;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TableVisitor implements IVisitor{

    private SortedMap<Integer, FollowposTableEntry> followposTableEntry = new TreeMap<>();
    private int count = 1;

    @Override
    public void visit(IVisitable node) {
        if (node instanceof OperandNode) {
            visitOpNode((OperandNode) node);
        } else if (node instanceof BinOpNode) {
            visitBinOpNode((BinOpNode) node);
        } else {
            visitUnaryOpNode((UnaryOpNode) node);
        }
    }

    private void visitOpNode(IOperandNode node) {
        followposTableEntry.put(count, new FollowposTableEntry(node.getPosition(), node.getSymbol()));
        count++;
    }

    private void visitBinOpNode(IBinOpNode node) {
        if (node.getOperator().equals("°")) {
            for (Integer lastPos : node.getLeft().getLastpos()) {
                for(Integer rightFirstPos : node.getRight().getFirstpos()) {
                    followposTableEntry.get(count).followPos.add(rightFirstPos);
                }
            }
        }
    }

    private void visitUnaryOpNode(IUnaryOpNode node) {
        if (node.getOperator().equals("*") || node.getOperator().equals("+")) {
            for (Integer i : node.getLastpos()){
                for (Integer firstPos : node.getSubNode().getFirstpos()){
                    followposTableEntry.get(count).followPos.add(firstPos);
                }
                for(Integer lastPos : node.getSubNode().getLastpos()){
                    followposTableEntry.get(count).followPos.add(lastPos);
                }
                // fistpos und lastpos von node
            }
        }
    }

    public SortedMap<Integer, FollowposTableEntry> getTable(){
        return followposTableEntry;
    }
}

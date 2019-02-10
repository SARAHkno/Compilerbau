package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;
import java.util.SortedMap;
import java.util.TreeMap;

public class TableVisitor implements IVisitor{

    private SortedMap<Integer, FollowposTableEntry> followposTableEntry = new TreeMap<>();
    private int count = 1;

    @Override
    public void visit(OperandNode node) {
        followposTableEntry.put(count, new FollowposTableEntry(node.getPosition(), node.getSymbol()));
        count++;
    }

    @Override
    public void visit(BinOpNode node) {
        switch(node.getOperator()){
            case "Ɛ":
                break;
            case "*":
                break;
            case "+":
                break;
            default:
                break;
        }
    }

    @Override
    public void visit(UnaryOpNode node) {

    }

    public SortedMap<Integer, FollowposTableEntry> getTable(){
        return followposTableEntry;
    }
}

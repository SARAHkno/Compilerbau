package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class TableVisitorTest {

    @Test
    void getOpNodeTable() {
        String symbol = "z";
        IVisitable operandNode = new OperandNode(symbol);
        TableVisitor tableVisitor = new TableVisitor();
        tableVisitor.visit(operandNode);
        SortedMap<Integer, FollowposTableEntry> getGeneratedMap =  tableVisitor.getTable();
        assertEquals(1, getGeneratedMap.size());
        assertEquals(symbol, getGeneratedMap.get(1).symbol);
    }

    @Test
    void getTable() {
    }
}
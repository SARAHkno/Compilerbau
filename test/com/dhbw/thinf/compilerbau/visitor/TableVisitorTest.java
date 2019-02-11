package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import org.junit.jupiter.api.*;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class TableVisitorTest {

    @Test
    void getOpNodeTable() {
        String symbol = "z";
        IVisitable operandNode = new OperandNode(symbol);
        IVisitor tableVisitor = new TableVisitor();
        tableVisitor.visit(operandNode);
        SortedMap<Integer, FollowposTableEntry> getGeneratedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(1, getGeneratedMap.size());
        assertEquals(symbol, getGeneratedMap.get(1).symbol);
    }

    @Test
    void getBinOpNodeTable() {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode(")");
        IVisitor visitor = new TableVisitor();
        visitor.visit(node1);
        visitor.visit(node2);

        IVisitable binOpNode = new BinOpNode("+", node1, node2);
        visitor.visit(binOpNode);
        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) visitor).getTable();
        assertEquals(2, generatedMap.size());

        binOpNode = new BinOpNode("°", node1, node2);
        visitor.visit(binOpNode);
        generatedMap = ((TableVisitor) visitor).getTable();
        assertEquals(2, generatedMap.size());
    }
}
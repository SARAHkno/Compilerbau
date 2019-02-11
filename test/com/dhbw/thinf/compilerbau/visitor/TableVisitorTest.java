package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;
import org.junit.jupiter.api.*;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class TableVisitorTest {

    @Test
    void getOpNodeTable() {
        String symbol = "z";
        IVisitable operandNode = new OperandNode(symbol);
        IVisitor visitor = new Visitor1();
        visitor.visit(operandNode);
        IVisitor tableVisitor = new TableVisitor();
        tableVisitor.visit(operandNode);
        SortedMap<Integer, FollowposTableEntry> getGeneratedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(1, getGeneratedMap.size());
        assertEquals(symbol, getGeneratedMap.get(1).symbol);
    }

    @Test
    void notValidBinOpNode() {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode(")");
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);

        IVisitable binOpNode = new BinOpNode("+", node1, node2);
        visitor.visit(binOpNode);

        IVisitor tableVisitor = new TableVisitor();
        tableVisitor.visit(node1);
        tableVisitor.visit(node2);

        tableVisitor.visit(binOpNode);
        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(2, generatedMap.size());
        assertEquals(0, generatedMap.entrySet().iterator().next().getValue().followPos.size());
    }

    @Test
    void validBinOpNode() {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode(")");
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);


        IVisitable binOpNode = new BinOpNode("°", node1, node2);
        visitor.visit(binOpNode);

        IVisitor tableVisitor = new TableVisitor();
        tableVisitor.visit(node1);
        tableVisitor.visit(node2);
        tableVisitor.visit(binOpNode);
        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(2, generatedMap.size());
        //System.out.println(((BinOpNode) binOpNode).getRight().getFirstpos().iterator().next());
        assertEquals(2,generatedMap.get(2).followPos.iterator().next());
    }

    @Test
    void notValidUnaryNode() {
        IVisitable node1 = new OperandNode("a");
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);

        IVisitor tableVisitor = new TableVisitor();
        IVisitable unaryNode = new UnaryOpNode("|", node1);
        visitor.visit(unaryNode);
        tableVisitor.visit(node1);
        tableVisitor.visit(unaryNode);

        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(1, generatedMap.size());
        assertEquals(0, generatedMap.entrySet().iterator().next().getValue().followPos.size());
    }

    @Test
    void validUnaryNode() {
        IVisitable node1 = new OperandNode("a");
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);

        IVisitor tableVisitor = new TableVisitor();
        IVisitable unaryNode = new UnaryOpNode("+", node1);
        visitor.visit(unaryNode);
        tableVisitor.visit(node1);
        tableVisitor.visit(unaryNode);

        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) tableVisitor).getTable();
        assertEquals(1, generatedMap.size());
        System.out.println(generatedMap.entrySet().iterator().next().getValue().followPos.size());
    }


}
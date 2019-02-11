package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


class Visitor1Test {

    @Test
    void visitOperandNode() {
        IVisitable openrandNode = new OperandNode("#");
        IVisitor visitor = new Visitor1();
        visitor.visit(openrandNode);
        assertFalse(openrandNode.getNullable());

        //Nullable Node
        IVisitable nullableNode = new OperandNode("Ɛ");
        visitor.visit(nullableNode);
        assertTrue(nullableNode.getNullable());
    }

    @Test
    void visitBinOpNode() {
        //Creating nodes for BinOpNode
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode("Ɛ");
        //Adding notes to BinOpNode
        IBinOpNode binOpNode = new BinOpNode("|", node1, node2);

        //Visit each node
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);
        visitor.visit(binOpNode);

        assertTrue(binOpNode.getNullable());
    }

    @Test
    void visitBinOpNodeNotNullable() {
        //Creating nodes for BinOpNode
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode("T");
        //Adding notes to BinOpNode
        IBinOpNode binOpNode = new BinOpNode("|", node1, node2);

        //Visit each node
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);
        visitor.visit(binOpNode);
        assertFalse(binOpNode.getNullable());
    }

    @Test
    void visitBinOpNodeConcatination() {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode("{");
        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);

        IBinOpNode binOpNode = new BinOpNode("°", node1, node2);
        visitor.visit(binOpNode);

        assertFalse(binOpNode.getNullable());
    }


    @Test
    void visitUnaryOpNode() {
        IVisitable subNodeNotNullable = new OperandNode("a");
        IVisitable subNodeNullable = new OperandNode("Ɛ");
        IVisitable unaryNode = new UnaryOpNode("?", subNodeNotNullable);
        IVisitor visitor = new Visitor1();
        visitor.visit(subNodeNotNullable);
        visitor.visit(subNodeNullable);

        //Nullable Node
        visitor.visit(unaryNode);
        assertTrue(unaryNode.getNullable());

        //Nullable SubNode
        unaryNode = new UnaryOpNode("a", subNodeNullable);
        visitor.visit(unaryNode);
        assertTrue(unaryNode.getNullable());

        //Define a not nullable node
        unaryNode = new UnaryOpNode("a", subNodeNotNullable);
        visitor.visit(unaryNode);
        assertFalse(unaryNode.getNullable());
    }
}
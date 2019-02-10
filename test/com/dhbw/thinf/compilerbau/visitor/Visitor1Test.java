package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IBinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.Visitable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Visitor1Test {

    IBinOpNode binOpNode;

    @BeforeEach
    void setUp() {
        //Creating Visitables
        IVisitable visitableRight = new Visitable();
        IVisitable visitableLeft = new Visitable();
        //Create Nodes
        binOpNode = new BinOpNode("s", visitableRight, visitableLeft);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void visitBinOpNode() {
        IVisitor visitor = new Visitor1();
    }

    @Test
    void visit1() {
    }

    @Test
    void visit2() {
    }
}
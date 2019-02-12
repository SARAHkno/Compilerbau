package com.dhbw.thinf.compilerbau.parser;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;
import com.dhbw.thinf.compilerbau.visitor.FollowposTableEntry;
import com.dhbw.thinf.compilerbau.visitor.IVisitor;
import com.dhbw.thinf.compilerbau.visitor.TableVisitor;
import com.dhbw.thinf.compilerbau.visitor.Visitor1;
import org.junit.jupiter.api.Test;


import java.util.Set;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class TopDownParserTest {

    @Test
    void parse() throws Exception {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode("b");
        IVisitable node3 = new OperandNode("C");
        IVisitable node4 = new UnaryOpNode("*", node1);
        IVisitable node5 = new BinOpNode("°", node4, node2);
        IVisitable node6 = new BinOpNode("°" ,node5,node3);

        IVisitor visitor = new Visitor1();
        visitor.visit(node1);
        visitor.visit(node2);
        visitor.visit(node3);
        visitor.visit(node4);
        visitor.visit(node5);
        visitor.visit(node6);

        IVisitor tableVisitor = new TableVisitor();

        tableVisitor.visit(node1);
        tableVisitor.visit(node2);
        tableVisitor.visit(node3);
        tableVisitor.visit(node4);
        tableVisitor.visit(node5);
        tableVisitor.visit(node6);

        SortedMap<Integer, FollowposTableEntry> generatedMap = ((TableVisitor) tableVisitor).getTable();

        ITopDownParser parser = new TopDownParser();
        IVisitable node = parser.parse();


    }

}
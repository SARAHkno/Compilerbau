package com.dhbw.thinf.compilerbau.parser;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TopDownParserTest {

    @Test
    void parse() throws Exception {
        IVisitable node1 = new OperandNode("a");
        IVisitable node2 = new OperandNode("b");
        IVisitable node3 = new OperandNode("C");
        IVisitable close = new OperandNode("#");
        IVisitable node4 = new UnaryOpNode("*", node1);
        IVisitable node5 = new BinOpNode("°", node4, node2);
        IVisitable node6 = new BinOpNode("°" ,node5,node3);
        IVisitable node7 = new BinOpNode("°", node6, close);



        ITopDownParser parser = new TopDownParser();
        IVisitable node = parser.parse();

        assertEquals(node7.getNullable(), node.getNullable());


    }

}
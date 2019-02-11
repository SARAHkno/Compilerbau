package com.dhbw.thinf.compilerbau;

import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.parser.ITopDownParser;
import com.dhbw.thinf.compilerbau.parser.TopDownParser;
import com.dhbw.thinf.compilerbau.visitor.*;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        //Initialisation of all needed components
        ITopDownParser parser = new TopDownParser();
        IVisitor visitor1 = new Visitor1();
        IVisitor tableVisitor = new TableVisitor();
        IDepthFirstIterator depthFirstIterator = new DepthFirstIterator();
        //Parsing SyntaxTree
        IVisitable syntaxTree = parser.parse();
        //Using both visitors with depthFirstIteration
        depthFirstIterator.traverse(syntaxTree, visitor1);
        depthFirstIterator.traverse(syntaxTree, tableVisitor);
    }
}

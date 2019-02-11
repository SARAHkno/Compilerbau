package com.dhbw.thinf.compilerbau;

import com.dhbw.thinf.compilerbau.parser.ITopDownParser;
import com.dhbw.thinf.compilerbau.parser.TopDownParser;
import com.dhbw.thinf.compilerbau.visitor.*;

public class Appilcation {
    public static void main(String[] args) {
        ITopDownParser parser = new TopDownParser();
        IVisitor visitor1 = new Visitor1();
        IVisitor tableVisitor = new TableVisitor();
        IDepthFirstIterator depthFirstIterator = new DepthFirstIterator();
        depthFirstIterator.traverse(parser.parse(), visitor1);
    }
}

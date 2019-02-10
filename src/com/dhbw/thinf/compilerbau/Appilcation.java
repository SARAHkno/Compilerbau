package com.dhbw.thinf.compilerbau;

import com.dhbw.thinf.compilerbau.parser.ITopDownParser;
import com.dhbw.thinf.compilerbau.parser.TopDownParser;
import com.dhbw.thinf.compilerbau.visitor.IVisitor;
import com.dhbw.thinf.compilerbau.visitor.TableVisitor;
import com.dhbw.thinf.compilerbau.visitor.Visitor1;

public class Appilcation {
    public static void main(String[] args) {
        ITopDownParser parser = new TopDownParser();
        IVisitor visitor1 = new Visitor1();
        IVisitor tableVisitor = new TableVisitor();
    }
}

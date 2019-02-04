package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;

public class Visitor1 implements IVisitor{

    private int positioncounter = 1;

    @Override
    public void visit(OperandNode node) {

        //position
        node.setPosition(positioncounter);
        positioncounter ++;

        //nullable
        if (node.getSymbol().equals("epsilon")){
            node.setNullable(true);
        }
        else {
            node.setNullable(false);
        }

        //firstpos and lastpos
        if (node.getNullable() == false){
            node.addFirstpos((Integer) node.getPosition());
            node.addLastpos((Integer) node.getPosition());
        }

    }

    @Override
    public void visit(BinOpNode node) {
        //for or nodes:
        if (node.getOperator().equals("|")) {
            //nullable
            if (node.getLeft().getNullable() == true || node.getRight().getNullable() == true){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //firstpos
            for (int firstposleft: node.getLeft().getFirstpos()) {
                node.addFirstpos(firstposleft);
            }
            for (int firstposright: node.getRight().getFirstpos()) {
                node.addFirstpos(firstposright);
            }

            //lastpos
            for (int lastposleft: node.getLeft().getLastpos()) {
                node.addFirstpos(lastposleft);
            }
            for (int lastposright: node.getRight().getLastpos()) {
                node.addFirstpos(lastposright);
            }
        }

        //for concatenation nodes
        if (node.getOperator().equals("*")){
            //nullable
            if (node.getLeft().getNullable() == true && node.getRight().getNullable() == true){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //firstpos
            if (node.getLeft().getNullable() == true){
                //add firstpos right
                for (int firstposright: node.getRight().getFirstpos()) {
                    node.addFirstpos(firstposright);
                }
            }
            //add firstpos left
            for (int firstposleft: node.getLeft().getFirstpos()) {
                node.addFirstpos(firstposleft);
            }

            //lastpos
            if (node.getRight().getNullable() == true){
                //add lastpos left
                for (int lastposleft: node.getLeft().getLastpos()) {
                    node.addFirstpos(lastposleft);
                }
            }
            //add lastpos right
            for (int lastposright: node.getRight().getLastpos()) {
                node.addFirstpos(lastposright);
            }
        }
    }

    @Override
    public void visit(UnaryOpNode node) {
        //nullable
        if (node.getOperator().equals("*") || node.getOperator().equals("?")){
            node.setNullable(true);
        }
        else {
            node.setNullable(node.getLeft().getNullable());
        }

        //firstpos
        for (int firstposleft: node.getLeft().getFirstpos()) {
            node.addFirstpos(firstposleft);
        }

        //lastpos
        for (int lastposright: node.getRight().getLastpos()) {
            node.addFirstpos(lastposright);
        }
    }
}

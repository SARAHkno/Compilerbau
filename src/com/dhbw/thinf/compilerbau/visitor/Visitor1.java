package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.*;

public class Visitor1 implements IVisitor{

    private int positionCounter = 1;

    @Override
    public void visit(IVisitable node) {
        if (node instanceof OperandNode) {
             visitOpNode((OperandNode)node);
        }
        if (node instanceof BinOpNode) {
            visitBinOpNode((BinOpNode) node);
        }
        if (node instanceof UnaryOpNode) {
            visitUnaryOpNode((UnaryOpNode) node);
        }
    }

    private void visitOpNode(IOperandNode node) {
        //position
        node.setPosition(positionCounter);
        positionCounter++;
        //nullable
        if (node.getSymbol().equals("Ɛ")) {
            node.setNullable(true);
        } else {
            node.setNullable(false);
        }
        //firstpos and lastpos
        if (!node.getNullable()){
            node.addFirstpos(node.getPosition());
            node.addLastpos(node.getPosition());
        }
    }

    private void visitBinOpNode(IBinOpNode node) {
        //for or nodes:
        if (node.getOperator().equals("|")) {
            //nullable
            if (node.getLeft().getNullable() || node.getRight().getNullable()){
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
            if (node.getLeft().getNullable() && node.getRight().getNullable()){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }
            //firstpos
            if (node.getLeft().getNullable()){
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
            if (node.getRight().getNullable()){
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

    private void visitUnaryOpNode(IUnaryOpNode node) {
        //nullable
        if (node.getOperator().equals("*") || node.getOperator().equals("?")){
            node.setNullable(true);
        }
        else {
            node.setNullable(node.getSubNode().getNullable());
        }
        //firstpos
        for (int firstposleft: node.getSubNode().getFirstpos()) {
            node.addFirstpos(firstposleft);
        }
        //lastpos
        for (int lastposright: node.getSubNode().getLastpos()) {
            node.addFirstpos(lastposright);
        }
    }
}
package com.dhbw.thinf.compilerbau.visitor;
import com.dhbw.thinf.compilerbau.node.*;

//first visitor for position, nullable, firstpos, lastpos
public class Visitor1 implements IVisitor{

    //counter for position
    private int positionCounter = 1;

    @Override
    //wrapper-method to avoid overloading of visitor method
    public void visit(IVisitable node) {
        //for operand nodes
        if (node instanceof OperandNode) {
             visitOpNode((OperandNode)node);
        }
        //for BinOpNodes
        if (node instanceof BinOpNode) {
            visitBinOpNode((BinOpNode) node);
        }
        //for UnaryOpNodes
        if (node instanceof UnaryOpNode) {
            visitUnaryOpNode((UnaryOpNode) node);
        }
    }

    private void visitOpNode(IOperandNode node) {
        //set position
        node.setPosition(positionCounter);
        positionCounter++;

        //set nullable
        if (node.getSymbol().equals("Ɛ")) {
            node.setNullable(true);
        } else {
            node.setNullable(false);
        }

        //set firstpos and lastpos
        if (!node.getNullable()){
            //add firstpos
            node.addFirstpos(node.getPosition());
            //add lastpos
            node.addLastpos(node.getPosition());
        }
    }

    private void visitBinOpNode(IBinOpNode node) {
        //for or nodes:
        if (node.getOperator().equals("|")) {

            //set nullable
            if (node.getLeft().getNullable() || node.getRight().getNullable()){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //set firstpos
            //add firstpos left
            for (int firstposleft: node.getLeft().getFirstpos()) {
                node.addFirstpos(firstposleft);
            }
            //add firstpos right
            for (int firstposright: node.getRight().getFirstpos()) {
                node.addFirstpos(firstposright);
            }

            //set lastpos
            //add lastpos left
            for (int lastposleft: node.getLeft().getLastpos()) {
                node.addLastpos(lastposleft);
            }
            //add lastpos right
            for (int lastposright: node.getRight().getLastpos()) {
                node.addLastpos(lastposright);
            }
        }

        //for concatenation nodes
        if (node.getOperator().equals("°")){

            //set nullable
            if (node.getLeft().getNullable() && node.getRight().getNullable()){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //set firstpos
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
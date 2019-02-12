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
            //add firstpos left and right
            node.addFirstposSet(node.getLeft().getFirstpos());
            node.addFirstposSet(node.getRight().getFirstpos());

            //set lastpos
            //add lastpos left and right
            node.addLastposSet(node.getLeft().getLastpos());
            node.addLastposSet(node.getRight().getLastpos());
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
                node.addFirstposSet(node.getRight().getFirstpos());
            }
            //add firstpos left
            node.addFirstposSet(node.getLeft().getFirstpos());
            //lastpos
            if (node.getRight().getNullable()){
                //add lastpos left
                node.addFirstposSet(node.getLeft().getLastpos());
            }
            //add lastpos right
            node.addFirstposSet(node.getRight().getLastpos());
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
        //firstpos & lastpos
        node.addFirstposSet(node.getSubNode().getFirstpos());
        node.addLastposSet(node.getSubNode().getLastpos());
    }
}
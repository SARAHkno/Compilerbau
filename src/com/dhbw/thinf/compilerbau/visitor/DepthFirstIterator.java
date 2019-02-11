package com.dhbw.thinf.compilerbau.visitor;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;

public class DepthFirstIterator implements IDepthFirstIterator{

    @Override
    public void traverse(IVisitable root, IVisitor visitor){
        if(root instanceof OperandNode){
            root.accept(visitor);
        }
        if(root instanceof BinOpNode){
            BinOpNode opNode = (BinOpNode) root;
            traverse(opNode.getLeft(), visitor);
            traverse(opNode.getRight(), visitor);
            opNode.accept(visitor);
            return;
        }
        if(root instanceof UnaryOpNode){
            UnaryOpNode opNode = (UnaryOpNode) root;
            traverse(opNode.getSubNode(), visitor);
            opNode.accept(visitor);
            return;
        }
        throw new RuntimeException("Instance root has a bad type!");
    }
}

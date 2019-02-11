package com.dhbw.thinf.compilerbau.parser;

import com.dhbw.thinf.compilerbau.node.BinOpNode;
import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;
import com.dhbw.thinf.compilerbau.node.UnaryOpNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopDownParser implements ITopDownParser {
    private String regEx;
    private int position;
    private List<Character> terminals;
    private List<Character> unaryOperators;

    //Reading in the RegEx and filling Lists with alphanum and unary Operators
    public TopDownParser() throws IOException {
        readRegEx();
        position = 0;
        terminals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            terminals.add((char) (97 + i));
        }
        for (int i = 0; i < 26; i++) {
            terminals.add((char) (65 + i));
        }
        for (int i = 0; i < 10; i++) {
            terminals.add((char) (48 + i));
        }
        unaryOperators = Arrays.asList('?', '*', '+');
    }

    //Reads the RegEx from File regEx.txt
    private void readRegEx() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("res" + System.getProperty("file.separator") + "regEx.txt"))) {
            regEx = bufferedReader.readLine();
        }
    }

    //Returns SyntaxTree
    @Override
    public IVisitable parse() {
        return start();
    }

    //Start-Rule
    private IVisitable start() {
        //if RegEx only contains # --> new OperandNode("#");
        //if RegEx length is larger 1 and read in expression matches (...)# --> new BinOpNode with call of regEx
        //else invalid symbol at this position --> new Error
        if (regEx.length() == 1 && charEquals('#')) {
            return new OperandNode("#");
        } else if (regEx.length() > 1) {
            match('(');
            IVisitable subTree = regEx();
            match(')');
            match('#');
            endOfRegEx();
            return new BinOpNode("°", subTree, new OperandNode("#"));
        } else {
            throw new Error(generateErrorMessage());
        }
    }

    //RegEx-Rule
    private IVisitable regEx() {
        //if RegEx at current position matches an alphanum or ( --> call term and RE
        //else invalid symbol at this position --> new Error
        if (terminals.contains(regEx.charAt(position)) || charEquals('(')) {
            return RE(term(null));
        }
        throw new Error(generateErrorMessage());
    }

    //RE-Rule
    private IVisitable RE(IVisitable parameter) {
        //if RegEx matches ) --> return parameter (passed from term)
        //if RegEx matches | --> call itself with new BinaryOpNode as parameter
        //else invalid symbol at this position --> new Error (check in match method included)
        if (charEquals(')')) {
            return parameter;
        } else {
            match('|');
            IVisitable root = new BinOpNode("|", parameter, term(null));
            return RE(root);
        }
    }

    //Term-Rule
    private IVisitable term(IVisitable parameter) {
        //if RegEx matches alphanum or ( --> call term(new BinOpNode) or term(factor()), depending on parameter
        //if RegEx matches ) or | --> return (passed in) parameter
        //else invalid symbol at this position --> new Error
        if (terminals.contains(regEx.charAt(position)) || charEquals('(')) {
            return parameter != null ?
                    term(new BinOpNode("°", parameter, factor())) :
                    term(factor());
        }
        if (charEquals(')') || charEquals('|')) {
            return parameter;
        }
        throw new Error(generateErrorMessage());
    }

    //Factor-Rule
    private IVisitable factor() {
        //if RegEx matches an alphanum or ( --> call elem and HOp
        //else invalid symbol at this position --> new Error
        if (terminals.contains(regEx.charAt(position)) || charEquals('(')) {
            return HOp(elem());
        }
        throw new Error(generateErrorMessage());
    }

    //HOp-Rule
    private IVisitable HOp(IVisitable parameter) {
        //if RegEx matches unary Operator --> new UnaryOpNode (with Child Node)
        //if RegEx matches alphanum, (, ), or | --> return parameter (= do nothing)
        //else invalid symbol at this position --> new Error
        if (unaryOperators.contains(regEx.charAt(position))) {
            UnaryOpNode unaryOpNode = new UnaryOpNode(String.valueOf(regEx.charAt(position)), parameter);
            position++;
            return unaryOpNode;
        }
        if (terminals.contains(regEx.charAt(position)) || charEquals('(') || charEquals(')') || charEquals('|')) {
            return parameter;
        }
        throw new Error(generateErrorMessage());
    }

    //Elem-Rule
    private IVisitable elem() {
        //if RegEx matches alphanum --> return an alphanum
        //if RegEx mtches (...) --> call regEx
        //else invalid symbol at this position --> new Error (check is included in match method)
        if (terminals.contains(regEx.charAt(position))) {
            return alphanum();
        } else {
            match('(');
            IVisitable subtree = regEx();
            match(')');
            return subtree;
        }
    }

    //Alphanum-Rule
    private IVisitable alphanum() {
        //if RegEx matches alphanum --> new OperandNode(symbol at position)
        //else invalid symbol at this position --> new Error
        if (terminals.contains(regEx.charAt(position))) {
            OperandNode operandNode = new OperandNode(String.valueOf(regEx.charAt(position)));
            position++;
            return operandNode;
        }
        throw new Error(generateErrorMessage());
    }

    //Return true if passed in symbol matches the RegEx at the current position
    private boolean charEquals(char comp) {
        return regEx.charAt(position) == comp;
    }

    //Increase the position if passed in symbol matches the RegEx at current position, else throws new Error
    private void match(char symbol) {
        if (charEquals(symbol)) {
            position++;
        } else {
            throw new Error(generateErrorMessage());
        }
    }

    //if called the method returns the corresponding error message
    private String generateErrorMessage() {
        return "Invalid Symbol at position " + position + " found!";
    }

    //Throws new error if end of RegEx isn´t reached
    private void endOfRegEx() {
        if (position != regEx.length()) {
            throw new Error(generateErrorMessage());
        }
    }
}
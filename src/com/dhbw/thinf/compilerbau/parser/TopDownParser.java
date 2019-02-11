package com.dhbw.thinf.compilerbau.parser;

import com.dhbw.thinf.compilerbau.node.IVisitable;
import com.dhbw.thinf.compilerbau.node.OperandNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopDownParser implements ITopDownParser {
    private IVisitable tree;

    public TopDownParser() {
    }

    private String readRegEx() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("res" + System.getProperty("file.separator") + "regEx.txt"))) {
            return bufferedReader.readLine();
        }
    }

    @Override
    public IVisitable parse() {
        return start();
    }

    private IVisitable start() {
        return new OperandNode("#");
    }

    //only for debugging
    public static void main(String[] args) throws IOException {
        TopDownParser parser = new TopDownParser();
        parser.parse();
    }
}
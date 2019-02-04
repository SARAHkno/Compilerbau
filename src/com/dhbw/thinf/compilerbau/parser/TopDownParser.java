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
                new FileReader("res" + System.getProperty("file.separator" + "regEx.txt")))) {
            return bufferedReader.readLine();
        }
    }

    //Ka was ich mach
    @Override
    public void parse() throws Exception {
        String inputLine = readRegEx();
        if (inputLine.contains("#")) {
            if (inputLine.equals("#")) {
                tree = new OperandNode("#");
            } else if (inputLine.lastIndexOf("#") == inputLine.length() - 1) {
                // do something
            } else {
                throw new Exception("Not a valid regular Expression!");
            }
        } else {
            throw new Exception("Not a valid regular Expression!");
        }

    }
}
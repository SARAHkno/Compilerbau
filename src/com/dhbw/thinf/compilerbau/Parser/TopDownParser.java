package com.dhbw.thinf.compilerbau.Parser;

import com.dhbw.thinf.compilerbau.node.IVisitable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopDownParser implements ITopDownParser {
    private IVisitable tree;

    private String readRegEx() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("res" + System.getProperty("file.separator" + "regEx.txt")))) {
            return bufferedReader.readLine();
        }
    }

    @Override
    public void parse() throws IOException {
        String inputLine = readRegEx();

    }
}
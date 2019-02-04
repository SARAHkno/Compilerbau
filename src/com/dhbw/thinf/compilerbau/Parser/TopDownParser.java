package com.dhbw.thinf.compilerbau.Parser;

import com.dhbw.thinf.compilerbau.node.IVisitable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopDownParser implements ITopDownParser {
    private IVisitable tree;
    private List<Character> terminalChars;

    public TopDownParser() {
        terminalChars = new ArrayList<>();
        //adding all terminal Chars
        terminalChars.addAll(Arrays.asList('a', 'b', 'c'));
    }

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
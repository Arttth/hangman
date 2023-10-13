package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class WordFileReader {
    public static HashSet<String> getWords(HashSet<String> words) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dict"));
            String line;
            do {
                line = bufferedReader.readLine();
                words.add(line);
            } while (line != null);
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
        return words;
    }
}

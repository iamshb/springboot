package com.s2.springboot.sample.fp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FPSample {

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFileFP(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
}

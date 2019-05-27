package com.s2.springboot.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineRunner {

    public static boolean execute(String command) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));

        String msg;
        StringBuffer output = new StringBuffer();
        while ((msg = br.readLine()) != null) {
            output.append(msg + System.getProperty("line.separator"));
            System.out.println("# msg : " + msg);
        }

        process.waitFor();

        if (process.exitValue() == 0) {
            System.out.println("# success");
        } else {
            System.out.println("# Failure");
            return false;
        }

        return true;
    }
}

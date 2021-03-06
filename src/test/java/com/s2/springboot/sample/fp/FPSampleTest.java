package com.s2.springboot.sample.fp;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FPSampleTest {
    private FPSample fpSample;

    @Before
    public void setUp() {
        fpSample = new FPSample();
    }

    @Test
    public void processFile() throws IOException {
        System.out.println(FPSample.processFile());
    }

    @Test
    public void processFileFP() throws IOException {
        System.out.println(FPSample.processFileFP((p) -> p.readLine() + p.readLine()));
    }
}
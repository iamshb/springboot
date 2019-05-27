package com.s2.springboot.sample.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class FPSampleTest {
    private FPSample fpSample;

    @BeforeEach
    void setUp() {
        fpSample = new FPSample();
    }

    @Test
    void processFile() throws IOException {
        System.out.println(FPSample.processFile());
    }

    @Test
    void processFileFP() throws IOException {
        System.out.println(FPSample.processFileFP((p) -> p.readLine() + p.readLine()));
    }
}
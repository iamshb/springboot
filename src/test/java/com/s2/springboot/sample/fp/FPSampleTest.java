package com.s2.springboot.sample.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FPSampleTest {
    private FPSample fpSample;

    @BeforeEach
    void setUp() {
        fpSample = new FPSample();
    }

    @Test
    void processFile() throws IOException {
        FPSample.processFile();
    }

    @Test
    void processFileFP() throws IOException {
        FPSample.processFileFP((p) -> p.readLine() + p.readLine());
    }
}
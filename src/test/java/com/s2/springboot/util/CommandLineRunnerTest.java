package com.s2.springboot.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineRunnerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void execute() throws IOException, InterruptedException {
        boolean actural = CommandLineRunner.execute("pwd");
        assertEquals(true, actural);
    }
}
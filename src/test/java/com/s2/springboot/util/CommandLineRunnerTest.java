package com.s2.springboot.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CommandLineRunnerTest {

    @Before
    public void setUp() {
    }

    @Test
    public void execute() throws IOException, InterruptedException {
        boolean actural = CommandLineRunner.execute("pwd");
        assertEquals(true, actural);
        assertThat(actural).isEqualTo(true);
    }
}
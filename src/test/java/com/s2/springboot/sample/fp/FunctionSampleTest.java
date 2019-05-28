package com.s2.springboot.sample.fp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionSampleTest {

    @Test
    void map() {
        FunctionSample fs = new FunctionSample();
        List<Integer> list =  fs.map(Arrays.asList("lamda", "in", "action"),
                (String s) -> s.length()
                );

        assertEquals(3, list.size());
        System.out.println(list);
    }
}
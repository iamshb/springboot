package com.s2.springboot.sample.fp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FunctionSampleTest {

    @Test
    public void map() {
        FunctionSample fs = new FunctionSample();
        List<Integer> list =  fs.map(Arrays.asList("lamda", "in", "action"),
                (String s) -> s.length()
                );

        assertEquals(3, list.size());
        System.out.println(list);
    }
}
package com.s2.springboot.sample.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionSample {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s: list) {
            result.add(f.apply(s));
        }

        return result;
    }
}
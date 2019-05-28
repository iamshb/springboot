package com.s2.springboot.sample.fp;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

package com.s2.springboot.service;

import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    ListenableFuture<String> simpleLFAsync();
    CompletableFuture<String> simpleCAsync();
    CompletableFuture<String> casync();
    CompletableFuture<String> casync2(String res1);
}

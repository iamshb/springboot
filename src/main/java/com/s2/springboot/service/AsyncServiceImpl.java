package com.s2.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async("myExecutor")
    public ListenableFuture<String> simpleLFAsync() {
        return new AsyncResult<>("hello Listenable Future");
    }

    @Override
    @Async("myExecutor")
    public CompletableFuture<String> simpleCAsync() {
        return CompletableFuture.completedFuture("hello Completable Future");
    }

    @Override
    @Async("myExecutor")
    public CompletableFuture<String> casync() {
        return CompletableFuture.completedFuture("hello casync");
    }

    @Override
    @Async("myExecutor")
    public CompletableFuture<String> casync2(String res1) {
        return CompletableFuture.completedFuture(res1 + "\n" + "hello casync2");
    }
}

package com.s2.springboot.controller;

import com.s2.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/callable")
    Callable<String> callable() {
        return () -> {
            return "hello callable.";
        };
    }

    @GetMapping("/webasynctask")
    WebAsyncTask<String> webAsyncTask() {
        return new WebAsyncTask<>(5000L, "myAsyncExecutor",
                () -> {
                    return "hello web async task.";
                });
    }

    @GetMapping("/deferred")
    public DeferredResult<String> defferred() {
        DeferredResult dr = new DeferredResult();

        ListenableFuture<String> lf = asyncService.simpleLFAsync();
        lf.addCallback(r -> {
            dr.setResult(r);
        }, e -> {
            dr.setErrorResult(e);
        });

        return dr;
    }

    // 위의 예제와 동일하게 동작함
    @GetMapping("/simplelf")
    ListenableFuture<String> listenableFuture() {
        return asyncService.simpleLFAsync();
    }

    @GetMapping("/simplecf")
    CompletableFuture<String> completableFuture() {
        CompletableFuture<String> f = asyncService.simpleCAsync();
        f.thenAccept(r -> System.out.println(r));
        return f;
    }

    @GetMapping("composecf")
    CompletableFuture<String> composeCompletableFuture() {
//        CompletableFuture<String> f1 = asyncService.casync();
//        CompletableFuture<String> f2 = f1.thenCompose(res1 -> asyncService.casync2(res1));
//
//        return f2;

        return asyncService.casync()
                .thenCompose(res1 -> asyncService.casync2(res1));
    }

    public <T> CompletableFuture<T> toCFuture(ListenableFuture<T> lf) {
        CompletableFuture<T> cf = new CompletableFuture<>();
        lf.addCallback(
                (r) -> {
                    cf.complete(r);
                }, (e) -> {
                    cf.completeExceptionally(e);
                }
        );

        return cf;
    }
}

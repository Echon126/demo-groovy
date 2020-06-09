package com.example.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ThreadHelper {
    private static final Logger logger = LoggerFactory.getLogger(ThreadHelper.class);

    private static final int IOPOOKSIZE = 50;
    public static ThreadPoolExecutor ioPool;

    static {
        ioPool = new ThreadPoolExecutor(IOPOOKSIZE,
                2 * IOPOOKSIZE,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2000),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        ioPool.allowCoreThreadTimeOut(true);
    }


    private static <T> List<T> getTaskResult(int timeout, Stream<CompletableFuture<T>> taskStream) {
        final List<T> result = Collections.synchronizedList(new ArrayList<>());
        CompletableFuture[] allPromises = taskStream.map(t -> t.exceptionally(e -> {
            t.cancel(true);
            logger.error(e.toString());
            return null;
        }).thenAccept(result::add)).toArray(CompletableFuture[]::new);


        try {
            CompletableFuture.allOf(allPromises).get(timeout, TimeUnit.SECONDS);
            for (CompletableFuture allPromise : allPromises) {
                allPromise.cancel(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> List<T> getTaskResult(int timeout, List<Supplier<T>> suppliers) {
        Stream<CompletableFuture<T>> tasks = suppliers.stream()
                .map(x -> CompletableFuture.supplyAsync(x, ioPool));
        List<T> result = getTaskResult(timeout, tasks);
        return result;
    }

}

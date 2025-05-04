package javalanguage.newversions.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompleteableFutures {
    //CompletableFuture is a powerful asynchronous programming API introduced in Java 8.
    // It allows running tasks asynchronously,
    // handling results with callbacks,
    // and combining multiple computations.
    //It is an improved version of Future with non-blocking operations and a richer API for handling async tasks.
    /*
          Future has several limitations:
        ❌ Blocking get() method → Waits until the result is available.
        ❌ No built-in callbacks → Cannot execute logic when a task completes.
        ❌ Cannot combine multiple futures → No way to chain or merge async computations.
        ❌ Cannot handle exceptions gracefully → No built-in error handling.

        CompletableFutures solve all this lowleveldesign.problems.
            * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executerService = Executors.newFixedThreadPool(10);
        var futureInteger = executerService.submit(() -> {
            System.out.println("task " + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
        System.out.println(futureInteger.isDone());
        if (futureInteger.isDone())
            System.out.println("now done: " + futureInteger.get());
        //CompletableFuture
       CompletableFuture<Integer> completableFuture= CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        });

        //✅ thenApply(), thenAccept(), thenCompose(), thenRun() → Non-blocking
//✅ get() and join() → Blocking
        //thenApply: map and transform
        CompletableFuture<Integer> squared=
                completableFuture
                        .thenApply(item->item*item);

        //thenRUn: like a callback
        squared.thenRun(()-> System.out.println("thenRUn: like a callback"));

        //todo: more methods:thenCompose:
        // runAsync, and thenApplyAsync


        //thenAccept: perform side effects such as print, write to a file.
        squared.thenAccept(result-> System.out.print(result));

        Integer extractedValueBlocked=squared.get();
        Integer extractedValueBlockingWithJoin=squared.join();





    }




}

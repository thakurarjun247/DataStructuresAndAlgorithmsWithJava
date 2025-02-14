package javarevision.newjavaversions.java23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadBenchMarking {
    public static void main(String[] args) {
        virtulThreads();
    }

    static void virtulThreads() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            {
                for (int i = 0; i < 1000; i++) {
                    executor.submit(() -> System.out.println(Thread.currentThread().getName()));
                }
            }
        }

        try {
            Thread.sleep(10000);  // Give time for threads to execute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static void traditionalThreads(){

    }

}

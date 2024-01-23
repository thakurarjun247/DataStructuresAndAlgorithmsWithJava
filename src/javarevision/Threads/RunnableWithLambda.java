package javarevision.Threads;

public class RunnableWithLambda {

    public static void main(String[] args) {
        Fib fib = new Fib();
        Thread t0 = new Thread(() -> {
            System.out.println("running " + Thread.currentThread().getName());
            System.out.println("fib 100 " + fib.getNthFib(100));
            ;
        });
        Thread t1 = new Thread(() -> {
            System.out.println("running " + Thread.currentThread().getName());
            System.out.println("fib 50" + fib.getNthFib(50));
            ;
        });
        Thread t2 = new Thread(() -> {
            System.out.println("running " + Thread.currentThread().getName());
            System.out.println("fib 60" + fib.getNthFib(60));
            ;
        });
        Thread t3 = new Thread(() -> {
            System.out.println("running " + Thread.currentThread().getName());
            System.out.println("fib 70" + fib.getNthFib(70));
            ;
        });


        //t0.start();
        t1.start();
        t2.start();
        //t3.start();

    }

}

class Fib {
    public int getNthFib(int n) {
        if (n < 2)
            return n;
        else {
            System.out.println(Thread.currentThread().getName() + " n=" + n);
            return getNthFib(n - 1) + getNthFib(n - 2);

        }

    }
}
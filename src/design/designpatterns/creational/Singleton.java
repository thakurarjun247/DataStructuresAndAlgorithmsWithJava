package design.designpatterns.creational;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton {
    private volatile static Singleton object;

    private Singleton() {
        //keep the constructor private to avoid creating objs
    }

    static Singleton getInstance() {

        synchronized (Singleton.class) {
            if (object == null)
                object = new Singleton();
        }
        return object;
    }

}

class SingletonApp {
    public static void main(String[] args) {
        //Singleton object=new Singleton();
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = Singleton.getInstance();


        System.out.println(object1 == object2);
        System.out.println(object1.equals(object2));
        System.out.println(object1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            System.out.println("starting thread " + (i + 1));
            executorService.submit(() -> {
                System.out.println(Singleton.getInstance());
            });
        }


        executorService.shutdown();
    }
}


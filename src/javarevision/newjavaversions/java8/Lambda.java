package javarevision.newjavaversions.java8;

public class Lambda {

    public static void main(String[] args) {
        //implement runnable
        Thread thread= new Thread(()-> System.out.println("there you go"));
        thread.start();
        //extend thread class
        class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println("extended thread runs");
            }
        }

        MyThread myThread=new MyThread();
        myThread.start();



    }

}

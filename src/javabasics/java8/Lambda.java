package javabasics.java8;

public class Lambda {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t = new Thread(() ->
                System.out.println("running..")

        );
        t.start();

    }

}

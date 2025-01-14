package javarevision.lambda;

import java.util.function.IntUnaryOperator;

public class LambdaDemo {


    public static void main(String[] args) {

        IntUnaryOperator squreIt= (x)-> x*x;
        System.out.println(squreIt.applyAsInt(5));

    }


}

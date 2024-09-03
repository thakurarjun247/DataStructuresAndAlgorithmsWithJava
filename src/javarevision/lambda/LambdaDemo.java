package javarevision.lambda;

import java.util.function.IntUnaryOperator;

public class LambdaDemo {
    public IntUnaryOperator doubleIt = (x) -> x * 2;
    public static void main(String[] args) {

        System.out.println(new LambdaDemo().doubleIt.applyAsInt(5));
    }


}

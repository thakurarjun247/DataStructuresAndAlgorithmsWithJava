package javarevision.newjavaversions.java10;

import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.List;

public class VarDemo {
    //Java introduced the var keyword in Java 10 to enhance
    // code readability and reduce boilerplate code.
    public static void main(String[] args) {
        // Without var:
        String name = "Alice";
        List<Integer> numbers = new ArrayList<>();

        // With var:
        var name1 = "Alice"; // Compiler infers type as String
        System.out.println(name + name1);
        var numbers1 = new ArrayList<>(); // Compiler infers type as List<Integer>

    }

}

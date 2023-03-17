package javabasics.newjavaversions.java17;

public class SealedPermitsDemo {
}
 abstract sealed class Animal permits Dog, Cat {
    // Class definition
}

 final class Dog extends Animal {
    // Class definition
}

  final class Cat extends Animal {
    // Class definition
}
//not allowed
//final  class Bird extends Animal{}

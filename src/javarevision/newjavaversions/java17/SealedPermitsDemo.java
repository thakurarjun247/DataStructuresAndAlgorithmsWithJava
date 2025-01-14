package javarevision.newjavaversions.java17;

public class SealedPermitsDemo {
}

sealed abstract  class Animal permits Dog, Cat {
    // Class definition
}

sealed interface Limited permits Dog{}

final class Dog extends Animal implements Limited {
    // Class definition
}

final class Cat extends Animal {
    // Class definition
}
//not allowed
//final  class ToyBird extends Animal{}

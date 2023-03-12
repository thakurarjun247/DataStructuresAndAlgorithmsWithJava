package javabasics.javanewversions.java17;


/*
* In Java, a record class is a new feature introduced in Java 16 that provides a concise way to declare a class that is solely used to store data. Here are some pros and cons of using record classes in Java:

Pros:

Concise syntax: Record classes allow for a more concise way of declaring classes that are solely used to store data. They require less boilerplate code than regular classes.

Immutability: By default, record classes are immutable. This means that the state of the object cannot be changed once it has been created, which can help prevent bugs and make the code easier to reason about.

Automatic constructor: Record classes automatically generate a constructor that takes all the properties of the class as arguments. This makes it easy to create instances of the class without having to manually define a constructor.

Equals and hashCode methods: Record classes automatically generate equals and hashCode methods based on the properties of the class. This can save a lot of time and effort compared to implementing these methods manually.

Pattern matching: Record classes work seamlessly with pattern matching in Java. This allows for more concise and expressive code when working with record classes.

Cons:

Limited use cases: Record classes are designed for use cases where a class is solely used to store data. They may not be appropriate for more complex classes that contain behavior or other methods.

Limited customization: Record classes provide limited options for customization. For example, the automatic equals and hashCode methods may not be suitable for all use cases, and there is no way to override them.

Compatibility: Record classes were introduced in Java 16, so they may not be available in older versions of Java. This can limit their use in some projects.

Complexity: While record classes themselves are simple, they rely on a number of other Java features, such as sealed classes and pattern matching, which can be more complex to understand and use.
* In Java, record classes are implicitly final. This means that you cannot extend a record class to create a subclass. This is because record classes are designed to be used for data storage, and adding behavior or other properties would go against this design.

By making record classes final, Java ensures that their state cannot be changed once they have been created. This makes record classes a good choice for modeling immutable data structures.

It's worth noting that although record classes are final, you can still implement interfaces in a record class, and you can use inheritance to extend a regular class that implements a record class.
*
* */
//NOTE there is no class keyword here.
public record  RecordClassDemo (String name, Integer age) {
    public static void main(String[] args) {
        Record record; //abstract base class that is parent of all java records
/*        public abstract class Record
                extends Object
This is the common base class of all Java language record classes.*/
        RecordClassDemo r1=new RecordClassDemo("Arjun", 26);
        RecordClassDemo r2=new RecordClassDemo("Arjun", 26);
        RecordClassDemo r3=new RecordClassDemo("Yuvan", 6);
        //only 0 arg or complete arg const.
        //not  partial ones.
       // RecordClassDemo r4=new RecordClassDemo("OnlyName");
        System.out.println(r1==r2); //FALSE
        System.out.println(r1.equals(r2)); //TRUE
        System.out.println(r1.hashCode()== r1.hashCode()); //TRUE

    }
}

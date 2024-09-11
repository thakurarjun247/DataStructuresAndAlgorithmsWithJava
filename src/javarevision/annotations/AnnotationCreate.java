package javarevision.annotations;

<<<<<<< Updated upstream
@interface SGNAnnotation {
    int times() default 5;
}

@SGNAnnotation(times = 10)
public class AnnotationCreate {
    public static void main(String[] args) {
        //print SGN by writing a for loop that iterates for "times" number of times.
=======
public class AnnotationCreate {

    public static void main(String[] args) {
        System.out.println("hi");
>>>>>>> Stashed changes
    }
}

interface @MyAnnotation{
}
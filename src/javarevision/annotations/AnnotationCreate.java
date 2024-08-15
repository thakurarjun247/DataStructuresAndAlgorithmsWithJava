package javarevision.annotations;
@SGNAnnotation(times = 10)
public class AnnotationCreate {
    public static void main(String[] args) {
        //print SGN by writing a for loop that iterates for "times" number of times.
    }
}


    @interface SGNAnnotation{
        int times() default 5;
    }

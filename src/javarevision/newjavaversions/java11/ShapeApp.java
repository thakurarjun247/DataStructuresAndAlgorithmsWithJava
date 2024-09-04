package javarevision.newjavaversions.java11;

sealed interface Shape permits Circle, Rectangle {
    double area();
}

public class ShapeApp {
    public static void main(String[] args) {
        System.out.println("output: " + new Circle((1)).area());
    }
}

//not allowed code below:
//class ABC implements Shape{
//
//    @Override
//    public double area() {
//        return 0;
//    }
//}
final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

package designpatterns.structural.adapter.squarerectangle;
/*
In the Adapter pattern, the adaptee is the existing class or interface that needs to be adapted
to meet the target interface requirements.
The target interface is the interface that the client expects to use to interact with the adaptee.

The adapter is a class that adapts the adaptee to the target interface by translating the calls from the client to the adaptee.

* In the example of using the Adapter pattern to calculate the area of a square using the Rectangle class,
*  the Rectangle class is the adaptee and the RectangleAdapter class is the adapter.

The Square interface represents the target interface that the client expects to use to calculate the area of a square.
 However, the Rectangle class does not implement the Square interface
  and has a different method to calculate the area of a rectangle.
  Therefore, we need to create an adapter class RectangleAdapter that adapts the
   Rectangle class to the Square interface.

The RectangleAdapter contains a reference to the Rectangle object and implements the calculateArea()
method of the Square interface by calling the calculateAreaOfRectangle() method of the Rectangle class.
The Rectangle class is the adaptee because it has the method to calculate the area of a rectangle that we want to
use to calculate the area of a square.

In summary, the Rectangle class is the adaptee and the RectangleAdapter class is the adapter that
 adapts the Rectangle class to the Square interface.



*/
public class Client {
}

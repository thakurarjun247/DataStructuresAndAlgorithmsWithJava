package design.designpatterns.structural.bridge;

/*
* What is the Bridge Pattern?
The Bridge pattern is a structural design pattern that decouples
*  an abstraction from its implementation so that they can vary independently.
* In simpler terms, it separates the interface from the implementation details.4
*  This separation promotes flexibility, reusability, and maintainability in software design.

Why Do We Need It?
Consider a scenario where you have multiple implementations (like different types of TVs)
* and multiple abstractions (like different types of remote controls). Without the Bridge pattern,
*  you'd end up with a combinatorial explosion of classes (e.g., SonyRemoteForSonyTV,
*  PhilipsRemoteForSonyTV, etc.). This is inefficient and hard to maintain.

The Bridge pattern solves this by creating two separate hierarchies: one for abstractions
* (remote controls) and one for implementations (TVs). This allows you to combine different remote
* controls with different TVs independently.
*
How Does it Help with OOP Principles?
Extensibility: The Bridge pattern enhances extensibility by allowing you to add new remote controls or TV types without affecting existing code. You can create new implementations and abstractions independently.
Modularity: It promotes modularity by separating concerns. The abstraction (remote control) focuses on the high-level interface, while the implementation (TV) handles the low-level details.
SOLID Principles:
Open-Closed Principle: The Bridge pattern allows you to extend the system's behavior without modifying existing code. You can add new remote controls or TV types without changing the core classes.
Dependency Inversion: The Bridge pattern decouples the abstraction from the implementation, making the system more flexible and testable.
* */
interface RemoteInterface {
    void turnOn();
    void turnOff();
}

interface TVInterface {
    void turnOn();
    void turnOff();
}

class SonyTV implements TVInterface {
    public void turnOn() {
        System.out.println("Sony TV turned on");
    }

    public void turnOff() {
        System.out.println("Sony TV turned off");
    }
}

class PhilipsTV implements TVInterface {
    public void turnOn() {
        System.out.println("Philips TV turned on");
    }

    public void turnOff() {
        System.out.println("Philips TV turned off");
    }
}
//you can say that the BasicRemote class is bridging the gap between the TVInterface and RemoteInterface
class BasicRemote implements RemoteInterface {
    private TVInterface tvInterface;

    public BasicRemote(TVInterface tvInterface) {
        this.tvInterface = tvInterface;
    }

    public void turnOn() {
        tvInterface.turnOn();
    }

    public void turnOff() {
        tvInterface.turnOff();
    }
}

public class BridgeClient {
    public static void main(String[] args) {
        TVInterface sonyTVInterface = new SonyTV();
        RemoteInterface basicRemoteForSony = new BasicRemote(sonyTVInterface);
        basicRemoteForSony.turnOn();
        basicRemoteForSony.turnOff();

        TVInterface philipsTVInterface = new PhilipsTV();
        RemoteInterface basicRemoteForPhilips = new BasicRemote(philipsTVInterface);
        basicRemoteForPhilips.turnOn();
        basicRemoteForPhilips.turnOff();
    }
}

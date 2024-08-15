package designpatterns.structural.bridge;

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

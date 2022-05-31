package designpatterns.structural.bridge;

public class Client {
    public static void main(String[] args) {
        AbstractTV abstractTV=new SonyTV();
        AbstractRemote abstractRemote=new ConcreteRemote();
        abstractRemote.setChannel(5);
       // abstractRemote.
    }
}

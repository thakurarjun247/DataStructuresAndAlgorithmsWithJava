package designpatterns.structural.bridge;

public class ConcreteRemote extends AbstractRemote {
    private int currentChannel;

    public void nextChannel() {

        setChannel(currentChannel+1);
    }

    public void prevChannel() {

        setChannel(currentChannel-1);
    }
}
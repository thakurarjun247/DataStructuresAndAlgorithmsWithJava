package designpatterns.structural.bridge;

public class SonyTV implements AbstractTV {
    private int channel;
    public void on() {
        System.out.println("sony tv on..");
    }

    public void off() {
        System.out.println("sony tv off..");

    }

    public void tuneChannel(int channel) {
        this.channel=channel;
    }
}

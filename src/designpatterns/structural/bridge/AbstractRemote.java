package designpatterns.structural.bridge;

public abstract class AbstractRemote {
    private AbstractTV abstractTV;

    public void on() {
        abstractTV.on();
    }

    public void off() {
        abstractTV.off();
    }

    public void setChannel(int channel) {
        abstractTV.tuneChannel(channel);
    }
}
package designpatterns.behavioral.chainofresponsibility.dispencerexample;

public class DispenceChain {
    private final Dispencer firstDispencer;

    public DispenceChain() {
        Dispencer dispencer10 = new INR10Dispencer();
        Dispencer dispencer5 = new INR5Dispencer();
        Dispencer dispencer1 = new INR1Dispencer();
        firstDispencer = dispencer10;
        dispencer10.setNextDispencer(dispencer5);
        dispencer5.setNextDispencer(dispencer1);
    }

    public Dispencer getChain() {
        return firstDispencer;
    }
}

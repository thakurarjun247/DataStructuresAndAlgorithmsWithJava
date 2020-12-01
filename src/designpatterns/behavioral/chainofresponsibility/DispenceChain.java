package designpatterns.behavioral.chainofresponsibility;

public class DispenceChain {
    private Dispencer firstDispencer;

    public Dispencer getChain() {
        return firstDispencer;
    }

    public DispenceChain() {
        Dispencer dispencer10=new INR10Dispencer();
        Dispencer dispencer5=new INR5Dispencer();
        Dispencer dispencer1=new INR1Dispencer();

        dispencer10.setNextDispence(dispencer5);
        dispencer5.setNextDispence(dispencer1);

        firstDispencer =dispencer10;
    }
}

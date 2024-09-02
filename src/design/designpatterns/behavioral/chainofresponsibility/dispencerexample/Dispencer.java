package design.designpatterns.behavioral.chainofresponsibility.dispencerexample;
//aka DispenseChain
public interface Dispencer {
//    Dispencer dispencer=null;
    void setNextDispencer(Dispencer nextDispencer);
    void dispense(Currency currency);
}
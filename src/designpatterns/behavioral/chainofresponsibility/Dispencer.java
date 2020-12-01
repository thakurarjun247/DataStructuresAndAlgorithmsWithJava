package designpatterns.behavioral.chainofresponsibility;
//aka DispenseChain
public interface Dispencer {
//    Dispencer dispencer=null;
    void setNextDispence(Dispencer nextDispencer);
    void dispense(Currency currency);
}
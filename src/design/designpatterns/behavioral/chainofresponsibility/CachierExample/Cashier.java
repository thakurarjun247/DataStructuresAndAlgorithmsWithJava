package design.designpatterns.behavioral.chainofresponsibility.CachierExample;

public interface Cashier {
    void process(Request request);
    void delegate(Cashier nextCashier);
}

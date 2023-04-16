package designpatterns.behavioral.chainofresponsibility.CachierExample;

public class DispenseCashier implements Cashier{

    @Override
    public void process(Request request) {
        System.out.println("Processing Dispense...");
    }

    @Override
    public void delegate(Cashier nextCashier) {
        System.out.println("Delegating to next Cashier");
    }
}

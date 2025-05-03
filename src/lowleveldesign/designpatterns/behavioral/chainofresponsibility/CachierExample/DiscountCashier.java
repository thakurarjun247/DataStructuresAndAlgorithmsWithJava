package lowleveldesign.designpatterns.behavioral.chainofresponsibility.CachierExample;

public class DiscountCashier implements Cashier {

    @Override
    public void process(Request request) {
        System.out.println("Processing Discount...");
    }

    @Override
    public void delegate(Cashier nextCashier) {
        System.out.println("Delegating to next Cashier");

    }
}

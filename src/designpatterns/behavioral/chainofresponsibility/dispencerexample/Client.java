package designpatterns.behavioral.chainofresponsibility.dispencerexample;

public class Client {
    public static void main(String[] args) {
        Currency currency = new Currency(29);
        DispenceChain dispenceChain = new DispenceChain();
        dispenceChain.getChain().dispense(currency);
    }
}

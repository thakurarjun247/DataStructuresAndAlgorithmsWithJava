package designpatterns.behavioral.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        Currency currency=new Currency(55);
        DispenceChain dispenceChain=new DispenceChain();
        dispenceChain.getChain().dispense(currency);
    }
}

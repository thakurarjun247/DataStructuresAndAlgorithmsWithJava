package designpatterns.behavioral.chainofresponsibility;

public class INR1Dispencer implements  Dispencer {
    Dispencer nextDispencer;
    @Override
    public void setNextDispence(Dispencer nextDispencer) {
        this.nextDispencer=nextDispencer;
    }

    @Override
    public void dispense(Currency currency) {
        int n=currency.getAmount();
        if(n>0){
            System.out.println("dispence "+n+" notes of INR 1");
           currency.setAmount( currency.getAmount()%1);
        }

    }
}

package designpatterns.behavioral.chainofresponsibility;

public class INR5Dispencer implements  Dispencer {
    Dispencer nextDispencer;
    @Override
    public void setNextDispence(Dispencer nextDispencer) {
        this.nextDispencer=nextDispencer;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()<5)
            this.nextDispencer.dispense(currency);
        int n=currency.getAmount()/5;
        if(n>0){
            System.out.println("dispence "+n+" notes of INR 5");
            currency.setAmount(currency.getAmount()%5);
        }
        if(n>0){
            this.nextDispencer.dispense(currency);
        }

    }
}

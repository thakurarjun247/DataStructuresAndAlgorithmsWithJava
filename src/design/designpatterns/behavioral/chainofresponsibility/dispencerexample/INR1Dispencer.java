package design.designpatterns.behavioral.chainofresponsibility.dispencerexample;

public class INR1Dispencer implements Dispencer {
    Dispencer nextDispencer;

    @Override
    public void setNextDispencer(Dispencer nextDispencer) {
        this.nextDispencer = nextDispencer;
    }

    @Override
    public void dispense(Currency currency) {
        int n = currency.getAmount();
        if (n > 0) {
            System.out.println("dispence " + n + " notes of INR 1");
            currency.setAmount(0);
        }

    }
}

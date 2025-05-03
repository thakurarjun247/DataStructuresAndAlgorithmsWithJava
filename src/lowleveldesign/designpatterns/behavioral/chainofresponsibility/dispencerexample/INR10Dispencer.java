package lowleveldesign.designpatterns.behavioral.chainofresponsibility.dispencerexample;

public class INR10Dispencer implements Dispencer {
    Dispencer nextDispencer;

    @Override
    public void setNextDispencer(Dispencer nextDispencer) {
        this.nextDispencer = nextDispencer;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() < 10)
            this.nextDispencer.dispense(currency);
        int amount = currency.getAmount() / 10;

        if (amount > 0) {
            System.out.println("dispence " + amount + " notes of INR 10");
            currency.setAmount(currency.getAmount() % 10);
        }
        if (amount > 0) {
            this.nextDispencer.dispense(currency);
        }

    }
}

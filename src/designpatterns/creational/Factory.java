package designpatterns.creational;

import java.util.NoSuchElementException;

public class Factory {
}
interface Currency{
    String getSymbol();
}
class ThaiCurrency implements Currency {

    @Override
    public String getSymbol() {
        return "THB";
    }
}

class IndianCurrency implements Currency {
    @Override
    public String getSymbol() {
        return "INR";
    }
}

class CurrencyFactory{
    static Currency getCurrencyForCountry(String country){
        switch (country){
            case "India" : return new IndianCurrency();
            case "Thailand" : return new ThaiCurrency();
            default: throw new NoSuchElementException();
        }
    }
}

class FactoryApp{
    public static void main(String[] args) {
        System.out.println(CurrencyFactory.getCurrencyForCountry("India").getSymbol());
        System.out.println(CurrencyFactory.getCurrencyForCountry("Thailand").getSymbol());
        System.out.println(CurrencyFactory.getCurrencyForCountry("US").getSymbol());

    }
}


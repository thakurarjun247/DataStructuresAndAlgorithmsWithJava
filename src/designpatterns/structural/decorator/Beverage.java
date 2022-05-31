package designpatterns.structural.decorator;

 abstract class Beverage {
    String description;
    String getDescription(){
        return  description;
    }
   public abstract double getCost();
}

class Espresso extends Beverage{
    @Override
    String getDescription() {
        return "Espresso";
    }
    @Override
    public double getCost(){
        return 60;
    }
}

class HouseBlend extends Beverage{
    @Override
    String getDescription() {
        return "HouseBlend";
    }
    @Override
    public double getCost(){
        return 80;
    }
}

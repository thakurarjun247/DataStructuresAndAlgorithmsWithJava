package design.designpatterns.structural.decorator;

abstract class Beverage {
    String description;

    String getDescription() {
        return description;
    }

    public abstract double getCost();
}

class Espresso extends Beverage {
    @Override
    String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 60;
    }
}

class HouseBlend extends Beverage {
    @Override
    String getDescription() {
        return "HouseBlend";
    }

    @Override
    public double getCost() {
        return 80;
    }
}

public abstract class CondimentDecorator extends Beverage {
    abstract String getDescription();
}

class SteamedMilk extends CondimentDecorator {
    //compose plain vanila coffee inside
    Beverage beverage;

    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + " , SteamedMIlk";
    }

    @Override
    public double getCost() {
        //double d=super.cost();
        return 10 + beverage.getCost();
    }
}

class Sugar extends CondimentDecorator {
    //compose plain vanila coffee inside
    Beverage beverage;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + " , Sugar";
    }

    @Override
    public double getCost() {
        //double d=super.cost();
        return 3 + beverage.getCost();
    }
}

class Client {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new SteamedMilk(beverage);
        beverage = new Sugar(beverage);

        System.out.println(beverage.getDescription() + beverage.getCost());
    }
}
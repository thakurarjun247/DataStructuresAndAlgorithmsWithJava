package lowleveldesign.designpatterns.structural.decorator.newexample;

import java.math.BigDecimal;

abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getCost();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public BigDecimal getCost() {
        return BigDecimal.valueOf(60);
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend";
    }

    public BigDecimal getCost() {
        return BigDecimal.valueOf(80);
    }
}

abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
}

class SteamedMilk extends CondimentDecorator {
    public SteamedMilk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    public BigDecimal getCost() {
        return BigDecimal.valueOf(10).add(beverage.getCost());
    }
}

class Sugar extends CondimentDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    public BigDecimal getCost() {
        return BigDecimal.valueOf(3).add(beverage.getCost());
    }
}

class DecoratorClient {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription() + " $" + beverage.getCost());

        beverage = new SteamedMilk(beverage);
        System.out.println(beverage.getDescription() + " $" + beverage.getCost());

        beverage = new Sugar(beverage);

        System.out.println(beverage.getDescription() + " $" + beverage.getCost());
    }
}
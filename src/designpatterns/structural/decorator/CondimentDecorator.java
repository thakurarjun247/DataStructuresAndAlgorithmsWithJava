package designpatterns.structural.decorator;

public abstract class CondimentDecorator  extends Beverage{
    abstract String getDescription() ;
}
class SteamedMilk extends CondimentDecorator{
    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    //compose plain vanila coffee inside
    Beverage beverage;
    @Override
    String getDescription() {
        return beverage.getDescription()+" , SteamedMIlk" ;
    }
    @Override
  public double getCost(){
        //double d=super.cost();
        return 10+ beverage.getCost();
    }
}

class Sugar extends CondimentDecorator{
    //compose plain vanila coffee inside
    Beverage beverage;
    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    String getDescription() {
        return beverage.getDescription()+" , Sugar" ;
    }
    @Override
    public double getCost(){
        //double d=super.cost();
        return 3 + beverage.getCost();
    }
}
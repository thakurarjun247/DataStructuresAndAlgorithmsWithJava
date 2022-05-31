package designpatterns.structural.decorator;

public class Client {
    public static void main(String[] args) {
        Beverage beverage=new HouseBlend();
        beverage=new SteamedMilk(beverage);
        beverage=new Sugar(beverage);

        System.out.println(beverage.getDescription() + beverage.getCost());
    }
}

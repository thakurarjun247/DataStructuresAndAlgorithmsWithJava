package lowleveldesign.solidprinciples.isp.after;

public class AfterISP {
}
class Random{
    public static void main(String[] args) {
        System.out.println("really easily");

    }
}
interface Plant{

}

interface GrowingPlant{
    void grow();
}

interface FruitingPlant{
    void fruiting();
}

interface FloweringPlant{
    void flowering();
}
class Mango implements GrowingPlant, FruitingPlant,FloweringPlant{

    @Override
    public void grow() {

    }

    @Override
    public void fruiting() {

    }

    @Override
    public void flowering() {

    }
}

class Rose implements GrowingPlant,FloweringPlant{

    @Override
    public void grow() {

    }

    @Override
    public void flowering() {

    }
}

class Pineapple implements GrowingPlant, FruitingPlant{

    @Override
    public void grow() {

    }

    @Override
    public void fruiting() {

    }
}


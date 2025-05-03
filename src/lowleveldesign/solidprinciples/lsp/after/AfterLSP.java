package lowleveldesign.solidprinciples.lsp.after;






public class AfterLSP {
    public static void main(String[] args) {
        Eagle eagle= new Eagle();
        Ostrich ostrich= new Ostrich();
        eagle.fly();
        ostrich.walk();


    }
}

interface Bird{}
interface FlyingBird extends Bird{
    void fly();
}

interface WalkingBird extends Bird{
    void walk();
}
class Eagle implements WalkingBird, FlyingBird{

    @Override
    public void fly() {
        System.out.println("eagle flies");
    }

    @Override
    public void walk() {
        System.out.println("ealge walks");
    }
}

class Ostrich implements WalkingBird{

    @Override
    public void walk() {
        System.out.println("ostrich walks");
    }
}
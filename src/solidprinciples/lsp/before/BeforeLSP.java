package solidprinciples.lsp.before;

public class BeforeLSP {
    public static void main(String[] args) {
        Bird eagle=new Eagle();
        Bird ostrich=new Ostrich();
        eagle.fly();
        ostrich.fly();
    }
}
interface Bird{
    void walk();
    void fly();
}
class Eagle implements Bird{

    @Override
    public void walk() {
        System.out.println("ealge walks");
    }

    @Override
    public void fly() {
        System.out.println("eagle flies");
    }
}

class Ostrich implements Bird{

    @Override
    public void walk() {
        System.out.println("ostrich walks");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

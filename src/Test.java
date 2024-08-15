/*
Inputs - 0: s = [ “{“, “[“, “<”, “>”, “]”, “}” ]

        Simple representation of the above input: {[<>]}

        Verify if the given input has matching open/ close brackets.
        Examples:
        Inputs - 1: s = { [ < > ]  ⇒ Invalid
        Inputs - 2: s = { [ < > }  ⇒ Invalid
        Inputs - 3: s = { [ < ] }  ⇒ Invalid
        Inputs - 4: s = { [ < > } ]  ⇒ Invalid (because the order of the brackets are not aligned)
        Inputs - 5: s = { [ < > ] }  ⇒ Valid
        */
import java.util.*;




interface Bird{
    void wings();
}
abstract class FlyingBird implements Bird{
     abstract void fly();
}

class Parrot extends FlyingBird{

    @Override
    public void wings() {
        System.out.println("parrot wings");
    }

    @Override
    void fly() {
        System.out.println("parrot flying");

    }
}
class GreenParrot extends Parrot{
    @Override
    void fly() {
        System.out.println("green parrot flying");

    }
}

class Arith {
    public int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}


public class Test {
    public static void main(String[] args) {
        Arith arith=new
                Arith();
        arith.add(new int[]{2,3});
Parrot gp= new GreenParrot();
Parrot p= new Parrot();
p.fly();
gp.fly();
    }

}


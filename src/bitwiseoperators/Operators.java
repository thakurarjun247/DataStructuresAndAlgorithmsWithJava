package bitwiseoperators;

public class Operators {
    public static void main(String[] args) {
        //Initial values
        int a = 5; // 0101
        int b = 7;//0111

        // & is bitwise AND
        //1&1=1, 1&0=0, 0&0=0
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // | is bitwise OR
        // 1|1=1, 1|0=1, 0|0=0
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor ^
        // when both the bit same value will be 0 else it will be 1
        // 1^1= 0;  0^0=0; 1^0=1;
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise Negation
        // ~0101=1010
        // Java will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a);

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);

        ////////////////////SHIFT OPERATORS///////////////////////
        a = 5;
        b = -10;

        // left shift operator
        // x<<y means
        // 1. convert x to binary number
        // 2. shift all the bits of x to left by 'y' places
        //e.g.
        //5<<2=20
        // 0000 0101<<2 =0001 0100 which is 20
        System.out.println("a<<2 = " + (a << 2));

        // right shift operator
        // 0000 0101 >> 2 =0000 0001(1)
        /*
        Shifts the bits of the number to the right and fills 0
         on voids left as a result. The leftmost bit depends on the
          sign of initial number. Similar effect as of dividing the
           number with some power of two.
        */

        //todo: decode this line similar to 5/(2^2)
        System.out.println("b>>2 = " + (b >> 2));

        // unsigned right shift operator
        System.out.println("b>>>2 = " + (b >>> 2));
    }
}

package datastructures.arraystring.app;

import datastructures.arraystring.fun.Basic;

public class BasicApp {
    public static void main(String[] args) {

        Basic basic = new Basic();
        String string = "you may be asked to write two version to solve this coding exercise ";
        // replace method can replace a char as well as set of chars
        String newS = string.replace('a', '@');

        // string is immutable hence one and the same after replace
        System.out.println(string);
        System.out.println(newS);
        System.out.println(string.replaceAll("a", "@"));

        System.out.println("replace and replaceAll ACT AS SAME,");
        String n = "0123456789abc";


        // substring includes starting index but omits end index
        System.out.println(n.substring(5, 8));
        System.out.println(n.charAt(5));
        System.out.println(string);

        // remove a char from a given string iteratively and recursively
        System.out.println(basic.remove(string, 'y'));

        System.out.println("is 9 a prime number " + basic.isPrime(9));

    }
}

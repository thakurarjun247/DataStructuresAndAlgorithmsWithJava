package javarevision.arrays;

import java.util.Arrays;

public class MustKnowJavaMethods {
    public static void main(String args[]) {
        String string = "string";
        char[] array = {'a', 'r', 'r', 'a', 'y'};
        int index = 0;
        int beginIndex = 0;
        int excludingEndIndex = 5;
        char character = 'c';

        //String basics
        string.length();
        //no size() method for string
        string.charAt(index);
        string.substring(beginIndex, excludingEndIndex);
        string.indexOf(character);
        string.isEmpty();
        //NPE when isEmpty called on null string
        String s1="";
        String s2=new String("");
        System.out.print(s1.isEmpty()+""+s2.isEmpty());

        //ArrayBasics
        int length = array.length;  //final variable and not a method


        //String <----> Array

        char[] charArray=string.toCharArray();
        System.out.println(array.toString());
        System.out.println(Arrays.toString(array));;

        //Declare array
        boolean[] a = new boolean[256];


    }
}

package javaspecific;

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
        string.charAt(index);
        string.substring(beginIndex, excludingEndIndex);
        string.indexOf(character);

        //ArrayBasics
        int length = array.length;  //final variable and not a method


        //String <----> Array
        string.toCharArray();
        Arrays.toString(array);


    }
}

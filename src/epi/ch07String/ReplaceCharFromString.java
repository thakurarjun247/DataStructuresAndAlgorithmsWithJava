package epi.ch07String;

import util.Util;

public class ReplaceCharFromString {
    //replace 'a' with 'dd' and remove 'b'
    public static void main(String[] args) {
        char[] a="abcb".toCharArray();
        for (int i = 0; i < replace(a).length; i++)
            System.out.println(a[i]);
    }

    static char[] replace(char[] a) {
        int writeIndex = 0;
        int acoun = 0;
        for (int i = 0; i < a.length; i++) {


            if (a[i] != 'b') {//overwrite

                if (a[i] == 'a')
                    acoun++;


                a[writeIndex] = a[i];
                writeIndex++;
            }
        }
        return a;
    }
}

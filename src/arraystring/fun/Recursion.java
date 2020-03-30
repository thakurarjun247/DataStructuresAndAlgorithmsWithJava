package arraystring.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion {

    public void displayChoice() {
        System.out.println();
        System.out.println("=======================Recursion Operations======================");
        System.out.println("-1: choice menu");
        System.out.println("1: reverse Array ");
        System.out.println("2: reverse Array [new]");
        System.out.println("3: reverse Array Iteratively");
        System.out.println("4: [deprecated] reverse String ");
        System.out.println("5: factorial");
        System.out.println("6: remove A Character From String");
        System.out.println("7:  [new] reverse String reverseStringRecursive");
        System.out.println("8: nth element of fibo series");
        System.out.println("9: print fibo series till n items");
        System.out.println("10: print all permutations of a String");
        System.out.println("11: check if a string contains duplicate characters");
        System.out.println("12: is One String Permutation Of Another");
        System.out.println("13: compress a strings");
        System.out.println("14: check if one string is rotation of another");
        System.out.println("15: rotate a n*n matrix");
        System.out.println("16: single digit sum of a number");
        System.out.println("=================================================================");
        System.out.println();

    }

    public char[] reverseArrayIteratively(char[] array) {
        //time and space complexities O(n), O(1)
        if (array.length == 0 || array.length == 1)
            return array;
        char temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public char[] reverseArray(char[] array, int i) {
        char[] empty = new char[0];

        if (array.length < 1) {
            System.out.println("you entered empty string");
            return empty;

        }
        //time and space complexities O(n), O(1)
        // swap first and last element of array using temp var
        // here i=0
        char temp;
        temp = array[i];
        array[i] = array[array.length - 1 - i];
        array[array.length - 1 - i] = temp;
        i++;

        if (i >= array.length - 1 - i) {

            return array;
        } else {
            reverseArray(array, i);
            return array;
        }

    }
    public int[] reverseArraySimple(int a[]){
   if(a.length==0) return a;
   else return  reverseArraySimpleRec(a, 0, a.length-1);

       // printArray(reverseArraySimpleRec(a,0, a.length-1));
       // printArray(reverseArraySimpleRec(b,0, b.length-1));
       // printArray(reverseArraySimpleRec(c,0, c.length-1));

    }
    int[] reverseArraySimpleRec(int[] a, int start, int end){
        if(end>=start) return a;
        int temp=a[end];
        a[end]=a[start];
        a[start]=temp;
        return reverseArraySimpleRec(a,start+1, end-1);
    }
    public void printArray(int[] a){
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
    }

    public char[] reverseArrayNew(char[] array, int i) {

        if (i >= array.length / 2) { // this if can be written as below as well if(i>=array.length-1-i)
            return array;
        }
        char temp = array[i];
        array[i] = array[array.length - 1 - i];
        array[array.length - 1 - i] = temp;
        return reverseArrayNew(array, ++i);

    }

    private void reveseArrayIterativeWhileLoop() {

    }

     public String reverseStringIteratively(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }

    public String reverseStringRecursive(String str) {
        //time complexity O(n)
        //space complexity O(n*n)
        //in the worst case you will have to store n substrings, each of length 0 to n
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseStringRecursive(str.substring(0, str.length() - 1));
    }

    public int factorialRecursive(int number) {
        //time and space complexities O(n), O(n) not sure
        if (number < 2) {
            return 1;
        } else {
            return number * factorialRecursive(number - 1);
        }
    }

    public int factorialIterative(int number) {
        //time complexity O(n)
        //space complexity O(1)
        if (number <= 2)
            return number;
        int factorial = number;
        while (number > 2) {
            number--;
            factorial *= number;
        }
        return factorial;
    }

    public String removeACharacterFromString(String s, char c) {
        int index = s.indexOf(c);
        if (index < 0)
            return s;
        else {
            return removeACharacterFromString(s.substring(0, index) + s.substring(index + 1, s.length()), c);

        }
    }
    public int nthNumberInFiboSeries(int number) {
        if (number < 1) {
            throw new IndexOutOfBoundsException("");
        }
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return nthNumberInFiboSeries(number - 1) + nthNumberInFiboSeries(number - 2);
        }
    }

    public void printFiboSeriesUptoNElements(int n) {
        if (n < 1) {
            System.out.println("error in input");
            return;
        }
        int prev = 1;
        int current = 1;
        int next;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                System.out.print(1 + " ");
            } else {
                next = prev + current;
                System.out.print(next + " ");
                prev = current;
                current = next;
            }
        }
    }

    public List<String> getPermutationOfString(String s) {
        List<String> results = new ArrayList<>();
        if (s != null) {
            if (s.length() == 1) {
                results.add(s);
            } else {
                int lastIndex = s.length() - 1;
                String lastChar = s.substring(lastIndex);
                List<String> sub = getPermutationOfString(s.substring(0, s.length() - 1));
                for (int i = 0; i < sub.size(); i++) {
                    String first = sub.get(i);
                    for (int j = 0; j < first.length(); j++) {
                        // the following if else is to handle corner cases;
                        if (j == 0) {
                            results.add(lastChar + first.substring(j));
                        }
                        if (j == (first.length() - 1)) {
                            results.add(first + lastChar);
                        } else {
                            results.add(first.substring(j, j + 1) + lastChar + first.substring(j + 1));
                        }

                    }
                }
            }
        }

        return results;
    }

    public boolean containsDuplicateChars(String s) {

        if (s.length() > 256)
            return true;
        boolean[] array = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (array[value]) {
                return true;
            } else
                array[value] = true;
        }
        return false;
    }

    public boolean isOneStringPermutationOfAnother(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256]; // Assumption
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {

            int c = (int) t.charAt(i);

            if (--letters[c] < 0) {

                return false;

            }

        }

        return true;
    }

    public String compressAString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char c = s.charAt(0);
        StringBuilder ouput = new StringBuilder();
        int count = 1;
        // boolean atLeastOneCharRepeating = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;

            } else {
                ouput.append(c).append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        ouput.append(c).append(count);
        if (ouput.length() < s.length()) {
            return ouput.toString();
        } else {
            return s;
        }
    }

    public boolean isRotation(String first, String second) {
        return (first + first).contains(second);
    }

    public void rotateMatrix(int n) {
        int[][] a = new int[n][n];
        /*
		 * 1 2 3 4 5 6 7 8 9
		 */
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("input at location " + i + "x" + j);
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.print("before rotation");
        printMatrix(a, n);

        System.out.println("");
        System.out.print("after rotation");
        printMatrix(a, n);
        // 13 11 33 13 31 33 11 31
        // 02 00 22 02 20 22 00 20
        // 00 02

    }

    private void printMatrix(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }

    public int singleSumOfDigits(int n) {
        int sum = 0;
        int lastDigit = 0;
        while (n / 10 > 0) {
            lastDigit = n % 10;
            sum += lastDigit;
            n = n / 10;

        }
        sum += lastDigit;
        return (sum < 10 && sum > -10) ? sum : singleSumOfDigits(sum);
    }


}

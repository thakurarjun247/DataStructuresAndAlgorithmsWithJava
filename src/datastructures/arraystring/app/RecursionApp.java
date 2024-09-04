package datastructures.arraystring.app;

import datastructures.arraystring.fun.Recursion;
import util.ArrayUtil;

import java.util.List;
import java.util.Scanner;

public class RecursionApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        Recursion recursion = new Recursion();
        String string = "015";

        char[] array = string.toCharArray();
        for (int i = 0; i < 50; i++) {
            if (i == 0) {
                recursion.displayChoice();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    recursion.displayChoice();
                    break;

                case 1:
                    int[] a ={};
                    int[] b ={1,2,3,4};
                    int[] c ={1,2,3,4,5};
                    recursion.printArray(recursion.reverseArraySimple(a));
                    recursion.printArray(recursion.reverseArraySimple(b));
                    recursion.printArray(recursion.reverseArraySimple(c));
                    System.out.println(recursion.reverseArray(array, 0));
                    break;
                case 2:
                    ArrayUtil.printArray(array);
                    System.out.println(recursion.reverseArrayNew(array, 0));
                    break;
                case 3:
                    ArrayUtil.printArray(array);
                    System.out.println(recursion.reverseArrayIteratively(array));
                    break;
                case 4:
                    System.out.println("deprecated, use option/case 7 instead");
                    break;
                case 5:
                    System.out.println("calculate factorial : enter a number ");
                    int number = scanner.nextInt();
                    System.out.println("factorial by recursion: " + recursion.factorialRecursive(number));
                    System.out.println("factorial by iteration: " + recursion.factorialIterative(number));
                    break;
                case 6:
                    System.out.println(recursion.removeACharacterFromString("something something", 'm'));
                    break;
                case 7:
                    System.out.println("enter a string");
                    String toBeReversed = scanner.next();
                    System.out.println("recursively new " + recursion.reverseStringRecursive(toBeReversed));
                    System.out.println("iteratively " + recursion.reverseStringIteratively(toBeReversed));
                    break;
                case 8:
                    System.out.println("printing nth element of fibo series, enter n");
                    System.out.println(recursion.nthNumberInFiboSeries(scanner.nextInt()));
                    break;
                case 9:
                    System.out.println("printing fibo series with n elements, enter n");
                    recursion.printFiboSeriesUptoNElements(scanner.nextInt());
                    break;
                case 10:
                    System.out.println("enter a string");
                    String s = scanner.next();
                    List<String> list = recursion.getPermutationOfString(s);
                    list.forEach(item -> System.out.println(item));
                    break;
                case 11:
                    System.out.println("enter a string");
                    System.out.println(recursion.containsDuplicateChars(scanner.next()));
                    break;

                case 12:
                    System.out.println("enter two strings");
                    System.out.println(recursion.isOneStringPermutationOfAnother(scanner.next(), scanner.next()));
                    break;

                case 13:
                    System.out.println("input a string");
                    System.out.println(recursion.compressAString(scanner.next()));
                    break;

                case 14:
                    System.out.println("enter two strings");
                    System.out.println(recursion.isRotation(scanner.next(), scanner.next()));
                    break;
                case 15:
                    System.out.println("input n");
                    recursion.rotateMatrix(scanner.nextInt());
                    break;
                case 16:
                    System.out.println("input number");
                    System.out.println(recursion.singleSumOfDigits(scanner.nextInt()));
                    break;

                default:
                    break;
            }
        }

        scanner.close();

    }
}

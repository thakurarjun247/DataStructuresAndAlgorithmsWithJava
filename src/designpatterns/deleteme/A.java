package designpatterns.deleteme;

import java.util.Scanner;

public class A {
    public static String helperRemoveShortestPalindrome(String s) {
        for (int i = 2; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                return s.substring(i);
            }
        }
        return s;
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    static int[] removePalindromePrefix(int n, String s){

        int operations = 0;
        while (s.length() > 1 && helperRemoveShortestPalindrome(s) != s) {
            s = helperRemoveShortestPalindrome(s);
            operations++;
        }
        int[] output= new int[]{operations, s.length()};
        return output;
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        String s = sc.next();

        int[] ans = removePalindromePrefix(n, s);

        for(int i=0; i < ans.length; i++){

            System.out.print(ans[i] + " ");

        }

    }
}

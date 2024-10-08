package leetcodeandgrind75.leetcode.dynamicprogramming;
//https://leetcode.com/problems/palindromic-substrings/description/

public class AllPalinSubstring {
    int ans = 0;

    public static void main(String[] args) {
        System.out.println(new AllPalinSubstring().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            expandEven(s, i);
            expandOdd(s, i);
        }

        return ans;
    }

    void expandEven(String s, int i) {
        int low = i;
        int high = i + 1;
        while (low >= 0 && high < s.length() && s.charAt(low--) == s.charAt(high++))
            ans++;
    }

    void expandOdd(String s, int i) {
        int low = i;
        int high = i;
        while (low >= 0 && high < s.length() && s.charAt(low--) == s.charAt(high++))
            ans++;
    }
}




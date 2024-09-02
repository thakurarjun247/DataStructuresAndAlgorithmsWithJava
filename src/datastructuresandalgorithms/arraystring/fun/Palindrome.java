package datastructuresandalgorithms.arraystring.fun;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(getPalindromicSubStrings("3211123"));

    }

    public static Set<String> getPalindromicSubStrings(final String s) {
        Set<String> set = new HashSet<String>();
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            // odd length string
            if (s.length() % 2 != 0) {
                for (int j = 0; j + i < length && i - j >= 0; j++) {
                    if (s.charAt(i + j) != s.charAt(i - j)) {
                        break;
                    }
                    set.add(s.substring(i - j, i + j + 1));
                }
            }
            // even length string
            else {
                for (int j = 0; j + i + 1 < length && i - j >= 0; j++) {
                    if (s.charAt(i + j + 1) != s.charAt(i - j)) {
                        break;
                    }
                    set.add(s.substring(i - j, i + j + 1 + 1));
                }
            }
        }
        return set;
    }

}

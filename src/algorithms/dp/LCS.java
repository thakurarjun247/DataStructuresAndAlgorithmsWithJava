package algorithms.dp;

import java.util.Map;
import java.util.HashMap;

public class LCS {
    public static void main(String[] s) {
        Map<Strings, String> memo = new HashMap<>();
        System.out.println(lcs("abcdef", "aceoiuyf", ""));
        System.out.println(lcs("abcbdab", "bdcaba", ""));
        System.out.println(lcsMemo("abcdef", "aceoiuyf", "", memo));
        System.out.println(lcsMemo("abcbdab", "bdcaba", "", memo));
        Strings s1 = new Strings("abcd", "abcd");
        Strings s3 = new Strings("xabcd", "yabcd");
        Strings s2 = new Strings("abcd", "abcd");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }

    public static String lcs(String s1, String s2, String prevMatched) {

        if (s1.isEmpty() || s2.isEmpty())
            return prevMatched;
        if (s1.charAt(0) == s2.charAt(0))
            return lcs(s1.substring(1), s2.substring(1), prevMatched + s1.charAt(0));
        //compute for two possibility and return the max
        String first = lcs(s1.substring(1), s2, prevMatched);
        String second = lcs(s1, s2.substring(1), prevMatched);
        if (first.length() > second.length())
            return first;
        else return second;
    }

    public static String lcs1(String s1, String s2, String prevMatched) {

        if (s1.isEmpty() || s2.isEmpty())
            return prevMatched;
        if (s1.charAt(0) == s2.charAt(0))
            return lcs1(s1.substring(1), s2.substring(1), prevMatched + s1.charAt(0));
            //compute for two possibility and return the max
        else {
            String first = lcs1(s1.substring(1), s2, prevMatched);
            String second = lcs1(s1, s2.substring(1), prevMatched);
            if (first.length() > second.length())
                return first;
            else
                return second;
        }
    }

    public static String lcsMemo(String s1, String s2, String prevMatched, Map<Strings, String> memo) {
        Strings these = new Strings(s1, s2);
        if (memo.containsKey(these)) {
            return memo.get(these);
        }
        if (s1.isEmpty() || s2.isEmpty())
            return prevMatched;
        if (s1.charAt(0) == s2.charAt(0))
            return lcsMemo(s1.substring(1), s2.substring(1), prevMatched + s1.charAt(0), memo);
        //compute for two possibility and return the max
        String first = lcsMemo(s1.substring(1), s2, prevMatched, memo);
        String second = lcsMemo(s1, s2.substring(1), prevMatched, memo);
        if (first.length() > second.length()) {
            memo.put(new Strings(s1, s2), first);
            return first;
        } else {
            memo.put(new Strings(s1, s2), second);
            return second;
        }
    }


}

class Strings {
    String s1;
    String s2;

    public Strings() {
    }

    public Strings(String s1, String s2) {
        this.s2 = s2;
        this.s1 = s1;
    }

    @Override
    public int hashCode() {
        return (this.s1 + this.s2).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Strings strings = (Strings) obj;
        return this.s1.equals(strings.s1) && this.s2.equals(strings.s2);
    }
}

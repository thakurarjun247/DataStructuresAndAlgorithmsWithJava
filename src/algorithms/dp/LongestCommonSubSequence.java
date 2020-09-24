package algorithms.dp;

import java.util.*;

class LongestCommonSubSequence {


    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, new HashMap<String, Integer>());
    }

    public int longestCommonSubsequence(String text1, String text2, Map<String, Integer> memo) {
        String key = text1 + text2;
        if (memo.containsKey(key)) return memo.get(key);
        if (text1.isEmpty() || text2.isEmpty()) return 0;
        if (text1.equals(text2)) return text1.length();
        if (text1.charAt(0) == text2.charAt(0))
            memo.put(key, 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1), memo));
        else {
            memo.put(key, Math.max(longestCommonSubsequence(text1.substring(1), text2, memo), longestCommonSubsequence(text1, text2.substring(1), memo)));
        }
        return memo.get(key);
    }
}
package datastructuresandalgorithms.problemsfrombooks.clrs.dp;
//string edit distance

import java.util.Arrays;


//The Levenshtein distance is a string metric for measuring
// the difference between two sequences. Informally, the Levenshtein
// distance between two words is the minimum number of single-character
// edits (i.e. insertions, deletions, or substitutions) required to change
// one word into the other
public class LevenshteinDistance {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("Carthorse", "Orchestra"));

        System.out.println(levenshteinDistance("axcdn", "axvdm"));
    }

    private static int levenshteinDistance(String s1, String s2) {
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        int[][] memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return levenshteinDistance(s1, i1, s2, i2, memo);

    }

    private static int levenshteinDistance(String s1, int i1, String s2, int i2, int[][] memo) {
        if (i1 < 0) return i2 + 1;
        if (i2 < 0) return i1 + 1;

        if (memo[i1][i2] != -1) return memo[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2))
            memo[i1][i2] = levenshteinDistance(s1, i1 - 1, s2, i2 - 1, memo);
        else {
            int deleteLastCharFromS1 = levenshteinDistance(s1, i1 - 1, s2, i2, memo);
            int deleteLastFromCharS2 = levenshteinDistance(s1, i1, s2, i2 - 1, memo);
            int deleteLastCharFromBothS1S2 = levenshteinDistance(s1, i1 - 1, s2, i2 - 1, memo);
            memo[i1][i2] = 1 + Math.min(deleteLastCharFromBothS1S2, Math.min(deleteLastCharFromS1, deleteLastFromCharS2));
        }
        return memo[i1][i2];
    }
}

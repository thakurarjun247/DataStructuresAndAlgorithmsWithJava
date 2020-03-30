package leetcode;

public class LC1048 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = {"a", "b", "ba", "bca", "bda", "bdca"};
        int ans = s.longestStrChain(a);
        System.out.println(ans);
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        //assume array sorted by length;
        int ans = 0;
        int start = 0;
        int next = 1;
        while (next < words.length) {
            if (isPred(words[start], words[next])) {
                ans++;
                start = next;

            }
            next = next + 1;
        }
        return ans;

    }

    boolean isPred(String s1, String s2) {
        if (!((s1.length() + 1) == s2.length()))
            return false;
        if (s1 == "ba") {
            int x = 0;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s2.indexOf(s1.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }

}
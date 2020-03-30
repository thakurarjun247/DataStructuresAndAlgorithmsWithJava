package leetcode;

public class LC5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbcbda"));
    }
    public static String longestPalindrome(String s) {
         Ends max=new Ends();
         max.length=0;
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            Ends len1 = expandAroundCenter(s, i, i);
            Ends len2 = expandAroundCenter(s, i, i + 1);
            Ends len = null;
            if(len1.length>len2.length)
                len=len1;
            else
                len=len2;

            if (len.length>max.length) {
              max=len;
            }
        }
        return s.substring(max.l, max.r+1);
    }

    private static Ends  expandAroundCenter(String s, int l, int r) {

        //expand in both directions
        while (l > 0 && r < s.length()-1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //return length
        return new Ends(l,r);
    }
    static class Ends{
        int l;
        int r;
        int length;
        public Ends(){}
        public Ends(int l, int r) {
            this.l = l;
            this.r = r;
            this.length = r - l - 1;
        }
    }
}
package clrs;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        StringBuilder ans=new StringBuilder("");
        int len=0;
        if(s==null )
            return "";
        if(s.length()<2)
            return s;

        for(int i=0;i<s.length()-1;i++){
            String s2 =expand(s, i, i);
            String s1=expand(s, i, i+1);
            String longerString=s1.length()>s2.length()?s1:s2;
            if(longerString.length()>ans.toString().length()){
                ans=new StringBuilder(longerString);
            }
        }
        return ans.toString();
    }

    public static String expand(String s, int start, int end){
        int count=0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;

        }
        if(start<0)
            start=0;
        if(end>s.length())
            end=s.length();
        return s.substring(start,end+1);
    }
}
package mission_mahakal.dp.leetcode;
//Leetcoded:
//https://leetcode.com/problems/longest-palindromic-substring/submissions/
public class LongestPalindromicSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));;

    }
    public static String longestPalindrome(String s) {
        StringBuilder builder= new StringBuilder();
       for (int i = 0; i < s.length(); i++) {
           String temp= expandAroundOne(s, i);
           if(temp.length()>builder.length())
           {
               builder.setLength(0);
               builder.append(temp);
           }
        }

      for (int i = 0; i < s.length(); i++) {
            String temp= expandAroundTwo(s, i, i+1);
            if(temp.length()>builder.length())
            {
                builder.setLength(0);
                builder.append(temp);
            }
        }
        return builder.toString();
    }

    public static String expandAroundOne(String String, int index){
        return expand(String,index-1,index+1,String.valueOf(String.charAt(index)));
    }
    public static String expandAroundTwo(String string, int s, int e){
        return expand(string,s,e,"");
    }

    public static String expand(String str, int s, int e, String init  ){
        StringBuilder ans= new StringBuilder(init);
        StringBuilder temp= new StringBuilder(init);

        while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)){

                String chr=String.valueOf(str.charAt(s));
                temp=new StringBuilder(chr+temp.toString()+chr);
                if(temp.length()>ans.length()){
                    ans=temp;


                s--;
                e++;
            }
        }
        return ans.toString();
    }
}

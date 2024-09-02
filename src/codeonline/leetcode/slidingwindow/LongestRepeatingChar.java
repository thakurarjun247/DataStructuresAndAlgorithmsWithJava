package codeonline.leetcode.slidingwindow;
import java.util.*;
public class LongestRepeatingChar {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
    public static int characterReplacement(String s, int k) {{

        if(s.length()==1)
            return 1;

        int ans=1;
        char maxFreqChar=s.charAt(0);

        Map<Character, Integer> freq= new HashMap<>();
        freq.put(s.charAt(0), 1);
        //l and r are the left and right bounds of the window
        int r=0;
        for(int l=0; l<s.length() && r<s.length();l++){
            //shrink the window from the left
            if(l!=0)
            {
                int count=freq.getOrDefault(s.charAt(l-1), 0);
                freq.put(s.charAt(l-1), Math.max(count-1, 0));
            }
            //expand the window towards the right
            while(r<s.length() && r-l+1-freq.getOrDefault(maxFreqChar,0)<=k)
            {
                char c=s.charAt(r);

                int count=freq.getOrDefault(c,0);
                freq.put(c, count+1);
                if(freq.getOrDefault(c,0)>=freq.getOrDefault(maxFreqChar, 0))
                    maxFreqChar=c;

                r++;
                ans=Math.max(ans, Math.min(r, s.length()-1)-l+1);
            }

            //Be greedy, take the max

        }
        return ans;
    }
}}
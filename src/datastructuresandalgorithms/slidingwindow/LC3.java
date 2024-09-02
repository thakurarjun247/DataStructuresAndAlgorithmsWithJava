package datastructuresandalgorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LC3 {
    public static void main(String[] args) {
        System.out.println( new LC3().lengthOfLongestSubstring("123858858"));
    }
    public int lengthOfLongestSubstring(String s) {
       // if(s.length()<=1) return s.length();
        int max=0;
        int left=0;

        Set<Character> window= new HashSet<>();
        //window.add(s.charAt(0));
        for(int right=0;right<s.length();right++){

            while(window.contains(s.charAt(right)) && left<right){
                window.remove(s.charAt(left));
                left++;

            }
            window.add(s.charAt(right));
            max=Math.max(max, window.size());


        }
        return max;
    }


}
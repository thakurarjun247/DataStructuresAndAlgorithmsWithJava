package datastructuresandalgorithms.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public static void main(String[] args) {
        System.out.println(new LC76().minWindow("abcdeca", "ac"));
    }
    boolean isSub(Map<Character, Integer> source, Map<Character, Integer> target){
        for(Character targetKey: target.keySet())
              if(!source.containsKey(targetKey) || source.get(targetKey)<target.get(targetKey))
                       return false;

       return  true;
    }
    public String minWindow(String s, String t) {
        int left=0;
        StringBuilder builder= new StringBuilder();
        Map<Character, Integer> target= new HashMap<>();
        Map<Character, Integer> source= new HashMap<>();

        //fill target
        for(int i = 0;i<t.length();i++){
            char c=t.charAt(i);
            if(!target.containsKey(c))
                target.put(c, 1);
            else
                target.put(c, target.get(c)+1);
        }

        //slide window
        for(int right=0;right<s.length();right++){
            char rightChar=s.charAt(right);
            char leftChar=s.charAt(left);
            //logic to shrink
            while( left<right && (source.get(leftChar) > target.getOrDefault(leftChar, 0))){
                if(!target.containsKey(source.get(leftChar) ))

                    left++;
                else {
                    source.put(leftChar, source.get(leftChar) - 1);
                    left++;
                }

            }
            if(isSub(source,target)){
                if(builder.length()==0 || right-left+1 < builder.length() ){
                    builder=new StringBuilder("");
                    builder.append(s.substring(left, right+1));

                }

            }
            //expand on right;
            if(!source.containsKey(rightChar))
                source.put(rightChar, 1);
            else
                source.put(rightChar, source.get(rightChar)+1);

        }

        return builder.toString();

    }
}

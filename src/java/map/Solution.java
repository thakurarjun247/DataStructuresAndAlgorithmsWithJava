package java.map;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        System.out.println(frequencySort("abcdddgb"));
    }
    public static String frequencySort(String s) {
        if(s==null || s.length()<3)
            return s;
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(map.containsKey(c)){
int oldVal=map.get(c);
                map.put(c,oldVal +1);
            }
            else
                map.put(c, 1);

        }
        StringBuilder builder=new StringBuilder();

        map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new))

       // Read more: https://javarevisited.blogspot.com/2017/09/java-8-sorting-hashmap-by-values-in.html#ixzz6VFqFiqE7
       // map
                .forEach((k,v)->{
                    for(int i=0;i<v;i++){
                        builder.append(k.toString());
                    }
                });
        return builder.toString();

    }
}

package grind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC150 {
    public static void main(String[] args) {
        System.out.println(LC150.isValidSimple("()[]{}"));
    }
    public static boolean isValidSimple(String s) {
       // 8:59
        Map<Character, Character> map =  new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack= new Stack();

        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
           if(!map.containsKey(c))
               stack.push(c);
           else {
               if(stack.isEmpty() || stack.peek()!=map.get(c))
                   return false;
               stack.pop();
           }


        }
        return stack.isEmpty();
    }


}

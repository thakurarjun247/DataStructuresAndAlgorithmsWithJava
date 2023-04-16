/*
Inputs - 0: s = [ “{“, “[“, “<”, “>”, “]”, “}” ]

        Simple representation of the above input: {[<>]}

        Verify if the given input has matching open/ close brackets.
        Examples:
        Inputs - 1: s = { [ < > ]  ⇒ Invalid
        Inputs - 2: s = { [ < > }  ⇒ Invalid
        Inputs - 3: s = { [ < ] }  ⇒ Invalid
        Inputs - 4: s = { [ < > } ]  ⇒ Invalid (because the order of the brackets are not aligned)
        Inputs - 5: s = { [ < > ] }  ⇒ Valid
        */

import java.util.Stack;

public class Test {

    //“{“, “[“, “<”, “>”, “]”, “}”
    public static void main(String[] args) {
        System.out.println(isValid(new String[]{"]"}));
        System.out.println(isValid(new String[]{ "[", "<", ">", "]" }));
        System.out.println(isValid(new String[]{"["}));

    }

       static boolean isValid(String[] a){
            Stack<String> stack= new Stack<>();
            for(String item: a){
                switch (item){
                    case ">" :
                       if(!stack.isEmpty() && stack.peek()=="<")
                           stack.pop();
                       else
                           return  false;
                       break;
                       case "]":
                        if(!stack.isEmpty() && stack.peek()=="[")
                            stack.pop();
                        else
                            return false;
                        break;
                    case "}":
                        if(!stack.isEmpty() && stack.peek()=="{")
                            stack.pop();
                        else
                            return  false;
                        break;
                    default:
                        stack.push(item);


                }
            }
            if(stack.empty()) return true;
            else
            return false;
        }

        }


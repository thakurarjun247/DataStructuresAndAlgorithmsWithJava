package epi.ch16recursion;

import util.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {
    public static void main(String[] args) {
        p("ab").forEach(System.out::println);
    }
    static List<String> p(String  s)
    {
        List<String> ans=new ArrayList<String>();
        //base case
        if(s.length()<=1)
        {
            ans.add(s);
            return ans;
        }
        //for each item, swap it with first
        //i.e. bring each item at 0th position by swapping it with 0th item
        //calculate the perm of the remaining and append with 0th.
        for(int i=1;i<s.length();i++){
            String charToBeReplacedByFirstChar=((Character) s.charAt(i)).toString();
            String z= i==(s.length()-1) ? "" : (s.substring(i+1));

           List<String> perms=p( s.substring(0,i)+ ((Character)s.charAt(0)).toString()+z);
           perms.forEach(string -> ans.add(charToBeReplacedByFirstChar+string));
        }
        return ans;
    }
}

package algorithms.ch16recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public static void main(String[] args) {
        newPerm("a").forEach(System.out::println);
        newPerm("ab").forEach(System.out::println);
        newPerm("abc").forEach(System.out::println);
        //p("ab").forEach(System.out::println);
    }

    static List<String> newPerm(String s) {
        return newPerm(s, new ArrayList<String>());
    }

    static List<String> newPerm(String s, List<String> list) {
        if (s == null || s.isEmpty()) return list;
        if (s.length() == 1)
            list.add(s);

        else {
            //keep the first char aside and generate perms of last n-1 chars
            //insert the first char in all the places in all the perms
            newPerm(s.substring(1), new ArrayList<String>())
                    .forEach(
                            permsForNMinusOneChars ->
                            {
                                for (int i = 0; i <= permsForNMinusOneChars.length(); i++) {
                                    list.add(permsForNMinusOneChars.substring(0, i) + s.charAt(0) + permsForNMinusOneChars.substring(i));
                                }
                            }
                    );
        }
        return list;

    }

    static List<String> p(String s) {
        List<String> ans = new ArrayList<String>();
        //base case
        if (s.length() <= 1) {
            ans.add(s);
            return ans;
        }
        //for each item, swap it with first
        //i.e. bring each item at 0th position by swapping it with 0th item
        //calculate the perm of the remaining and append with 0th.
        for (int i = 1; i < s.length(); i++) {
            String charToBeReplacedByFirstChar = ((Character) s.charAt(i)).toString();
            String z = i == (s.length() - 1) ? "" : (s.substring(i + 1));

            List<String> perms = p(s.substring(0, i) + ((Character) s.charAt(0)) + z);
            perms.forEach(string -> ans.add(charToBeReplacedByFirstChar + string));
        }
        return ans;
    }
}

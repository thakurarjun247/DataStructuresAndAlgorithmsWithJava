package problemsfrombooks.epi.ch06arrays;

import java.util.*;

public class EnumerateNPrimes {
    public static void main(String[] args) {
        System.out.println(f(100));
    }

    static List<Integer> f(int n) {
        //initially all false
        boolean b[] = new boolean[n + 1];
        //set all true
        for (int i = 2; i <= n; i++)
            b[i] = true;
        for (int itemUnderExam = 2; itemUnderExam <= n; itemUnderExam++) {
            boolean isCurrentItemPrime = b[itemUnderExam];
            if (!isCurrentItemPrime) {
                //this was set by other step as soon as a number is found
                //to be prime it's multiple were set as nonprime
                //do nothing
            } else {
                //we initialzied it to be a prime, try deviding it and see if it becomes nonprime
                int devidingByIndex = 2;
                while (devidingByIndex <= Math.sqrt(itemUnderExam)) {
                    if (b[devidingByIndex] == true && itemUnderExam % devidingByIndex == 0 && itemUnderExam!=devidingByIndex) {
                        b[itemUnderExam] = false;
                        int x=2;
                        while (x*itemUnderExam<n){
                            if(b[x])
                            x++;
                        }
                    }

                    devidingByIndex++;
                }
                //could'n't devide
                //set it as prime (no need it's prime by defalut) and set it's multiples as non prime
                for (int i = 2; i <= n; i++) {
                   if(i % itemUnderExam%itemUnderExam==0)
                    b[i] = false;
                }

            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (b[i])
                list.add(i);
        return list;

    }
}

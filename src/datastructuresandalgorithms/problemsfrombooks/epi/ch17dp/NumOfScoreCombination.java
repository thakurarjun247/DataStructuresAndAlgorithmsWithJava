package datastructuresandalgorithms.problemsfrombooks.epi.ch17dp;

public class NumOfScoreCombination {
    public static void main(String[] args) {

    }
    static int f(int amount, int[] coins ){
        if(amount<=0) return 0;
        switch (amount)
        {
            case 3: return 1;
            case 2: return 1;
            case 7: return 2;
        }
        f(amount-2, coins);
        return 0;
    }
}

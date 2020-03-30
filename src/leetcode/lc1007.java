package leetcode;

public class lc1007 {
    public static void main(String[] args) {
        Solution1007 s=new Solution1007();
        int[] A={2,1,2,4,2,2};
int[] B={5,2,6,2,3,2};
        int ans=s.minDominoRotations(A, B);
        System.out.println(ans);
    }
}/*
class Solution1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] countA=new int[7];
        int[] countB=new int[7];
        int[] total=new int[7];
        for(int i=0;i<A.length;i++){
            countA[A[i]]++;
        }
        for(int i=0;i<B.length;i++){
            countB[B[i]]++;
        }

        for(int i=1;i<=6;i++){
            total[i]=countA[i]+countB[i];
        }
        //find max
        int maxA=0;
        int maxAIndex=0;
        int maxBIndex=0;
        for(int i=1;i<=6;i++){
            if(countA[i]>maxA){
                maxA=countA[i];
                maxAIndex=i;
            }

        }
        int maxB=0;
        for(int i=1;i<=6;i++){
            if(countB[i]>maxB)
            {
                maxB=countB[i];
                maxBIndex=i;
            }
        }
        int[] compA=new int[A.length];
        int[] compB=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]!=maxBIndex)
        }

        if(maxA>=maxB){
            if((countA[maxAIndex]+countB[maxAIndex])>=A.length)
                return A.length-maxA;
        }

        if(maxB>maxA){
            if((countB[maxBIndex]+countA[maxBIndex])==A.length)
                return A.length-maxB;
        }
        return -1;
    }
}*/
class Solution1007 {
    /*
    Return min number of rotations
    if one could make all elements in A or B equal to x.
    Else return -1.
    */
    public int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x) return -1;
                // A[i] != x and B[i] == x
            else if (A[i] != x) rotations_a++;
                // A[i] == x and B[i] != x
            else if (B[i] != x) rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || A[0] == B[0]) return rotations;
            // If one could make all elements in A or B equal to B[0]
        else return check(B[0], B, A, n);
    }
}
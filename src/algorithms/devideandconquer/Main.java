package algorithms.devideandconquer;


//buy sale stocks n times
public class Main {
    public static void main(String[] args) {
        Kadanse k = new Kadanse();
        MaxContinuousSubArrayDevideConquer m = new MaxContinuousSubArrayDevideConquer();
        int[] a = {4, -1, 2, 4, -3, 0, 3, -2, 9};
        int[] a1 = {-4, -5, 8, 4, -1, 2, 4, -3, 0, 3, -2, 9};
        int[] arr={-4, -5 };
        int[] a3={1,-4,1,1,1 -5,99 };
        int[] empty={};
        MaxContinuousSubArrayDevideConquer.Bound b = m.findMaxSubArray(0, a1.length - 1, a1);
        System.out.println(b.sum+b.leftMost+b.rightMost);
        //System.out.println(b.sum);
       // System.out.println(k.kadanseRecursive(a1, 0, Integer.MIN_VALUE, Integer.MIN_VALUE));
       // System.out.println(k.kadanseRecursive(a, 0, Integer.MIN_VALUE, Integer.MIN_VALUE));
      // System.out.println(k.kadanseIterative(a1, Integer.MIN_VALUE, Integer.MIN_VALUE));
       // System.out.println(k.kadanseRecursive(a, 0, Integer.MIN_VALUE, Integer.MIN_VALUE));
        // System.out.println(k.kadanseRecursive(a, 0, Integer.MIN_VALUE, Integer.MIN_VALUE));
      //  System.out.println(k.kadanseIterative(empty, Integer.MIN_VALUE, Integer.MIN_VALUE));
     //   System.out.println(k.kadanseIterative(a1, Integer.MIN_VALUE, Integer.MIN_VALUE));
     //   System.out.println(k.kadanseIterative(a, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}

class Kadanse {
    public int kadanseRecursive(int a[], int index, int localMax, int globalMax) {
        if (index >= a.length)
            return globalMax;
         localMax = Math.max(0, localMax) + a[index];
        globalMax = Math.max(localMax, globalMax);
        return kadanseRecursive(a, ++index, localMax, globalMax);
    }

    public int kadanseIterative(int[] a, int localMax, int globalMax) {
        //int newLocalMax=localMax;
        for (int i = 0; i < a.length; i++) {
            //here 0 means we are discarding previous results
            //so that we discard the Integer.MIN_VALUE as well as
            //we discard any dips we have had so far
            //Math.max(0, localMax) will take or leave existing sum
            localMax= Math.max(localMax, 0)+a[i];
        //    System.out.println(localMax+" "+globalMax);
            globalMax=Math.max(localMax, globalMax);
        }
     //   System.out.println("finally gmax "+globalMax);
        return globalMax;
    }
}

class MaxContinuousSubArrayDevideConquer {

    Bound findMaxCrossingSubarray(int low, int mid, int high, int[] a) {
        int leftSumOld = Integer.MIN_VALUE;//holds sum of left half
        int leftMost = mid; //the leftmost index included in summation
        int leftSumNew = 0; //leftOld sum + latest value on the left.
        int rightMost = mid;
        int rightSumOld = Integer.MIN_VALUE;

        int rightSumNew = 0;

        for (int leftCounter = mid - 1; leftCounter >= low; leftCounter--) {
            leftSumNew += a[leftCounter];
            if (leftSumNew >= leftSumOld) {
                leftSumOld = leftSumNew;
                leftMost = leftCounter;
            }
        }
        for (int rightCounter = mid + 1; rightCounter <= high; rightCounter++) {
            rightSumNew += a[rightCounter];
            if (rightSumNew >= rightSumOld) {
                rightSumOld = rightSumNew;
                rightMost = rightCounter;
            }
        }
        int sumTotoal = leftSumOld + a[mid] + rightSumOld;
        //  System.out.println(leftMost + " " + rightMost + " " + sumTotoal);
        return new Bound(leftMost, rightMost, sumTotoal);
    }

    Bound findMaxSubArray(int low, int high, int[] a) {
        // if (a.length == 0) return new Bound();

        if (low == high) return new Bound(0, 0, a[0]);
        int mid = (low + high) / 2;
        Bound leftBound = findMaxSubArray(low, mid, a);
        Bound rightBound = findMaxSubArray(mid + 1, high, a);
        Bound crossBound = findMaxCrossingSubarray(low, mid, high, a);
        if (leftBound.sum > rightBound.sum && leftBound.sum > crossBound.sum)
            return leftBound;
        if (rightBound.sum > leftBound.sum && rightBound.sum > crossBound.sum)
            return rightBound;
        return crossBound;
    }

    public class Bound implements Comparable {
        int leftMost;
        int rightMost;
        int sum;

        @Override
        public String toString() {
            return leftMost + " " + rightMost + " " + sum;
        }

        Bound() {
        }

        Bound(int leftMost, int rightMost, int sum) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            this.sum = sum;
        }

        @Override
        public int compareTo(Object b) {
            Bound bound = (Bound) b;
            return this.sum - bound.sum;
        }
    }

}

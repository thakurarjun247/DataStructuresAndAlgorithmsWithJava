package grindlc.grind75;

public class LC53 {
    public static void main(String[] args) {
        System.out.println(LC53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] a) {
        int startOver=a[0];
        int statusQuo=a[0];
        int max=a[0];

        for(int i=1; i<a.length;i++){
            startOver=a[i];
            statusQuo=statusQuo+a[i];
            statusQuo=Math.max(statusQuo,startOver);
            max=max(max, startOver, statusQuo);
        }
        return max;

    }
     static int max(int a, int b, int c)
    {
        return Math.max(a, Math.max(b,c));
    }
}

package leetcode;

public class LC42 {
    public static void main(String[] args) {
        Solution299 solution299=new Solution299();
        System.out.println(solution299.getHint("1807",                "7810"));
        SolutionLC42 l = new SolutionLC42();
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = l.trap(a);
        System.out.println(ans);
    }
}

class SolutionLC42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            leftMax[i]=maxLeft;
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i + 1]);
            rightMax[i]=maxRight;
        }
        int min[] = new int[n];
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = Math.min(leftMax[i], rightMax[i]);
            int thisans = 0;
            if (height[i] < min[i])
                thisans = min[i];
            else
                thisans = 0;
            ans[i] = thisans;
        }
        int qty = 0;
        for (int i = 0; i < n; i++) {
            qty += ans[i];
        }
        return qty;
    }
}

class Solution299 {
    public String getHint(String secret, String guess) {
        if(secret==null ||  guess==null )
            return null;
        int n=secret.length();
        if( n==0)
            return "";
        int A=0;
        int B=0;
        for(int i=0;i<n;i++){
            if(secret.charAt(i)==guess.charAt(i))
                A++;
            if(guess.indexOf(secret.charAt(i)) != -1)
                B++;
        }
        return A+"A"+B+"B";
    }
}
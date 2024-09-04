package algorithms.devideandconquer;

public class _4_1_MaxSubArrayDnC {


    public static void main(String[] arr){
        int a[]={13, -3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(maxSubArray(a, 0, a.length-1));
    }
    static Indices maxSubArray(int[] a, int low, int high){
        if(low==high)
            return new Indices(low, high, a[low]);
        int mid= (low+high)/2;
        Indices left=maxSubArray(a, low,mid );
        Indices right=maxSubArray(a, mid+1, high);
        Indices cross=crossSum(a, low, mid, high);
        Indices maxLeftRight=left.sum>right.sum ? left : right;
        Indices max=cross.sum>maxLeftRight.sum ? cross : maxLeftRight;
        return max;
    }

    static Indices crossSum(int[] a, int low, int mid, int high){
        //int l=mid+1;

        int maxRight=mid;
        int rightSum=-5000;
        int sum=0;
       // int i;
        for(int i=mid+1;i<=high;i++){
            sum=sum+a[i];
            if(sum>rightSum){
                rightSum=sum;
                maxRight=i;
            }
        }

        int maxLeft=mid-1;
        int leftSum=-5000;
        sum=0;

        for(int j=mid;j>=low;j--){
            sum=sum+a[j];
            if(sum>leftSum){

                leftSum=sum;
                maxLeft=j;
            }
        }


        return new Indices(maxLeft, maxRight, rightSum+leftSum);
    }
}
class Indices{
    int l;
    int h;
    int sum;
    @Override
    public String toString(){
        return "["+l+", "+h+"]  "+sum;
    }
    public Indices(int l, int h, int sum) {
        this.l = l;
        this.h = h;
        this.sum = sum;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

public class DontCommit {
    public static void main(String[] args) {
       String s="Tadasana, tiryaka tadasana, katichakrasana, mandukasana, satkasana, Yogamudrasana, ardhmatsendrasana, pavanmuktasana, naukasana, setubandhasana, Uttanpadasana";
        for (String s1 : s.toLowerCase().split(",")) {
            System.out.println(s1);
        }
    }
    static int fibo(int n){
        if(n==0 || n==1) return n;
        int a=0;
        int b=1;
       int sum=a+b;
        for(int i=2;i<=n;i++){

            a=b;
            b=sum;
            sum=a+b;
        }
        return sum;

    }
}

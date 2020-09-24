package problemsfrombooks.epi.ch16recursion;


//see this https://www.youtube.com/watch?v=fkMVJimEHJY
//and see newToH code below
/*
Time Complexity :
        Let the time required for n disks is T(n) .
        There are 2 recursive call for n-1 disks and one constant time operation to move a disk
        from ‘from’ peg to ‘to’ peg . Let it be k1.
        Therefore,
        T(n) = 2 T(n-1) + k1
        T(0) = k2 , a constant.
        T(1) = 2 k2 + k1
        T(2) = 4 k2 + 2k1 + k1
        T(2) = 8 k2 + 4k1 + 2k1 + k1
        Coefficient of k1 =2n
        Coefficient of k2 =2n
        -1
        Time complexity is O(2n
        ) or O(an
        ) where a is a constant greater than 1.
        So it has exponential time complexity. For single increase in problem size the time
        required is double the previous one. This is computationally very expensive. Most of the
        recursive programs takes exponential time that is why it is very hard to write them
        iteratively .
        Space Complexity:
        Space for parameter for each call is independent of n i.e., constant. Let it be k .
        When we do the 2nd recursive call 1st recursive call is over . So, we can reuse the space of
        1st call for 2nd call . Hence ,
        T(n) = T(n-1) + k
        T(0) = k
        T(1) = 2k
        T(2) = 3k
        T(3) = 4k
        So the space complexity is O(n).
        Here time complexity is exponential but space complexity is linear . Often there is a trade
        off between time and space complexity .*/

public class TowerOfHanoi {

    static void newToH(int n, String a, String b, String c){
        //switch (n){
            if(n==1)
                System.out.println("move disk from "+a+" to "+c+" using "+b);

           else /*if(n==2)*/ {
                newToH(n - 1, a, c, b);
                newToH(1, a, b, c);
                newToH(n - 1, b, a, c);
            }
           /*else{

            }*/


        //}

    }

    //todo: correct solution but if you still don't get it, try renaming source destination to a, b, c etc.
    static void towerOfHanoi(int n, char source, char destination, char intermediary)
    {
        if (n == 1)
        {
            System.out.println("(1)  " +  source + " => " + destination);
            return;
        }
        //make intermediary your destination, i.e. send to temp buffer tower, n-1 disks to be sent
        towerOfHanoi(n-1, source, intermediary, destination);
        //n-1 are on intermediary so send the only remaining to the final destination
        //the following can be rewritten as:
        System.out.println("("+n+")  " +  source + " => " + destination);
        //towerOfHanoi(n,source, destination, intermediary);
        towerOfHanoi(n-1, intermediary, destination, source);
    }

    //  Driver method
    public static void main(String args[])
    {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
        System.out.println("____________________");
        newToH(n, "A", "B", "C");
    }
}
package epi.ch16recursion;

public class TowerOfHanoi {
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
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
    }
}
package datastructures.graph.disjointset.implementation;

//theory in CLRS page 561, chapter 21
public class OldImplementationOfTreeBasedDisjointSet {
    private int[] representative;
    private int[] rank;

    public static void main(String[] args) {
        OldImplementationOfTreeBasedDisjointSet disjointSet = new OldImplementationOfTreeBasedDisjointSet();
        disjointSet.makeSet(10);
        disjointSet.union(2, 5); // Merge sets containing 2 and 5
        disjointSet.union(2, 1); // Merge sets containing 2 and 5
        disjointSet.union(1, 8); // Merge sets containing 1 and 8
        disjointSet.union(9, 3);
        disjointSet.union(0, 1);
        if (disjointSet.findSet(1) == disjointSet.findSet(8)) { // Check if 2 and 8 are in the same set
            System.out.println(" connected");
        } else System.out.println(" not connected.");

    }

    public void makeSet(int n) {
        representative = new int[n];
        // Initially, all elements are in their own set with rank 0

        rank = new int[n];
        for (int i = 0; i < n; i++) {
            representative[i] = i;

        }
    }

    //finds representative of the set containing this item

    public int findSet(int item) {
        if (representative[item] != item) {
            representative[item] = findSet(representative[item]); // Path compression
        }
        return representative[item];
    }

    public void union(int x, int y) {
        int representativeOfX = findSet(x);
        int representativeOfY = findSet(y);

        if (representativeOfX != representativeOfY) {
            if (rank[representativeOfX] < rank[representativeOfY]) {
                representative[representativeOfX] = representativeOfY;
            } else if (rank[representativeOfX] > rank[representativeOfY]) {
                representative[representativeOfY] = representativeOfX;
            } else {
                representative[representativeOfY] = representativeOfX;
                rank[representativeOfX]++; // Increase rank if ranks are equal
            }
        }
    }
}

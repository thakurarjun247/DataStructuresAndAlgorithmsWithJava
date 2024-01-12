package datastructures.disjointset;

public class FindUnionInDisjointSets {
    public static void main(String[] args) {
        FindUnionInDisjointSets ds= new FindUnionInDisjointSets(10);
        ds.union(2, 5); // Merge sets containing 2 and 5
        ds.union(2, 1); // Merge sets containing 2 and 5
        ds.union(1, 8); // Merge sets containing 1 and 8
        ds.union(9,3);
        ds.union(0,1);
        if (ds.find(1) == ds.find(8)) { // Check if 2 and 8 are in the same set
            System.out.println(" connected");
        }
        else System.out.println(" not connected.");

    }
    private int[] parent;
    private int[] rank;

    public FindUnionInDisjointSets(int n) {
        parent = new int[n];
         // Initially, all elements are in their own set with rank 0

        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;

        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int parentOfX = find(x);
        int parentOfY = find(y);

        if (parentOfX != parentOfY) {
            if (rank[parentOfX] < rank[parentOfY]) {
                parent[parentOfX] = parentOfY;
            } else if (rank[parentOfX] > rank[parentOfY]) {
                parent[parentOfY] = parentOfX;
            } else {
                parent[parentOfY] = parentOfX;
                rank[parentOfX]++; // Increase rank if ranks are equal
            }
        }
    }
}

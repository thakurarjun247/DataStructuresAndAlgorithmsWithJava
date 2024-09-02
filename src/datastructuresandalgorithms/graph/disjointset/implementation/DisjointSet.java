package datastructuresandalgorithms.graph.disjointset.implementation;

//theory in CLRS page 561, chapter 21
 class DisjointSetApplication {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(11);
        //make sets with individual items.
        for (int i = 0; i < 11; i++) {
            disjointSet.makeSet(i);
        }
        disjointSet.union(2, 5); // Merge sets containing 2 and 5
        disjointSet.union(2, 1);
        disjointSet.union(1, 8); // Merge sets containing 1 and 8
        disjointSet.union(9, 3);

        disjointSet.areComponentsConnected(2, 8);
        disjointSet.areComponentsConnected(9, 3);
        disjointSet.areComponentsConnected(2, 3);
        disjointSet.union(12, 3);

    }

}


public class DisjointSet {

    int[] representative;
    int[] size; //size of set that contains a given item

    public DisjointSet(int numberOfItemsInSet) {

        representative = new int[numberOfItemsInSet];
        for(int i=0;i<representative.length;i++)
            representative[i]=i;
        size = new int[numberOfItemsInSet];
    }

    public void makeSet(int item) {

        representative[item] = item;
        size[item] = 1;
    }

    public int find(int item) {
        if (item == representative[item])
            return item;
        else
            return find(representative[item]);
    }



    public void union(int a, int b) {

        if (Math.min(a, b) < 0 || Math.max(a, b) >= representative.length) {
            System.out.println("error: can't unionize the item, beyond the index of our tree/datastructures.array");
            System.out.println("Error: Items must be within the range 0 to " + (representative.length - 1));

            return;
        }
        //call the parents of each
        a = find(a);
        b = find(b);
        //if items belong to the same disjoint set (same parents, part of the same family) do nothing
        if (a == b)
            return;

        int sizeAfterMerge = size[a] + size[b];

        //update the size only for the representative of bigger set
        // Attach the smaller tree under the larger tree
        if (size[a] > size[b]) {
            representative[b] = a;
            size[a] = sizeAfterMerge;
        } else {
            representative[a] = b;
            size[b] = sizeAfterMerge;
        }

    }

    public boolean areComponentsConnected(int a, int b) {
        return find(a) == find(b);
    }
}

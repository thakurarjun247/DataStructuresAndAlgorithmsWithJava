package datastructures.disjointset.leetcode;

public class CheckIfGraphAValidTree {
    int[] parent;
    int[] size;
    public static void main(String[] args) {
        // Test case 1: Valid tree
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        CheckIfGraphAValidTree obj1 = new CheckIfGraphAValidTree();
        System.out.println(obj1.isGraphAValidTree(n1, edges1));

        // Test case 2: Invalid tree (cycle)
        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println(obj1.isGraphAValidTree(n2, edges2));

        // Test case 3: Invalid tree (disconnected)
        int n3 = 5;
        int[][] edges3 = {{0, 1}, {2, 3}};
        System.out.println(obj1.isGraphAValidTree(n3, edges3));

        // Test case 4: Single node
        int n4 = 1;
        int[][] edges4 = {};
        System.out.println(obj1.isGraphAValidTree(n4, edges4));

        // Test case 5: Empty graph
        int n5 = 0;
        int[][] edges5 = {};
        System.out.println(obj1.isGraphAValidTree(n5, edges5));
    }


    void init(int n, int[][] edges) {
        if (n < 1 || edges.length < 1)
            System.out.print("Vertexless/Edgeless graph: is a tree? ");
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }
      boolean isGraphAValidTree(int n, int[][] edges) {
        init(n,edges);
         for(int[] edge: edges){
             //cycle detected?
             if(areTwoVerticesAlreadyConnected(edge[0],edge[1]))
                 return false;
             else union(edge[0],edge[1]);
         }
         //even after all the connections if any of the two nodes are
          //disconnected, not having the same parents
          //its just a graph not a tree.
          for(int i=0;i<n-1;i++){
              if(find(i)!=find(i+1))
                  return false;
          }
         return true;


    }

     boolean areTwoVerticesAlreadyConnected(int a, int b){
        return find(a)==find(b);
    }
      int find(int v){
        if(v==parent[v])
            return v;
        else
            return find(parent[v]);
    }

     boolean union(int a, int b){
        a=find(a);
        b=find(b);
        if(a==b) return false;
        int newSize=size[a]+size[b];
        if(size[a]>size[b])
        {
            parent[b]=a;
            size[a]=newSize;
        }
        else{
            parent[a]=b;
            size[b]=newSize;
        }
        return true;
    }
}
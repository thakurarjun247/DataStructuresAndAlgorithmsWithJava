package codeonline.grind75;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC310 {
    public static void main(String[] args) {
        System.out.println(new LC310().findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list= new ArrayList<>();
        int[] degree= new int[n];
        for(int[] e:edges){
            degree[e[0]]++;
            degree[e[1]]++;
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>(
                (b,a) -> b[1]-a[1]
        );
        for(int i=0;i<n;i++){
            pq.add(new int[]{i, degree[i]});
        }
        while(pq.size()>2)
            pq.poll();

        if(pq.size()==1)
        {
            int[] node=pq.poll();
            list.add(node[0]);
            return list;
        }
        while(!pq.isEmpty())
        {
            int[] node1=pq.poll();
            int[] node2=pq.poll();
            if(node1[1]==node2[1])
            {
                list.add(node1[0]);
                list.add(node2[0]);
                return list;
            }
            if(node1[1]>node2[1])
            {

                list.add(node1[0]);
                return list;
            }
            if(node1[1]<node2[1])
            {

                list.add(node2[0]);
                return list;
            }

            return list;
        }

        return list;
    }


}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

package codeonline.leetcode.graphs;


import java.util.*;
public  class BFS{}

//Java BFS in weighted in not weighted graph or matrix

//Also see my submission to
//    https://leetcode.com/problems/shortest-path-to-get-food/description/
//test

class Solution {
    public static void main(String[] args) {
        int[][] a={{1,2,0}, {0,1,0}, {2,4,1}};
        //find shortest Path from top left to bottom right cell
        System.out.println(new Solution().shortestPathBFSInNonWeightedGraph( 1,3));
        System.out.println(new Solution().shortestPathBFSInWeightedGraph( a));
    }

    int shortestPathBFSInNonWeightedGraph(
            int R, int C){// from 0,0 to R-1, C-1
        int ans=Integer.MAX_VALUE;
        boolean[][] v=new boolean[R][C];
        if(R==0 || C==0) return -1;
        if(R==1 && C==1) return 0;

        Queue<int[]> queue =  new LinkedList<>();
        queue.add(new int[]{0,0,0});
        while(!queue.isEmpty()){
            int[] cell= queue.remove();
            int r=cell[0];
            int c=cell[1];
            int dist=cell[2];
            if(r>=0 && r<R && c>=0 && c<C && !v[r][c]){
                if(r== R-1 && c == C-1){
                    ans= Math.min( ans, cell[2] );
                }
                queue.add(new int[]{r+1,c,dist+1});
                queue.add(new int[]{r,c+1,dist+1});
            }

        }
        return ans;
    }

    int shortestPathBFSInWeightedGraph(int[][] a
    ){// from 0,0 to R-1, C-1
        int R=a.length;
        int C=a[0].length;
        int ans=Integer.MAX_VALUE;
        boolean[][] v=new boolean[R][C];
        if(R==0 || C==0) return -1;
        if(R==1 && C==1) return 0;

        Queue<int[]> queue =  new LinkedList<>();
        queue.add(new int[]{0,0,a[0][0]});
        while(!queue.isEmpty()){
            int[] cell= queue.remove();
            int r=cell[0];
            int c=cell[1];
            int dist=cell[2];
            if(r>=0 && r<R && c>=0 && c<C && !v[r][c]){
                if(r== R-1 && c == C-1){
                    ans= Math.min( ans, cell[2] );
                }

                if(r<R-1)
                    queue.add(new int[]{r+1,c,dist+a[r+1][c]});
                if(c<C-1)
                    queue.add(new int[]{r,c+1,dist+a[r][c+1]});

            }

        }
        return ans;
    }

}
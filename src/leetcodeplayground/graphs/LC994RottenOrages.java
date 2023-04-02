package leetcodeplayground.graphs;
import java.util.*;
public class LC994RottenOrages {
    public static void main(String[] args) {
        LC994RottenOrages object= new LC994RottenOrages();
        int[][] a={ {2,1,1},
                    {1,1,1},
                    {0,1,2}};

        System.out.println(object.orangesRotting(a));
    }
    int R,C, fresh;
    Queue<int[]> q;
    public int orangesRotting(int[][] a) {
        if(a==null || a.length==0)
            return 0;
        R=a.length;

        C=a[0].length;
        int minute=0;
        int rotten=0;
        fresh=0;
        q= new LinkedList<>();
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(a[r][c]==2){
                    rotten++;
                    q.add(new int[]{r,c});

                }
                if(a[r][c]==1)
                    fresh++;
            }
        }

        // if(fresh==0 || rotten==0)
        // return 0;


        while(!q.isEmpty() && fresh!=0){
            minute++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] item=q.poll();
                int r=item[0];
                int  c=item[1];
                bfs(r-1,c, a,q);
                bfs(r+1, c, a, q);
                bfs(r,c+1, a, q);
                bfs(r, c-1, a, q);
            }

        }
        if(fresh>0) return -1;
        else
            return minute;
    }
    void bfs(int r, int c,int[][] a, Queue<int[]> q){
        if(r>=0 && c>=0 && r<R && c<C && a[r][c]==1)
        { a[r][c]=2;
            fresh--;
            q.add(new int[]{r,c});}
    }

}
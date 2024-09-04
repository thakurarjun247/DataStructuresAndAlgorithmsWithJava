package leetcodeandgrind75.leetcode.greedy;
import java.util.*;
public class Freq  {
    public static void main(String[] args) {
       // System.out.println(new Freq().reorganizeString("aab"));;
        System.out.println(new Freq().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    public String reorganizeString(String s) {

        StringBuilder builder= new StringBuilder();
        int[] f= new int[26];
        for(char c:s.toCharArray()){
            f[c-'a']++;
        }

        for(int freq:f)
            if(freq>(s.length()/2+1))
                return "";
        Queue<CharFre> q=new PriorityQueue<>((x,y)->y.f-x.f);
        for(int i=0;i<26;i++)
        {   if(f[i]>0)
            q.add(new CharFre((char) (i+'a'), f[i]));
        }
        while(q.size()>=2){
            CharFre one=q.poll();
            char x=one.c;

            one.f=one.f-1;
            CharFre two=q.poll();

            char y=two.c;
            two.f=two.f-1;
            if(one.f>0)
            q.add(one);
            if(two.f>0)
            q.add(two);
            builder.append(x);
            builder.append(y);

        }
        if(q.size()==1 && (q.peek().f>1 || builder.toString().charAt(builder.length()-1)==q.peek().c))
        return "";
        return builder.toString();
    }

    class CharFre{
        char c;
        int f;
        CharFre(){}
        CharFre(char c, int f){
            this.c=c;
            this.f=f;
        }


    }





        public int leastInterval(char[] tasks, int n) {
            int[] counter = new int[26];
            int max = 0;
            int maxCount = 0;
            for(char task : tasks) {
                counter[task - 'A']++;
                if(max == counter[task - 'A']) {
                    maxCount++;
                }
                else if(max < counter[task - 'A']) {
                    max = counter[task - 'A'];
                    maxCount = 1;
                }
            }

            int partCount = max - 1;
            int partLength = n - (maxCount - 1);
            int emptySlots = partCount * partLength;
            int availableTasks = tasks.length - max * maxCount;
            int idles = Math.max(0, emptySlots - availableTasks);

            return tasks.length + idles;
        }

}
// aba 3/2+1
//ababa
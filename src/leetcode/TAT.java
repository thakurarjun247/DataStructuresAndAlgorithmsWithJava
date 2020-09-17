package leetcode;

import java.util.*;

class TAT {
    public static void main(String[] args) {
        TAT t = new TAT();
        String[] s = {"0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:9", "0:end:12"};
        int[] a = t.exclusiveTime(3, Arrays.asList(s));
        System.out.println(Arrays.toString(a));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] extraTat = new int[n];
        Stack<Fun> stack = new Stack<>();
        int[] a = new int[n];
        //int tat=0;
        for (String log : logs) {
            int x = log.indexOf(':');
            int y = log.lastIndexOf(':');
            boolean isStart = log.substring(x + 1, y).equals("start");
            if (isStart) {
                stack.push(
                        new Fun(
                                Integer.parseInt(log.substring(0, x)),
                                Integer.parseInt(log.substring(y + 1))
                        )
                );
            } else {
                Fun end = new Fun(
                        Integer.parseInt(log.substring(0, x)),
                        Integer.parseInt(log.substring(y + 1))
                );
                Fun start = stack.pop();
                int thisTat = end.time - start.time + 1 + extraTat[start.id];
                for (Fun f : stack) {
                    f.time += thisTat;
                }
                a[start.id] = thisTat;
                //tat=tat+thisTat;
            }
        }
        return a;
    }

    class Fun {
        int id;
        int time;

        Fun() {
        }

        Fun(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public String toString() {
            return id + "-> start time: " + time;
        }
    }
}
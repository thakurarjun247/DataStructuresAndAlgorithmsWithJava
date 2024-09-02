package datastructuresandalgorithms.problemsfrombooks.epi.ch18greedy;

import java.util.*;

public class IntervalCovering {
    public static void main(String[] args) {
        List<Interval> list = Arrays.asList(
                new Interval(0, 3),
                new Interval(6, 9),
                new Interval(3, 4),
                new Interval(2, 6)
        );

        List<Interval> list2 = Arrays.asList(
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(4, 5)
        );
        f(list).forEach(System.out::println);
        f(list2).forEach(System.out::println);
        System.out.println("");
        //Integer.compare(1,2);

    }

    static class Interval {
        int s;
        int e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "(" + s + "," + e + ")";
        }
    }

    static List<Integer> f(List<Interval> list) {
        List<Integer> visits = new ArrayList<>();
        if (list.isEmpty()) return visits;
        Collections.sort(list, (i1, i2) -> Integer.compare(i1.e, i2.e));
        int lastVisitTime = list.get(0).e;
        visits.add(lastVisitTime);
        for (Interval interval : list) {
            if (lastVisitTime < interval.s) {
                visits.add(interval.e);
                lastVisitTime = interval.e;
            }
        }
        return visits;
    }


}

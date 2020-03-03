package notes;

import java.util.*;

public class Notes {
    /**
     * Collection Heirarchy
     * <p>
     *                              Collection(I)
     * <p>
     * <p>
     *                  List(I)                             Queue(I)
     * <p>
     * <p>
     *                              LinkedList(C)
     *                                  ^
     *                                  |
     *                                  |
     *                                Stack
     * <p>
     * Collection Methods
     * add()
     * remove()
     * addAll(Collection<?> c)
     * removeAll(Collection<?> c)
     * isEmpty()
     * contains()
     * containsAll(Collection<?> c)
     * clear()
     * toArray()
     * size()
     * <p>
     * Hence ll has both the methods of Collections, List and Queue
     */
    public static void main(String[] a) {
        //Queue Methods
        //In Java Q doesn't have enqueue or dequeue methods, use the add and remove from COllections instead

        Queue<Integer> q = new LinkedList<>();
        q.add(8);
        q.add(38);
        q.isEmpty();

        //peek()Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        Integer canBeNull=q.peek();

        //poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
        Integer mayBeNull = q.poll();

        //remove() Retrieves and removes the head of this queue.
        //This method differs from poll only in that it throws an NoSuchElementException if this queue is empty
        q.remove();

        //Stack
        Stack<Integer> stack=new Stack<>();
        //Stack has all the list and queue methods see below
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.pop();
        stack.add(3);
//        stack.remove(3);
        stack.peek();
        stack.isEmpty();
        //TODO: String methods, Array Utils, comparable, comparator, syntax of class, function, interface, abstract class
        //TODO: Java scope when to use public private or default with class, method, variables.
        //String intern
        //Array and 2D array declare, initialize.
        int[] array={0, 1, 3, 4, 2, 5, 7, 6};
        Arrays.asList(1,2,45).forEach(System.out::print);
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        messages.forEach(System.out::println);
      //  List<Integer> list=Arrays.asList(a);
        //list.forEach(System.out::println);


    }

}

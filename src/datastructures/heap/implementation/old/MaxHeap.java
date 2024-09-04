package datastructures.heap.implementation.old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap {
    List<Integer> heap;
    Scanner scanner = new Scanner(System.in);

    public MaxHeap() {
        heap = new ArrayList<Integer>();
    }

    public void displayChoice() {
        System.out.println();
        System.out.println("=======MaxHeap Operations======");
        System.out.println("-1: show choice menu ");
        System.out.println(" 0: add item ");
        System.out.println(" 1: remove item ");
        System.out.println(" 2: print datastructures.heap ");
        System.out.println("type exit to quit");
        System.out.println("===============================");
        System.out.println();

    }

    public void printLine() {
        System.out.println();
        System.out.println("----------------------------");
    }

    public void add() {
        System.out
                .println("keep adding items, type 'exit' when done");

        while (true) {
            String input = scanner.next();
            if (input.equals("exit")) {
                break;
            }
            int item = Integer.parseInt(input);
            //add item to the last
            heap.add(item);

            // no need to heapyfy if there is only one item
            if (heap.size() > 1) {
                //since the newly added item is at the last shift it up
                shiftUp();
            }

        }
        printItems();
    }

    public int remove() {
        int item = -1;
        if (heap.size() == 0) {
            System.out.println("datastructures.heap is empty");

        } else {
            // replace the item at index 0 by the last item of the list
            item = heap.set(0, heap.get(heap.size() - 1));
            //remove last item as it's copied to the 0th index
            heap.remove(heap.size() - 1);
            //shift the item down in the list
            shiftDown();
        }
        System.out.println("removing " + item);
        printItems();
        return item;
    }

    private void shiftUp() {

        // item is index of newlyAddedItem
        int child = heap.size() - 1;

        int parent = (child - 1) / 2;

        while (heap.get(child) > heap.get(parent) && parent >= 0) {
//TODO use 
            //
            //java.util.Collections.swap(list, i, j);
            swapItemsWithGivenIndices(parent, child);

            //recalculate child parent after swapping.
            //TODO: remove these two lines
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void shiftDown() {
        // parent is the key at root which has to be heapyfied and adjusted
        int parent = 0;

        // parent has to be replaced by it's left or right child whichever is
        // greater
        // if parent is at position k left and right children are at 2k+1 and 2k+2 position
        // parent index of any node is always (c-1)/2, where c is the child's index
        int greaterChild = getGreaterChild(parent);

        // loop as long as any of the children is greater than the parent and we
        // have not reached the leaf node
        while (greaterChild >= 0 && heap.get(parent) < heap.get(greaterChild)) {
            swapItemsWithGivenIndices(parent, greaterChild);
            parent = greaterChild;
            //TODO: don't need it here
            greaterChild = getGreaterChild(parent);
        }

    }

    private void swapItemsWithGivenIndices(int one, int two) {
        int oneValue = heap.get(one);
        int twoValue = heap.get(two);
        heap.set(one, twoValue);
        heap.set(two, oneValue);
    }

    private int getGreaterChild(int k) {
        //returns index of the left or right child whichever is greater

        //index of left and right child
        int lc = 2 * k + 1;
        int rc = 2 * k + 2;
        int last = heap.size() - 1;

        //check if left child exists
        if (lc > last)
            return -1;
        //check if left child exists but right does not
        if (rc > last) {
            //retrun right child
            return lc;
        }

        if (heap.get(lc) > heap.get(rc)) {
            return (lc);
        } else {
            return (rc);
        }

    }

    public void printItems() {
        System.out.println(heap.toString());

    }
}

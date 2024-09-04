package datastructures.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// A simple Java program to introduce a linked list

public class LinkedList<C> {
    Scanner scanner = new Scanner(System.in);

    public void displayChoice() {
        System.out.println();
        System.out.println("==========choice menu==========");
        System.out.println("-1: exit ");
        System.out.println(" 0: createLinearLL ");
        System.out.println(" 1: traverse ");
        System.out.println(" 2: insertBeforeFirstNode ");
        System.out.println(" 3: findANodeUsingDataVaule  ");
        System.out.println(" 4: insertAfterGivenKey  ");
        System.out.println(" 5: findANodeUsingIndexNumber ");
        System.out.println(" 6: deleteANode");
        System.out.println(" 7: findMiddleElement");
        System.out.println(" 8: findNthElementFromEnd");
        System.out.println(" 9: deleteTheLL");
        System.out.println("10: findNumberOfTimesANodeValueRepeatsRecursively");
        System.out.println("11: reverseLL");
        System.out.println("12: detectALoopInLL");
        System.out.println("13: [circular LL] createCircularLL");
        System.out.println("14: checkIfTwoLLsIntersect");
        System.out.println("15: checkIfTwoLLsIntersectUsingASet");
        System.out.println("16: [circular LL] traverseCircularLL");
        System.out.println("17: [new] findMiddleElement");
        System.out.println("18:  delete dups");
        System.out.println("19: [2.4 ctci] add numbers on two LLs and create new ll as a result");
        System.out.println("===============================");
        System.out.println();

    }

    public void traverse(LLNode startNode) {
        // startNode=null;
        System.out.println("---------------------------------------------------------");
        /*
         * LLNode current = startNode; if (startNode.next == null) {
         * System.out.print("ll is empty"); } while (current.next != null) {
         * System.out.print(current.next.data + "  "); current = current.next; }
         */
        if (startNode == null || startNode.next == null) {
            System.out.println("empty list");
            return;
        }
        while (startNode.next != null) {
            System.out.print(startNode.next.data + "  ");
            startNode = startNode.next;
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

    public LLNode create() {
        // TODO: do we really need to initialize this?
        // Yes as we will be setting current.next to some other node, that will throw
        // NPE, it won't even compile with error, variable not initialized
        LLNode current = new LLNode();

        // we need to have two separate nodes start and current, current will be
        // incremented every time while start will be used to return in the end.
        LLNode start = current;
        System.out.println("Creating LL. Enter number of nodes");
        int numberOfNodes = scanner.nextInt();
        for (int i = 0; i < numberOfNodes; i++) {

            System.out.println("enter data value");
            int data = scanner.nextInt();
            LLNode node = new LLNode(data);
            current.next = node;
            current = node;
            // or
            // current=current.next
            // because
            // System.out.println(current.next==node);
            // above two lines rewritten as
            // current.setNext(node);
            // current = current.next;

            // last node should point to null, unless a value is assigned to it
            // it will by default point to null so this line isn't required
            // current.setNext(null);

        }
        return start;
    }

    public LLNode insertBeforeFirstNode(LLNode startNode) {

        System.out.println("enter data value to be inserted");
        LLNode newNode = new LLNode(scanner.nextInt());
        // set next of the newly created node to the first node .i.e the node
        // which start is pointing
        newNode.next = startNode.next;
        // can be rewritten as newNode.setNext(startNode.next);
        // let start point to the newly created Node becuase it is now
        // the first node
        startNode.next = newNode;
        // can be rewritten as startNode.setNext(newNode);
        return startNode;
    }

    public LLNode findANodeUsingDataVaule(LLNode start) {
        System.out.println("enter a data value whose location is to be found or after which you want to insert a node");
        int data = scanner.nextInt();
        int nodeData;
        LLNode current = start;
        int location = 0;

        System.out.println("finding...");
        while (current.next != null) {
            location++;
            nodeData = current.next.data;
            if (nodeData == data) {

                System.out.println(data + " found in LL, at location " + location);
                // System.out.println("current data"+current.data);
                // System.out.println("current next data "+
                // current.next.data);
                return current.next;
            }
            current = current.next;
        }
        System.out.println(data + " not found in LL");
        return current;

    }

    public int findANodeUsingDataVauleNew(LLNode start) {
        int index = 0;
        System.out.println("[new method] enter the value whose index is to be found...");
        int data = scanner.nextInt();
        while (start.next != null) {
            if (start.next.data == data) {
                return index;
            } else {
                index++;
                start = start.next;
            }
        }
        System.out.println("value not found");
        return -1;
    }

    public LLNode findANodeUsingIndexNumber(LLNode start) {
        System.out.println("enter the index number of the node you want to find");
        int index = scanner.nextInt();
        int counter = -1;
        LLNode current;
        current = start;
        System.out.println("finding using index number...");
        while (current.next != null) {
            counter++;
            if (counter == index) {
                System.out.println(" data at location " + index + " is " + current.next.data);
                return current.next;
            }
            current = current.next;
        }
        System.out.println("index " + index + " not found");
        return null;

    }

    public LLNode insertAfterGivenKey(LLNode start) {

        System.out.println("insert data value of node after which you want to insert a new node ");
        System.out.println("enter data value to be inserted");
        LLNode node = new LLNode(scanner.nextInt());
        LLNode insertAfterMe = findANodeUsingDataVaule(start);

        node.setNext(insertAfterMe.next);
        insertAfterMe.setNext(node);
        System.out.println("Node inserted " + node.data);
        return insertAfterMe;
    }

    public LLNode deleteANode(LLNode start) {

        System.out.println("enter a value to be deleted");
        int data = scanner.nextInt();
        LLNode current = start;
        System.out.println(current == start);
        while (current.next != null) {
            if (current.next.data == data) {
                System.out.println("item to be deleted found, deleting...");
                current.setNext(current.next.next);
                return current;
            }
            current = current.next;
        }
        System.out.println("item not even found, cann't delete");
        return null;

    }

    public void findMiddleElement(LLNode start) {
        LLNode scanner = new LLNode();
        LLNode scanner2x = new LLNode();
        scanner.setNext(start.next);
        scanner2x.setNext(start.next);

        while (scanner2x != null && scanner2x.next != null) {
            scanner2x = scanner2x.next.next;
            scanner = scanner.next;
        }
        System.out.println("middle element is " + scanner.data);

    }

    public void findMiddleElementNew(LLNode start) {
        LLNode fast = new LLNode();
        fast = start = start.next;
        while (fast.next != null) {
            start = start.next;
            fast = fast.next.next;
            // following lines are redundant
            /*
             * if (fast == null) { break; }
             */
        }
        System.out.println(start.data);
    }

    public LLNode findNthElementFromTheEnd(LLNode start, int n) {

        LLNode pointer = new LLNode(start.next);
        LLNode refPointer = new LLNode(start.next);
        /*
         * The above code is same as doing Node scanner=new Node(); Node scanner2x=new
         * Node(); scanner.setNext(start.next); scanner2x.setNext(start.next);
         */
        int i = 0;
        nullCheck(start);
        while (refPointer.next != null && i <= n) {
            refPointer = refPointer.next;
            i++;
        }
        if (i < n) {
            System.out.println("ll is too short, number of elements < " + n);
            return null;
        }
        while (refPointer.next != null) {
            refPointer = refPointer.next;
            pointer = pointer.next;
        }
        System.out.println(n + "th element from the end is " + pointer.next.data);
        return pointer.next;

    }

    public LLNode findNthElementFromTheEndNew(LLNode start, int n) {
        nullCheck(start);
        LLNode temp = new LLNode();
        temp.next = start.next;

        for (int i = 0; i < (n - 1); i++) {
            if (temp.next == null) {
                System.out.println("LL too short");
                throw new IndexOutOfBoundsException("LL too short");
            } else
                temp = temp.next;
        }

        while (temp != null) {
            start = start.next;
            temp = temp.next;
        }
        return temp;

    }

    public void nullCheck(LLNode start) {
        if (start.next == null) {
            System.out.println("ll is empty");
        }
    }

    public void deleteTheLL(LLNode start) {
        System.out.println(
                "In Java, automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to null.");
        start.setNext(null);

    }

    public int findNumberOfTimesANodeValueRepeatsRecursively(LLNode start, int number) {

        int counter = 0;
        LLNode current = new LLNode(start.next);
        nullCheck(start);
        while (current.next != null) {
            if (current.next.data == number) {
                counter++;
                findNumberOfTimesANodeValueRepeatsRecursively(current.next, number);

            }
            current = current.next;
        }
        return counter;
    }

    public LLNode reverseLL(LLNode start) {
        // For first node, previousNode will be null
        LLNode current = new LLNode(start.next);
        // we could also use start in place of current
        LLNode previousNode = null;
        LLNode nextNode;
        while (current != null) {
            // save state of next node, don't loose it's track
            // as we we change link of current.next
            nextNode = current.next;

            // reversing the link of currentNode
            // notice here we are not setting nextNode.next=current,
            // we do 1 step at a time.
            current.setNext(previousNode);
            // moving currentNode and previousNode by 1 node
            previousNode = current;
            current = nextNode;
        }
        traverse(previousNode);
        return previousNode;
    }

    public LLNode reverseLLNew(LLNode start) {
        LLNode current = new LLNode();
        current = start.next;
        LLNode previousNode, nextNode;
        previousNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = previousNode;
            previousNode = current;
            current = nextNode;

            // while processing the last node
            // current node will be the last node
            // next node will point to null
            // previousNode willl be come actual last node
        }
        // return previousNode;

        LLNode tail = new LLNode();
        tail.next = previousNode;
        traverse(tail);
        return tail;
    }

    public LLNode detectALoopInLL(LLNode start) {
        LLNode scanner = new LLNode(start);
        LLNode scanner2x = new LLNode(start);
        while (scanner.next != null && scanner2x.next != null) {
            scanner = scanner.next;
            scanner2x = scanner2x.next.next;
            if (scanner.next == scanner2x.next) {
                System.out.println("loop detected in ll");
                // return the node at which the loop is found
                return scanner.next;
            }

        }
        System.out.println("there is no loop ");
        return null;
    }

    public LLNode createCircularLL() {
        LLNode start = new LLNode();
        LLNode current = new LLNode();
        LLNode firstNode = new LLNode();
        current = start;
        System.out.println("Creating LL. Enter number of nodes");
        int numberOfNodes = scanner.nextInt();

        for (int i = 0; i < numberOfNodes; i++) {

            System.out.println("enter data value");
            int data = scanner.nextInt();
            LLNode node = new LLNode(data);
            current.setNext(node);
            if (i == 0) {
                firstNode = node;
            }
            current = current.next;
        }

        current.setNext(firstNode);
        return start;

    }

    public void checkIfTwoLLsIntersect(LLNode startFirst, LLNode startSecond) {

        /*
         * here we have to parts ... 1)Given two singly linked list, find if they are
         * intersecting. Do this in single iteration. a) traverse list1 and find the
         * last element b) traverse list2 and find the last element c) check if last
         * element of list1 == last element of list2 , if equal intersecting else not
         * here we have parsed the list only once :-)
         */
        LLNode lastNodeOfFirstLL, lastNodeOfSecondLL;
        lastNodeOfFirstLL = getLastNode(startFirst);
        lastNodeOfSecondLL = getLastNode(startSecond);
        if (lastNodeOfFirstLL == lastNodeOfSecondLL) {
            System.out.println("the two LLs intersect/have last node in common, the common node has data value as "
                    + lastNodeOfFirstLL.data);
        } else {
            System.out.println("the two LLs don't intersect");
        }

    }

    private LLNode getLastNode(LLNode start) {
        LLNode current = new LLNode(start);
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public LLNode checkIfTwoLLsIntersectUsingASet(LLNode firstLL, LLNode secondLL) {

        LLNode startNodeOfFirstLL = new LLNode(firstLL);
        LLNode startNodeOfSecondLL = new LLNode(secondLL);
        Set<LLNode> set = new HashSet<>();
        boolean intersect = false;
        // add all node addresses of firstll to a set
        while (startNodeOfFirstLL != null) {
            set.add(startNodeOfFirstLL.next);
            startNodeOfFirstLL = startNodeOfFirstLL.next;
        }
        System.out.println(set);
        // do the same with second ll if a duplicate is found there is
        // intersection at that point
        while (startNodeOfSecondLL != null) {
            intersect = set.add(startNodeOfSecondLL.next);
            if (!intersect) {
                System.out.println("the two LLs intersect at Node with value " + startNodeOfSecondLL.data
                        + "returning the intersecting node");
                return startNodeOfFirstLL;
            }
            startNodeOfSecondLL = startNodeOfSecondLL.next;
        }
        System.out.println("the two LLs don't intersect, returning null");
        return null;
    }

    public void traverseCircularLL(LLNode startNodeOfCircularLL) {
        LLNode firstNodeOfCircularLL = startNodeOfCircularLL;
        LLNode current = new LLNode(startNodeOfCircularLL.next);
        System.out.println("---------------------------------------------------------");
        do {
            current = current.next;
            System.out.print(current.data + "    ");

        } while (current.next != firstNodeOfCircularLL.next);
        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

    public void deleteDups(LLNode node) {
        Set<Integer> set = new HashSet<>();
        LLNode previous = null;
        // no NPE as first element is never a dup and in the next iteration previous
        // will a assigned a val for sure.

        while (node != null) {
            if (set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    public LLNode addNumbers(LLNode l1, LLNode l2) {
        LLNode start = new LLNode();
        LLNode l = start;
        int carry = 0, sum, result;
        while (l1 != null) {
            result = l1.data + l2.data + carry;
            sum = result % 10;
            carry = result / 10;
            l = new LLNode(sum);
            l = l.next;
        }
        if (carry != 0) {
            l = new LLNode(carry);
        }
        return start;
    }

}
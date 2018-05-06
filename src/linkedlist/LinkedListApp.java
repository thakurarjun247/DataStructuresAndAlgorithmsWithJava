package linkedlist;

import java.util.Scanner;

public class LinkedListApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		LLNode start = new LLNode();
		LLNode startNodeOfCircularLL = new LLNode();
		for (int i = 0; i < 100; i++) {
			System.out.println("Here is your LinkedList, what do you wanna do? ");
			ll.traverse(start);
			ll.displayChoice();
			int choice = scanner.nextInt();

			switch (choice) {
			case -1:
				System.out.println("exiting...");
				System.exit(0);
				break;
			case 0:
				start = ll.create();
				break;
			case 1:
				ll.traverse(start);
				break;
			case 2:
				ll.insertBeforeFirstNode(start);
				break;
			case 3:
				ll.findANodeUsingDataVaule(start);
				System.out.println("index number using new method " + ll.findANodeUsingDataVauleNew(start));
				break;
			case 4:
				ll.insertAfterGivenKey(start);
				break;
			case 5:
				ll.findANodeUsingIndexNumber(start);
				break;
			case 6:
				ll.deleteANode(start);
				break;
			case 7:
				System.out.println("[old method ]");
				ll.findMiddleElement(start);
				System.out.println("[new method ]");
				ll.findMiddleElementNew(start);

				break;
			case 8:
				System.out.println("Enter value of n, to find Nth Element From The End ");
				int n = scanner.nextInt();
				System.out.println("old method " + ll.findNthElementFromTheEnd(start, n));
				System.out.println("new method " + ll.findNthElementFromTheEndNew(start, n));
				break;
			case 9:
				ll.deleteTheLL(start);
				break;
			case 10:
				System.out.println("enter the element to be found ");
				int number = scanner.nextInt();
				int counter = ll.findNumberOfTimesANodeValueRepeatsRecursively(start, number);
				System.out.println(number + " repeats " + counter + " times ");
				break;
			case 11:
				System.out.println("you can choose among new vs old style implementation");
				start = ll.reverseLLNew(start);

				// old
				// LLNode newStart = ll.reverseLL(start);
				// ll.traverse(newStart);
				break;

			case 12:
				ll.detectALoopInLL(start);
				break;
			case 13:
				startNodeOfCircularLL = ll.createCircularLL();
				break;
			case 14:
				ll.checkIfTwoLLsIntersect(start, start);
				break;
			case 15:
				ll.checkIfTwoLLsIntersectUsingASet(start, start);
				break;
			case 16:
				ll.traverseCircularLL(startNodeOfCircularLL);
				break;
			case 17:
				ll.findMiddleElementNew(start);
				break;

			case 18:
				ll.deleteDups(start);
				break;
			case 19:
				System.out.println("creating first LL");
				LLNode l1 = ll.create();
				System.out.println("creating second LL");
				LLNode l2 = ll.create();
				LLNode l = ll.addNumbers(l1.next, l2.next);
				ll.traverse(l);
				break;
			default:
				System.out.println("invalid choice");

			}
		}
		scanner.close();

	}

}

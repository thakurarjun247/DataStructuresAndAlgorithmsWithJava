package heap;

import java.util.Scanner;

public class MaxHeapApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MaxHeap heap = new MaxHeap();
		heap.displayChoice();
		String input;
		while (true) {
			System.out.println("make a choice or type 'exit' to quit");
			input = scanner.next();
			switch (input) {
			case "-1":
				heap.displayChoice();
				break;
			case "0":
				heap.add();
				break;
			case "1":
				int item = heap.remove();
				break;
			case "2":
				heap.printItems();
				break;
			case "exit":
				System.exit(0);
			default:
				break;
			}

		}

	}

}

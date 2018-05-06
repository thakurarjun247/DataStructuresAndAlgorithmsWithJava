package arraystring.fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Pair {
	private int x;
	private int y;

	public Pair() {
		super();
	}

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]   ";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

public class MergeIntervals {
	public static void main(String[] args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[0]);
		}
		List<Pair> list = new ArrayList<>();

		System.out.println("enter the number of pairs");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("enter the pair [x, y]");
			System.out.println("x= ");
			int x = sc.nextInt();
			System.out.println("y= ");
			int y = sc.nextInt();
			list.add(new Pair(x, y));
		}
		System.out.println("input: ");
		list.forEach(System.out::print);

		Collections.sort(list, (p1, p2) -> p1.getX() - p2.getX());

		Stack<Pair> stack = new Stack<>();
		stack.push(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			Pair currentPair = list.get(i);
			Pair last = stack.peek();
			if (currentPair.getX() <= last.getY() && currentPair.getY() >= last.getY()) {
				Pair popped = stack.pop();
				popped.setY(currentPair.getY());
				stack.push(popped);
			} else {
				stack.push(currentPair);
			}
		}

		System.out.println("merged:");
		stack.forEach(System.out::print);

	}

}

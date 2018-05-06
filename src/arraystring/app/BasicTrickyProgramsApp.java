package arraystring.app;

import arraystring.fun.MaxSumIncreasingSubSequence;

public class BasicTrickyProgramsApp {
	public static void main(String[] args) {

		// ////////////////// Tricky
		// ////////////////// Tasks////////////////////////////////////////

		MaxSumIncreasingSubSequence.BasicTrickyPrograms trickyTasks = new MaxSumIncreasingSubSequence.BasicTrickyPrograms();
		String s = "you may be asked to write two version to solve this coding exercise ";
		// replace method can replace a char as well as set of chars
		String newS = s.replace('a', '@');

		// string is immutable hence one and the same after replace
		System.out.println(s);
		System.out.println(newS);
		System.out.println(s.replaceAll("a", "@"));

		System.out.println("replace and replaceAll ACT AS SAME,");
		String n = "0123456789abc";
		

		// substring includes starting index but omits end index
		System.out.println(n.substring(5, 8));
		System.out.println(n.charAt(5));
		System.out.println(s);

		// remove a char from a given string iteratively and recursively
		System.out.println(trickyTasks.remove(s, 'y'));

		System.out.println("is 9 a prime number " + trickyTasks.isPrime(9));

	}
}

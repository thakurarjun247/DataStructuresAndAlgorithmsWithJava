package arraystring.fun;

public class ReverseArrayAndString {

	public static void main(String[] args) {
		String s = "123321";
		char[] a = s.toCharArray();
		// revArrayIter(a);
		// String reversed=revArrayRec(a);
		System.out.println("isArrayPalinIterative " + isArrayPalinIterative(a));
		System.out.println("isStringPalinIterative(s) " +isStringPalinIterative(s));

	}

	private static boolean isStringPalinIterative(String s) {
		if(s==null||s.length()<2)
		{
			return true;
		}
		else {
			return (s.charAt(0) == s.charAt(s.length()-1) && isStringPalinIterative(s.substring(1,s.length()-1)));
		}
	}

	private static boolean isArrayPalinIterative(char[] a) {
		if (a == null || a.length < 2) {
			System.out.println("true");
			return true;
		} else {
			int start = 0;
			int end = a.length - 1;
			while (start < end) {
				if (a[start] != a[end]) {
					System.out.println("false");
					return false;
				}
				start++;
				end--;
			}
			System.out.println("true");
			return true;
		}

	}

	private static void revArrayIter(char[] a) {
		revArrayIter(a, 0, a.length - 1);
	}

	private static void revArrayIter(char[] a, int start, int end) {
		while (start < end) {
			char temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			start++;
			end--;

		}

	}

	private static String revArrayRec(char[] a) {

		if (a == null) {
			return null;
		}
		return revArrayRec(a, 0, a.length - 1);
	}

	private static String revArrayRec(char[] a, int start, int end) {
		if (start >= end) {
			// return a.toString();
			return String.valueOf(a);
		} else {
			char temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			start++;
			end--;
			return revArrayRec(a, start, end);
		}

	}

}

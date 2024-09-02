package datastructuresandalgorithms.arraystring.app;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("abc"));
    }

    public static String compress(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        char current = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                counter++;
            } else {
                builder.append(current).append(counter);
                counter = 1;
                current = s.charAt(i);

            }
        }
        builder.append(current).append(counter);

        return builder.toString();
    }

}

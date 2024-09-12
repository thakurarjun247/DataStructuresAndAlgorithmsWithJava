package algorithms.searching;

public class RabinKarpRollingHash {
    public static void main(String[] args) {
        System.out.println(rabinCarp("0123456789", "567"));
    }

    static int rabinCarp(String text, String pattern) {
        if (text == null || text.length() == 0 || pattern == null || pattern.length() == 0)
            return -1;
        int patternHash = hash(pattern);
        int textHash = hash(text.substring(0, pattern.length()));
        if (textHash == patternHash)
            return 0;
        for (int i = 1; i <= text.length() - pattern.length(); i++) {
            textHash = rollingHash(textHash, text.charAt(i - 1), text.charAt(i + pattern.length() - 1));
            if (textHash == patternHash && pattern.equals(text.substring(i, i + pattern.length())))
                return i;
        }
        return -1;
    }

    static int hash(String input) {
        int hash = 0;
        for (char c : input.toCharArray()) {
            hash += hash(c);
        }
        return hash;
    }

    static int rollingHash(int oldHash, char oldChar, char newChar) {
        return oldHash - hash(oldChar) + hash(newChar);
    }

    private static int hash(char c) {
        return ((int) c) * 101;
    }
}

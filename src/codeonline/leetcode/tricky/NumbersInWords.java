package codeonline.leetcode.tricky;

public class NumbersInWords{

        private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        public static String convert(int number) {
            if (number < 0 || number > 9999) {
                throw new IllegalArgumentException("Number must be between 0 and 9999");
            }
            if (number == 0) {
                return "zero";
            }
            StringBuilder sb = new StringBuilder();
            if (number / 1000 > 0) {
                sb.append(ONES[number / 1000]).append(" thousand ");
                number %= 1000;
            }
            if (number / 100 > 0) {
                sb.append(ONES[number / 100]).append(" hundred ");
                number %= 100;
            }
            if (number >= 10 && number < 20) {
                sb.append(TEENS[number - 10]);
                number = 0;
            }
            if (number >= 20) {
                sb.append(TENS[number / 10]).append(" ");
                number %= 10;
            }
            if (number > 0) {
                sb.append(ONES[number]);
            }
            return sb.toString().trim();
        }

        public static void main(String[] args) {
            System.out.println(convert(18)); // prints "eighteen"
            System.out.println(convert(1234)); // prints "one thousand two hundred thirty four"
        }
    }

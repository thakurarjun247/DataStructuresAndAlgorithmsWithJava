package javarevision.newjavaversions.java14;

public class SwitchCaseNew {
    public static void main(String[] args) {
        //use arrow operator instead of :
        //no need to use break;


        String s = "x";
        switch (s) {
            case "a" -> System.out.println(s);

            case "b" -> System.out.println("none");
            default -> System.out.println("defualu");
        }
        // int monthNumber=3;
        for (int monthNumber = 0; monthNumber < 14; monthNumber++) {
            String quarter = switch (monthNumber) {
                case 1, 2, 3 -> "q1";
                case 4, 5, 6 -> "q2";
                case 7, 8, 9 -> "q3";
                case 10, 11, 12 -> "q4";
                default -> "invalid input";
            };
            System.out.println(monthNumber + "->" + quarter);
        }
        //notice a semicolon
    }
}

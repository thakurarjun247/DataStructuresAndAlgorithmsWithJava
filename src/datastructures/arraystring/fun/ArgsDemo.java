package datastructures.arraystring.fun;

public class ArgsDemo {

    public static void main(String[] args) {
        String s = null;
        if (s.length() == 0 || s == null) {
            System.out.println("nulla");
        }
        System.out.println("hi");
        int sum = 0;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                try {
                    sum += Integer.parseInt(args[i]);
                    System.out.println(sum);
                } catch (NumberFormatException e) {
                    System.out.println(args[i] + "isn't a number");
                }
            }
        }
    }

}

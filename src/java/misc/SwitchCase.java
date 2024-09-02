package java.misc;

public class SwitchCase {
    public static void main(String[] args) {
        String s="string";
        for(char c:s.toCharArray()){
            switch (c){
                case 's':
                    System.out.println("its s");
                    break;

                default:
                    System.out.println("not s");
            }
        }

        String[] a= {"x", "y"};
        for(String item:a){
            switch (item){
                case
                    "x" :
                    System.out.println("X");
                break;
                case "y":
                    System.out.println("Y");
                    break;


            }
        }
    }
}

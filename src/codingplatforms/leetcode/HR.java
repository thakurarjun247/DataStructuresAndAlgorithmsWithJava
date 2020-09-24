package codingplatforms.leetcode;

public class HR {
    public static void main(String[] args) {
try{
    add();
    System.out.println("A");
}
catch (Exception e){
    System.out.println("B");
}
finally {
    System.out.println("c");
}
        System.out.println("d");
    }
    public static void  add(){
        throw  new RuntimeException();
    }
}

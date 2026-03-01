package javalanguage.fundamentals.characterclass;

public class CharacterClassMethods {
    public static void main(String[] args) {
        String s = "123aSD%# ";
        char c='x';
        //important methods of character class
        Character.isUpperCase('x');
        Character.isLowerCase('x');
        Character.isAlphabetic(c);
        Character.isDigit(c);

        for (char y : s.toCharArray()) {

            System.out.println(y);
        }
    }
}

package javalanguage.fundamentals.characterclass;

public class CharacterClassMethods {
    public static void main(String[] args) {
        String s = "123aSD%# ";
        for (char c : s.toCharArray()) {
            System.out.println(c + "Character.isAlphabetic(c)" + Character.isAlphabetic(c));
            System.out.println(c + "Character.isDigit(c)" + Character.isDigit(c));

        }
    }
}

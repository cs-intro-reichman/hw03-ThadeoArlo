public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }
    public static String uniqueChars(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == ' ' || newString.indexOf(letter) == -1) {
                newString += letter;
            }
        }
        return newString;
    }
}

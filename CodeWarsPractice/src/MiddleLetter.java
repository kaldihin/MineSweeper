public class MiddleLetter {

    public static void main(String[] args) {
        System.out.println(getMiddle("test"));
        System.out.println(getMiddle("A"));
        System.out.println(getMiddle("Ara"));
    }

    public static String getMiddle(String word) {

        if (word.length() % 2 == 1) {
            return word.substring(word.length()/2, word.length()/2+1);
        } else {
            return word.substring(word.length()/2-1, word.length()/2+1);
        }

    }

}

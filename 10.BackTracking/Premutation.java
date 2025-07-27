public class Premutation {
    public static void printPermutation(String str, String nStr) {

        if (str.length() == 0) {
            System.out.println(nStr);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, nStr + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, "");
    }
}

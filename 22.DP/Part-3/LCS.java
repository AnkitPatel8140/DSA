public class LCS {
    public static int lcsRecursion(String str1, String str2, int idx1, int idx2) {
        if(idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if(str1.charAt(idx1) == str2.charAt(idx2)) 
            return 1 + lcsRecursion(str1, str2, idx1-1, idx2-1);

        int ans1 = lcsRecursion(str1, str2, idx1-1, idx2);
        int ans2 = lcsRecursion(str1, str2, idx1, idx2-1);

        return Math.max(ans1, ans2);
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";

        System.out.println(lcsRecursion(str1, str2, str1.length()-1, str2.length()-1));
    }
}
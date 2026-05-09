import java.util.Arrays;

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
    
    public static int lcsMemoization(String str1, String str2, int idx1, int idx2, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    
        if(str1.charAt(idx1) == str2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + lcsMemoization(str1, str2, idx1-1, idx2-1, dp);
        }
        else {
            int ans1 = lcsMemoization(str1, str2, idx1-1, idx2, dp);
            int ans2 = lcsMemoization(str1, str2, idx1, idx2-1, dp);
            dp[idx1][idx2] = Math.max(ans1, ans2);
        }
    
        return dp[idx1][idx2];
    }

    public static int lcsTabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
             }
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";

        int[][] dp = new int[str1.length()][str2.length()];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(lcsRecursion(str1, str2, str1.length()-1, str2.length()-1));
        System.out.println(lcsMemoization(str1, str2, str1.length()-1, str2.length()-1, dp));
        System.out.println(lcsTabulation(str1, str2));
    }
}
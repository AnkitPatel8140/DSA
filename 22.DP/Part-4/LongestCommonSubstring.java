public class LongestCommonSubstring {
    public static int tabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];
        int max = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abgce";

        System.out.println(tabulation(str1, str2));
    }
}


// convert one string into another string with only insert and delete operations
public class StringConversion {

    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
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
        String str1 = "eabcdfg";
        String str2 = "cabcz";

        int lcsLength = lcs(str1, str2);

        int result = Math.abs(str1.length() - lcsLength) + Math.abs(str2.length() - lcsLength);

        System.out.println(result);
    }
}

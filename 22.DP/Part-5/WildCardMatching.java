public class WildCardMatching {
    public static boolean tabulation(String str, String wildCard) {
        int m = str.length();
        int n = wildCard.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            if(wildCard.charAt(i-1) == '*') {
                dp[0][i] = true;
            }
            else {
                break;
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str.charAt(i-1) == wildCard.charAt(j-1) || wildCard.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(wildCard.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }


        return dp[m][n];
    }
    public static void main(String[] args) {
        String str = "cb";
        String wildCard = "?a";

        System.out.println(tabulation(str, wildCard));
    }
}

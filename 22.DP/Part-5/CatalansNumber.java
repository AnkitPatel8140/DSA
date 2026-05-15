public class CatalansNumber {
    public static int recursion(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int cat = 0;

        for(int i = 0; i < n; i++) {
            cat += recursion(i)*recursion(n-i-1);
        }

        return cat;
    }

    public static int memoization(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int cat = 0;

        for(int i = 0; i < n; i++) {
            cat += memoization(i, dp)*memoization(n-i-1, dp);
        }

        dp[n] = cat;
        return dp[n];
    }

    public static int tabulation(int n) {
        if(n <= 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] dp = new int[15];
        System.out.println(memoization(14, dp));
        System.out.println(recursion(14));
        System.out.println(tabulation(14));
    }
}

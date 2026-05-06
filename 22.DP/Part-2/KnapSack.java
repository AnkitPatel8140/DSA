
import java.util.Arrays;

public class KnapSack{

    public static int knapSackRecursion(int[] val, int[] wt, int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(wt[n-1] <= W) { // valid
            // include
            int ans1 = val[n-1] + knapSackRecursion(val, wt, W-wt[n-1], n-1);
            // exclude
            int ans2 = knapSackRecursion(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        }
        else {
            return knapSackRecursion(val, wt, W, n-1);
        }
    }

    public static int knapsackMemoization(int[] val, int[] wt, int W, int n, int[][] dp) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) { // valid
            // include
            int ans1 = val[n-1] + knapsackMemoization(val, wt, W-wt[n-1], n-1, dp);
            // exclude
            int ans2 = knapsackMemoization(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else {
            dp[n][W] = knapsackMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                int value = val[i-1];
                int weight = wt[i-1];

                if(weight <= j) {
                    int includeItemProfit = value + dp[i-1][j-weight];
                    int excludeItemProfit = dp[i-1][j];

                    dp[i][j] = Math.max(includeItemProfit, excludeItemProfit);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        int[][] dp = new int[val.length + 1][W + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(knapSackRecursion(val, wt, W, val.length)); 
        System.out.println(knapsackMemoization(val, wt, W, val.length, dp)); 
        System.out.println(knapsackTabulation(val, wt, W)); 
    }
}
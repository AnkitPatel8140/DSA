
import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int recursion(int[] arr, int i, int j) {
        if(i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int cost1 = recursion(arr, i, k);
            int cost2 = recursion(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, cost1+cost2+cost3);
        }

        return ans;
    }

    public static int memoization(int[] arr, int i, int j, int[][] dp) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int cost1 = memoization(arr, i, k, dp);
            int cost2 = memoization(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        dp[i][j] = ans;
        return dp[i][j];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] n : dp) Arrays.fill(n, -1);
        
        System.out.println(recursion(arr, 1, 4));
        System.out.println(memoization(arr, 1, arr.length-1, dp));
    }
}

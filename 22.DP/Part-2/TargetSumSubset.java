public class TargetSumSubset {
    public static boolean targetSumSubset(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0; i < dp.length; i++) dp[i][0] = true;

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < sum+1; j++) {
                int v = arr[i-1];
                // include
                if(v <= j && dp[i-1][j-v]) dp[i][j] = true;
                // exclude
                if(dp[i-1][j]) dp[i][j] = true;

            }
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        int target = 10;

        System.out.println(targetSumSubset(arr, target));
    }
}
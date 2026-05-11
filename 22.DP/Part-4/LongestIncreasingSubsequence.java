import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public static int lcs(int[] arr1, int[] arr2) {
        int m = arr1.length; 
        int n = arr2.length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
    
    public static int tabulation(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] arr2 = new int[set.size()];

        int i = 0;
        for(int ele : set) {
            arr2[i++] = ele;
        }

        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println(tabulation(arr));
    }
}

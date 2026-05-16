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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        System.out.println(recursion(arr, 1, 4));
    }
}

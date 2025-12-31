public class ClimibingStairsRecursion {
    public static int climbingStairs(int n)
    {
        if(n==0)
            return 1;
        if(n<0)
            return 0;

        return climbingStairs(n-1) + climbingStairs(n-2);
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(climbingStairs(n));
    }
}

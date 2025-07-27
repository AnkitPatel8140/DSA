public class GridWays {

    public static int possible(int i, int j, int n, int m)
    {
        if(i==n-1 && j==m-1){
            return 1;
        }
        else if(i==n || j==m){
            return 0;
        }
        int way1=possible(i, j+1, n, m);
        int way2=possible(i+1, j, n, m);
        return way1+way2;
    }
    public static void main(String[] args) {
        int n=3, m=3;
        System.out.println(possible(0,0,n,m));
    }
}

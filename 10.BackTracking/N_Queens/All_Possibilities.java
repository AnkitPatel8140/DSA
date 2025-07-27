public class All_Possibilities {

    public static void possiblie(char arr[][], int row){
        if(row==arr.length){
            printBoard(arr);
            return;
        }
        for(int i=0; i<arr.length; i++){
            arr[row][i]='Q';
            possiblie(arr, row+1);
            arr[row][i]='*';
        }

    }

    public static void printBoard(char arr[][]){
        System.out.println("------------chess board------------");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int n=8;
        char arr[][]=new char[n][n];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j]='*';
            }
        }
        possiblie(arr, 0);

    }
}

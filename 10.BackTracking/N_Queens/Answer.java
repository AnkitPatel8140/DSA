public class Answer {

    public static Boolean isSafe(char arr[][], int row, int col)
    {
        // upper row
        for(int i=row-1; i>=0; i--)
        {
            if(arr[i][col]=='Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        // right diagonal
        for(int i=row-1,j=col+1; i>=0 && j<arr.length; i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void possiblie(char arr[][], int row){
        if(row==arr.length){
            printBoard(arr);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(isSafe(arr,row,i)){
                arr[row][i]='Q';
                possiblie(arr, row+1);
                arr[row][i]='*';
            }
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
        int n=4;
        char arr[][]=new char[n][n];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j]='*';
            }
        }
        possiblie(arr, 0);

    }
}

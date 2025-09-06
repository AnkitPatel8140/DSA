import java.util.Stack;
class StockSpanProblem
{
    public static void solver(int arr[]){
        int span[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1; i<arr.length; i++){
            while(!s.isEmpty()){
                if(arr[s.peek()]<=arr[i]){
                    s.pop();
                }
                else{
                    break;
                }
            }
            if(!s.isEmpty())
                span[i]=i-s.peek();
            else
                span[i]=i+1;
            s.push(i);
        }
        for(var a:span){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        int arr[]={100,80,60,70,60,85,100};
        solver(arr);
    }
}
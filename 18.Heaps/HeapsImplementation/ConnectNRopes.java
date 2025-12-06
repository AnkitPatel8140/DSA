
import java.util.PriorityQueue;

public class ConnectNRopes {
    public static int minCost(int arr[]){
        // step1 - create a priority queue for the array
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int x:arr){
            pq.add(x);
        }

        // step2 - keep adding the two smallest ropes and add the new rope to the pq
        int cost=0;
        while(pq.size()>1){
            int a=pq.remove();
            int b=pq.remove();
            cost+=(a+b);
            pq.add(a+b);
        }
        return cost;
    }
    public static void main(String[] args) {
        int ropes[]={2,3,3,4,6};
        System.out.println("Minimum length is:"+minCost(ropes));
    }
}

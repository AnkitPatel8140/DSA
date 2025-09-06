import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {

    public static void interleave(Queue<Integer> q){
        int size=q.size();
        Queue<Integer> fh=new LinkedList<>();
        for(int i=0; i<size/2; i++){
            fh.add(q.remove());
        }

        while(!fh.isEmpty()){
            q.add(fh.remove());
            q.add(q.remove());
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        interleave(q);
        System.out.println(q);
    }
}

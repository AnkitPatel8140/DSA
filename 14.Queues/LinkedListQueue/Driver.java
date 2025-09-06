public class Driver {
    public static void main(String[] args) {
        LLQueue q=new LLQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        System.out.println(q.remove());
    }
}

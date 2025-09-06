public class Driver {
    public static void main(String[] args) {
        CircularQueue q=new CircularQueue(3);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        System.out.println(q.remove());
        q.insert(4);
        System.out.println(q.remove());
        q.insert(5);

        while(!q.isEmpty())
            System.out.println(q.remove());
    }
}

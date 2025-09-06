public class Driver {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        while(!q.isEmpty()){
            System.out.println(q.pop());
        }
    }
}

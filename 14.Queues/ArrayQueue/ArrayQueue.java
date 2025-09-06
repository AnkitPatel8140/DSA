public class ArrayQueue {
    
    public class Queue{
        int arr[];
        int rear;
        int size;
        public Queue(int n){
            arr=new int[n];
            rear=-1;
            size=n;
        }

        public boolean isEmpty(){
            return rear==-1;
        }

        public void insert(int ele){
            if(rear==size-1){
                System.out.println("Alreay full");
                return;
            }
            arr[++rear]=ele;
        }

        public int remove(){
            if(rear==-1){
                System.out.println("Empty");
                return -1;
            }
            int front=arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String args[]){
        ArrayQueue aq=new ArrayQueue();
        Queue q=aq.Queue(5);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

    public Queue Queue(int n){
        return new Queue(n);
    }
}

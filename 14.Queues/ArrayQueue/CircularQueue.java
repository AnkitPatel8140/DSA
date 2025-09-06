// public class CircularQueue {
        public class CircularQueue{
        int arr[];
        int rear;
        int front;
        int size;
        public CircularQueue(int n){
            arr=new int[n];
            rear=front=-1;
            size=n;
        }

        public boolean isEmpty(){
            return rear==-1;
        }

        public boolean isFull(){
            return (rear+1)%size == front;
        }

        public void insert(int ele){
            if(isFull()){
                System.out.println("Alreay full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=ele;
        }

        public int remove(){
            if(rear==-1){
                System.out.println("Empty");
                return -1;
            }
            int res=arr[front];
             // last ele remove
            if(front==rear){
                front=rear=-1;
            }
            else{
                front=(front+1)%size;
            }
           
            return res;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            return arr[front];
        }
    }
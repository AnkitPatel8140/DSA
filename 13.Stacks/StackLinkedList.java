public class StackLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    protected boolean isEmpty(){
        return head==null;
    }
    protected void push(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
    }
    protected int pop(){
        if(isEmpty()){
            return -1;
        }
        int data=head.data;
        head=head.next;
        return data;
    }
    protected int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
    public static void main(String[] args) {
        StackLinkedList sl=new StackLinkedList();
        System.out.println(sl.pop());
        System.out.println(sl.peek());
        sl.push(10);
        sl.push(20);
        sl.push(30);
        sl.push(40);
        sl.push(50);
        sl.push(60);
        while(!sl.isEmpty()){
            System.out.println(sl.peek());
            sl.pop();
        }
    }

}

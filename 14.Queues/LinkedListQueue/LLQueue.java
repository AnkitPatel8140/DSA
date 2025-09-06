class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LLQueue {
    Node head=null;
    Node tail=null;

    public boolean isEmpty(){
        return head==null && tail==null;
    }

    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int res=head.data;
        if(tail==head){
            tail=head=null;
        }
        else{
            head=head.next;
        }
        return res;
    }
}

import java.util.LinkedList;
public class LinkedListCollectionFramwork {
    public static void main(String args[]){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(2);
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}

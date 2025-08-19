public class LinkedList {

    // creation of the node class
    public class Node {
        // defining the parameters
        int data;
        Node next;

        // creating the constructor to initialize the value
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // creating head and tail for the linked list it will create a new head and tail
    // for each object created
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void addFirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addIndex(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        int count = 0;
        Node temp = head;
        while ((count < idx - 1) && (temp.next != null)) {
            count++;
            temp = temp.next;
        }
        if (temp.next == null) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            int data = head.data;
            head = tail = null;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            size--;
            head = tail = null;
            return data;
        }
        Node temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        int data = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return data;
    }

    public void removeNthFromEnd(int idx) {
        if (size == 1 && idx == 1) {
            head = tail = null;
            return;
        }
        int index = size - idx;
        if (idx == size) {
            head = head.next;
            size--;
            return;
        }
        if (idx == 1) {
            Node temp = head;
            int i = 0;
            while (i < index - 1) {
                i++;
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            size--;
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            i++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public int itrSearch(int target) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recSearch(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = recSearch(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void revList() {
        Node curr = tail = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMid(head);

        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        if (head.next == null || head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            System.out.println("no cycle");
            return;
        }
        if (fast == head && slow == head) {
            slow.next = null;
            return;
        }
        slow = head;
        prev = null;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != tail) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " -> null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(19);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(7);
        ll.addFirst(0);
        ll.addFirst(15);
        ll.addFirst(8);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(9);
        ll.print();
        ll.head=ll.MergeSort(ll.head);
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println("end");
        ll.zigZag();
        ll.print();
        System.out.println(ll.tail.data);

    }

    public Node Mid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node Merge(Node left, Node right) {
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(left!=null && right!=null){
            if(left.data<=right.data){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }
            else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        while(left!=null){
            tail=left;
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        while(right!=null){
            tail=right;
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node MergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = Mid(head);
        Node r=mid.next;
        mid.next = null;
        Node left = MergeSort(head);
        Node right = MergeSort(r);
        return Merge(left, right);
    }


    public void zigZag(){
        // finding the mid of the list
        Node mid=Mid(head);
        tail=mid.next;
        // reversing the second half
        Node prev = null;
        Node curr = mid.next;
        mid.next=null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // code to make the zig zag
        Node rh=prev;
        Node lh=head;
        Node rhNext;
        Node lhNext;
        while(rh!=null && lh!=null){
            lhNext=lh.next;
            lh.next=rh;
            rhNext=rh.next;
            rh.next=lhNext;
            rh=rhNext;
            lh=lhNext;
        }
        if(lh!=null){
            tail.next=lh;
            tail=lh;
        }
        
    }
}
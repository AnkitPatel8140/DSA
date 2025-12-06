public class Driver {
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(10);
        h.add(4);
        h.add(3);
        h.add(2);
        h.add(5);
        h.add(6);
        h.print();
        System.out.println();
        // System.out.println(h.peek());
        while(!h.isEmpty()){
            System.out.println(h.delete());
        }
    }
}

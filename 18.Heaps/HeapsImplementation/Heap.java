import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void add(int data) {
        heap.add(data);

        int idxChild = heap.size() - 1;
        int idxParent = (heap.size() - 2) / 2;

        // we will swap the parent and child until we fix the position of the newly
        // inserted data
        while (heap.get(idxParent) > heap.get(idxChild)) {

            // swapping the two values of the parent and child
            int temp = heap.get(idxChild);
            heap.set(idxChild, heap.get(idxParent));
            heap.set(idxParent, temp);

            // updating the index of child and parent
            idxChild = idxParent;
            idxParent = (idxChild - 1) / 2;
        }
    }

    private void heapify(int idx) {
        int leftChild = (idx * 2) + 1;
        int rightChild = (idx * 2) + 2;
        int min = idx;

        if (heap.size() > leftChild && heap.get(min) > heap.get(leftChild)) {
            min = leftChild;
        }
        if (heap.size() > rightChild && heap.get(min) > heap.get(rightChild)) {
            min = rightChild;
        }

        if(min!=idx){
            int temp=heap.get(idx);
            heap.set(idx, heap.get(min));
            heap.set(min, temp);

            heapify(min);
        }
    }

    public int delete() {
        int data = heap.get(0);

        // step1 - swap first and last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.set(heap.size() - 1, data);

        // step2 - remove the last index
        heap.remove(heap.size() - 1);

        // step3- perform heapify
        heapify(0);

        return data;
    }

    public boolean isEmpty(){
        return heap.size()==0;
    }

    // this method is for printing the heap
    public void print() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

    public int peek() {
        return heap.get(0);
    }
}
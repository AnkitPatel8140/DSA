
import java.util.ArrayList;
import java.util.LinkedList;

// this is a generic class it will take two generic parameters
// K - key  ||   V - value 
public class HashMapImplementation<K, V> {

    // this class is for defining the node of the hashmap
    private class Node {
        K key;
        V value;

        // constructor
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // node of nodes 
    private int N; // size of the bucket
    private LinkedList<Node> buckets[]; // array of linkedlist

    // constructor
    @SuppressWarnings("unchecked")
    public HashMapImplementation() {
        this.N=4;
        buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashfunction(K key){
        int hc=key.hashCode();
        return Math.abs(hc)%N;
    }

    private int searchInLL(K key, int bi){
        LinkedList<Node> ll=buckets[bi];
        int di=0;
        for(int i=0; i<ll.size(); i++){
            Node node=ll.get(i);
            if(node.key==key){
                return di;
            }
            di++;
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash(){

        LinkedList<Node> oldBucket[]=buckets;
        buckets=new LinkedList[N*2];
        N=N*2;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i]=new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node=ll.remove();
                put(node.key,node.value);
            }
        }

    }

    public void put(K key, V value){

        int bi=hashfunction(key);
        int di=searchInLL(key,bi);

        if(di!=-1){
            Node node=buckets[bi].get(di);
            node.value=value;
        }
        else{
            buckets[bi].add(new Node(key,value));
            n++;
        }

        double lambda=n/N;
        if(lambda > 2.0){
            rehash();
        }
    }

    public boolean containsKey(K key){
        int bi=hashfunction(key);
        int di=searchInLL(key,bi);

        if(di!=-1){
            return true;
        }
        else{
            return false;
        }
    }

    public V get(K key){
        int bi=hashfunction(key);
        int di=searchInLL(key,bi);

        if(di!=-1){
            return buckets[bi].get(di).value;
        }
        else{
            return null;
        }
    }

    public V remove(K key){
        int bi=hashfunction(key);
        int di=searchInLL(key,bi);

        if(di!=-1){
            Node node=buckets[bi].remove(di);
            n--;
            return node.value;
        }
        else{
            return null;
        }
    }

    public ArrayList<K> getKeys(){
        ArrayList<K> res=new ArrayList<>();
        for (var bucket : buckets) {
            for(var node: bucket){
                res.add(node.key);
            }
        }
        return res;
    }

    @Override
    public String toString(){

        for (var bucket : buckets) {
            for(var node: bucket){
                System.out.println(node.key+" "+node.value);
            }
        }
        return "";
    }

}

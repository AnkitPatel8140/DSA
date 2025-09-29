import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// declaring the node class to create the node
class Node {

    // the node will have data, and refrence to its left and right child
    int data;
    Node left;
    Node right;

    // constructor
    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

}

class Information{
    boolean isBst;
    int size;
    int max;
    int min;

    public Information(boolean isBst, int size, int max, int min){
        this.isBst=isBst;
        this.size=size;
        this.max=max;
        this.min=min;
    }
}

public class BinarySearchTree {

    // head of the BinarySearchTree object
    Node head;

    // constructor will initialise the head
    public BinarySearchTree() {
        this.head = null;
    }

    private Node insertNode(Node root, int data) {
        // creating the new node to be inserted
        Node node = new Node(data);

        // if the root is null make the new node as root
        if (root == null) {
            return node;
        }

        // if data is greater than root insert it in the right subtee
        if (root.data < data) {
            root.right = insertNode(root.right, data);
        }
        // if the data is less than root insert it in the left subtree
        else {
            root.left = insertNode(root.left, data);
        }

        // return the root of the tree
        return root;
    }

    // creating the method to call the insertNode
    public void insert(int data) {
        head = insertNode(head, data);
    }

    public void buildTree(int nodes[]) {
        // if the nodes array is empty return null
        if (nodes.length == 0) {
            return;
        }

        // insert every node in the tree
        for (int i = 0; i < nodes.length; i++) {
            head = insertNode(head, nodes[i]);
        }
    }

    // function to perform the inorder travesal
    private void inOrderTraversal(Node root) {
        // if root equals null or root becomes leaf return
        if (root == null) {
            return;
        }
        // call the func again for left -> print the root -> call for right
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
        return;
    }

    // function to call the inOrderTravesal implementaion
    public void inOrder() {
        inOrderTraversal(head);
        System.out.println();
    }

    // function to search for a node in the tree
    private boolean searchNode(Node root, int data) {
        // if the root is null then the data is not present so return null
        if (root == null) {
            return false;
        }

        // if the data of the root is equal to the data then return true
        if (root.data == data) {
            return true;
        }

        // moving to the correct branch of the tree
        if (root.data > data) {
            return searchNode(root.left, data);
        } else {
            return searchNode(root.right, data);
        }
    }

    // function to call the seachNode from outside
    public boolean search(int data) {
        return searchNode(head, data);
    }

    // method to delete a Node in the bst
    private Node deleteNode(Node root, int val) {
        // if the root data is less than value then move towards the right subtree
        if (root.data < val) {
            root.right = deleteNode(root.right, val);
        }
        // if the root data is greater than value then move towards the left subtree
        else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        }
        // we found our node to be deleted
        else if (root.data == val) {
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 - contains single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3 - both children
            // find the inOrderSuccessor of the node
            Node inorderSuccessor = inOrderSuccessor(root.right);
            // make the current node as inOrderSuccessor
            root.data = inorderSuccessor.data;
            // delete the inOrderSuccessor of the node
            root.right = deleteNode(root.right, inorderSuccessor.data);
        } 
        return root;
    }

    // method to find the inordersuccessor of the node 
    private Node inOrderSuccessor(Node root){
    // we are already passing the right node of the root so we will need to find the left most node directly
        while(root.left!=null){
            // moving towards left till there is a left node in the tree
            root=root.left;
        }
        // return the left most node
        return root;
    }

    // method to call delete which will be called by the objects from outside the class
    public void delete(int value){
        head=deleteNode(head, value);
    }

    // method to printInRange from k1 - k2
    private void printInRange(Node root, int k1, int k2){
        // if root equals null return
        if(root==null){
            return;
        }
        // if root lies between k1 and k2 then call for printInRange for both left and right and print the root
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        // if roots data is less than k1 then call for right 
        else if(root.data<k1){
            printInRange(root.right, k1, k2);
        }
        // call for left
        else{
            printInRange(root.left, k1, k2);
        }
    }

    // method to call printInRange
    public void printInRange(int k1, int k2){
        printInRange(head, k1, k2);
    }

    // methdo to print all the paths from root to leaf
    private void printPaths(Node root, ArrayList<Integer> path){
        // if root is null then return
        if(root==null){
            return;
        }
        // this if block checks for the condition of leaf node
        if(root.left==null && root.right==null){
            // add the node 
            path.addLast(root.data);
            // print the path
            System.out.println(path);
            // remove the node and return
            path.removeLast();
            return;
        }

        // if there are still nodes left then add the node to the list
        path.addLast(root.data);
        // cal the printPaths for left and right subtree
        printPaths(root.left, path);
        printPaths(root.right, path);
        // remove the node from the list
        path.removeLast();
    }

    // this method will be called using object
    public void printPaths(){
        printPaths(head, new ArrayList<Integer>());
    }

    // method to check weather a bst is valid or not
    private boolean isValidBst(Node root, Node min, Node max){
        // if there are no nodes then it will always be a bst
        if(root==null){
            return true;
        }

        // if the min exists and it becomes greater than than the curr nodes data
        if(min!=null && min.data>=root.data){
            return false;
        }
        // if the max is not null and it becomes smaller than the curr nodes data
        else if(max!=null && max.data<=root.data){
            return false;
        }

        // for the left subtree min will be as it is but for it max will be the root/parent
        boolean left=isValidBst(root.left, min, root);
        // for the right subtree max will be as it is but for it min will be the root/parent
        boolean right=isValidBst(root.right, root, max);

        // answer will be true if bot left and right subtree are valid bst's
        return left && right;
    }

    // driver method for isValidBst()
    public boolean isValidBst(){
        return isValidBst(head, null, null);
    }

    // method to create a balanced bst using a sorted array
    private Node createBalanceTree(int arr[], int start, int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        if(start==end){
            return root;
        }

        root.left=createBalanceTree(arr, start, mid-1);
        root.right=createBalanceTree(arr, mid+1, end);

        return root;
    }

    public void buildBalancedTree(int arr[]){
        head=createBalanceTree(arr, 0, arr.length-1);

    }

    public void levelOrder(){
        if(head==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(head);
        q.add(null);

        while(!q.isEmpty()){
            Node n=q.remove();

            if(n==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else
            {
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
                System.out.print(n.data+" ");
            }

        }

    }

    static int maxBst=0;

    private static Information largestBST(Node root){

        if(root==null){
            return new Information(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Information left=largestBST(root.left);
        Information right=largestBST(root.right);
        int size=left.size+right.size+1;
        int min=Math.min(root.data,Math.min(left.min,right.min));
        int max=Math.max(root.data,Math.max(left.max,right.max));

        if(root.data<=left.max || root.data>=right.min){
            return new Information(false, size, max, min);
        }

        if(left.isBst && right.isBst){
            maxBst=Math.max(maxBst, size);
            return new Information(true, size, max, min);
        }
        
        return new Information(false, size, max, min);
    }

    public static int largestBst(Node root){
        maxBst=0;
        largestBST(root);
        return maxBst;
    }
    
}

public class Driver {
    public static void main(String[] args) {
        
        BinarySearchTree bst=new BinarySearchTree();
        // int arr[]={5,7,8,2,3,4,9};
        // bst.insert(1);
        // bst.buildTree(arr);

        // bst.inOrder();
        // bst.delete(2);
        // bst.inOrder();
        // bst.printInRange(0, 14);
        // System.out.println();
        // bst.printPaths();


                    //     5
                    // 2        7
                    //     3        8
                    //         4       9
    
        // System.out.println(bst.isValidBst());
        // int arr1[]={1,2,3,4,5,6,7,8,9,10};
        // BinarySearchTree bbt=new BinarySearchTree();
        // bbt.buildBalancedTree(arr1);
        // bbt.levelOrder();

        Node root=new Node(50);
        root.left=new Node(30);
        root.right= new Node(60);
        root.left.left=new Node(5);
        root.left.right=new Node(20);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);
        System.out.println(BinarySearchTree.largestBst(root));
    }
}

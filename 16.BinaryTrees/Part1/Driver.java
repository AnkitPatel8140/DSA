public class Driver {
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int node1[]={2,4,-1,-1,5,-1,-1};
        BinaryTrees btree=new BinaryTrees();
        Node root = btree.buildTree(node);
        BinaryTrees btree1=new BinaryTrees();
        Node root1 = btree1.buildTree(node1);

        btree.levelOrder(root);
        btree.transform(root)   ;
        btree.levelOrder(root);
        // System.out.println("Height of the tree is: "+btree.height(root));
        // System.out.println("Number of nodes in the tree is: "+btree.numOfNodes(root));
        // System.out.println("diameter of the tree : "+btree.diameterOfTree(root));
        // System.out.println("diameter of the tree : "+btree.diameterFinder(root));
        // System.out.println("is identical"+BinaryTrees.isSubtree(root, root1));

        // btree.topView(root);
        // btree.kthLevelOfTree(root, 1, 3);
        // System.out.println();
        // System.out.println("the lca is: "+btree.lca2(root, 4, 5).data);
        // System.out.println("this min disatance is: "+btree.minDistance(root, 1, 1));
        // System.out.print("kth ancestor is: ");
        // btree.kthAncestor(root, 4, 1);


    }
}
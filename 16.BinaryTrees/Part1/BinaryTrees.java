import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class Info {
    int diameter;
    int height;

    public Info() {
        diameter = 0;
        height = 0;
    }

    public Info(int dia, int h) {
        this.diameter = dia;
        this.height = h;
    }
}

public class BinaryTrees {

    int idx;

    public BinaryTrees() {
        idx = -1;
    }

    Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    void printTree(Node root) {
        if (root != null) {
            System.out.println(root.data);
            printTree(root.left);
            printTree(root.right);
            return;
        }
    }

    void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(rh, rh) + 1;
    }

    int numOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = numOfNodes(root.left);
        int rc = numOfNodes(root.right);
        return lc + rc + 1;
    }

    int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int rdiameter = diameterOfTree(root.right);
        int ldiameter = diameterOfTree(root.left);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiameter = lh + rh + 1;

        return Math.max(ldiameter, Math.max(rdiameter, selfDiameter));
    }

    Info diameter(Node root) {
        if (root == null) {
            Info info = new Info();
            return info;
        }

        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int leftHeight = left.height;
        int rightHeight = right.height;

        int leftDiameter = left.diameter;
        int rightDiameter = right.diameter;

        int selfDiameter = leftHeight + rightHeight + 1;

        int dia = Math.max(leftDiameter, Math.max(rightDiameter, selfDiameter));

        return new Info(dia, Math.max(leftHeight, rightHeight) + 1);
    }

    int diameterFinder(Node root) {
        Info ans = diameter(root);
        return ans.diameter;
    }

    static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;

    }

    class Information {
        Node node;
        int hd;

        public Information(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    void topView(Node root) {
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Information(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Information curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

        System.out.println();

    }

    void kthLevelOfTree(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevelOfTree(root.left, level + 1, k);
        kthLevelOfTree(root.right, level + 1, k);
    }

    boolean getPath(Node root, int node, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);
        if (root.data == node) {
            return true;
        }

        boolean left = getPath(root.left, node, path);
        boolean right = getPath(root.right, node, path);

        if (left || right) {
            return true;
        }

        path.removeLast();
        return false;
    }

    int lca(Node root, int n1, int n2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        if (i == 0) {
            return path1.get(i);
        }
        return path1.get(i - 1);

    }

    Node lca2(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node right = lca2(root.right, n1, n2);
        Node left = lca2(root.left, n1, n2);

        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }

        return root;
    }

    int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = lcaDist(root.left, n);
        int right = lcaDist(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }
        if (right == -1) {
            return left + 1;
        }
        return right + 1;
    }

    int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        int max = Math.max(left, right);
        if (max == -1) {
            return -1;
        }
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int right = transform(root.right);
        int left = transform(root.left);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = right + newLeft + left + newRight;
        return data;

    }
}

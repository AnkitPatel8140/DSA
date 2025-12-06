
public class ShorstesUniquePrefix {
    static class Node {
        int freq;
        Node childern[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (Node child : childern) {
                child = null;
            }
            this.freq = 1;
        }
    }

    static Node root = new Node();

    static public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            } else {
                curr.childern[idx].freq++;
            }
            curr = curr.childern[idx];
        }
        curr.eow = true;
    }

    static public String getprefix(String word) {
        Node curr = root;
        String ans = "";
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.freq >= 1) {
                ans += word.charAt(i);
            } else {
                ans += word.charAt(i);
                break;
            }
        }
        return ans;
    }

    public static void findPrefix(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.childern.length; i++) {
            if (root.childern[i] != null) {
                findPrefix(root.childern[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = { "dog", "dove", "zebra", "drove" };
        for (String word : arr) {
            insert(word);
        }
        root.freq = -1;
        findPrefix(root, "");

    }
}
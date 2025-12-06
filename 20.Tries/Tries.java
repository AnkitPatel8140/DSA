public class Tries {
    static class Node {
        Node childern[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < childern.length; i++) {
                childern[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.childern[idx] == null) {
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.eow;
    }

    // this function checks weather a given string can be formed or not using the trie
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // step1 - search() calling it for first part
            // step2 - calling wordBreak() for the rest of the part
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean prefix(String pre){
        Node curr=root;
        for (int i = 0; i < pre.length(); i++) {
            int idx=pre.charAt(i)-'a';
            if(curr.childern[idx]==null){
                return false;
            }
            curr=curr.childern[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key = "ilikesamsung";
        for (String word : arr) {
            insert(word);
        }
        System.out.println(prefix("like"));
        System.out.println(prefix("i"));
    }
}
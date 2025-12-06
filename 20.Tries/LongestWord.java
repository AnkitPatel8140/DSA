// Longest word with all the prefixes
// Find the longest string in words such that every prefix of it is also in words

public class LongestWord {
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

    public static String ans="";

    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return ;
        }
        for(int i=0; i<26; i++){
            if(root.childern[i]!=null && root.childern[i].eow){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.childern[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "ap", "app", "banana", "apple", "appl", "apply" };
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}

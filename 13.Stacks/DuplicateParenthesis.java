import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char c=str.charAt(i);
            if(c!=')'){
                s.push(c);
                continue;
            }
            int count=0;
            while(!s.isEmpty() && s.peek()!='('){
                s.pop();
                count++;
            }
            if(count<1){
                return true;
            }
            if(!s.isEmpty())
                s.pop();
        }
        return false;
    }
    public static void main(String[] args) {
        String str="(a)+(b)";
        System.out.println(isDuplicate(str));
    }
}

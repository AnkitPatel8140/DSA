import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0; i<str.length(); i++){
            char bracket=str.charAt(i);
            if(bracket=='{' || bracket=='[' || bracket=='('){
                s.push(bracket);
            }
            else if(!s.isEmpty() && bracket=='}' && s.peek()=='{'){
                s.pop();
            }
            else if(!s.isEmpty() && bracket==']' && s.peek()=='['){
                s.pop();
            }
            else if(!s.isEmpty() && bracket==')' && s.peek()=='('){
                s.pop();
            }
            else{
                return false;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String str="{{{[[[()]]]}}}()[(]";
        System.out.println(isValid(str));
    }
}

import java.util.Stack;
public class StackCollectionFramework {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int d=s.pop();
        pushAtBottom(s, data);
        s.push(d);
    }

    public static String revserseString(String str){
        StringBuilder s=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            s.append(stack.pop());
        }
        return s.toString();
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return ;
        }
        int top=stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        // pushAtBottom(s, 1);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
        // String str="Hello";
        // str=revserseString(str);
        // System.out.println(str);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
    }
}

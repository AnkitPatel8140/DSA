
import java.util.Stack;

public class Queue {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void push(int ele){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(ele);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop(){
        if(s1.isEmpty()){
            return -1;
        }
        else{
            return s1.pop();
        }
    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }
}
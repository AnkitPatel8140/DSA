
import java.util.ArrayList;

public class StacksArrayList{
    ArrayList<Integer> stack=new ArrayList<>();

    protected boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }
        return false;
    }

    protected void push(int data){
        stack.addLast(data);
        return;
    }

    protected int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        int data=stack.get(stack.size()-1);
        stack.removeLast();
        return data;
    }
    
    protected int peek(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.get(stack.size()-1);
    }

    public static void main(String[] args) {
        StacksArrayList sa=new StacksArrayList();
        sa.pop();
        sa.push(10);
        sa.push(20);
        sa.push(30);
        sa.push(40);
        sa.push(50);
        while(!sa.isEmpty()){
            System.out.println(sa.pop());
        }
    }
}
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nge[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for (var x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (var x : nge) {
            System.out.print(x + " ");
        }
    }
}

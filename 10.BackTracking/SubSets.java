public class SubSets {

    public static void subString(String str, String ans, int i)
    {
        // base case
        if(i==str.length()){
            // printing the final answer after all the choices and then returning
            System.out.println(ans);
            return ;
        }
        // if the character chooses to be part of the string
        subString(str, ans+str.charAt(i), i+1);
        // if the character chooses not to be part of the string
        subString(str, ans, i+1);
    }

    public static void main(String[] args) {
        subString("abc", "", 0);
    }
}

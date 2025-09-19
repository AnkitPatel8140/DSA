
import java.util.ArrayList;

public class ActivitySelection{
    public static void main(String[] args) {
        // creating the activity chart
        int []start={1,3,0,5,8,5};
        int []end={2,4,6,7,9,9}; 

        // intialising the necessary variables
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        // include the first activity
        maxAct=1;
        ans.add(0);
        int lastAct=end[0];

        for (int i = 1; i < end.length; i++) {
            if(start[i]>=lastAct){
                maxAct++;
                ans.add(i);
                lastAct=end[i];
            }
        }

        System.out.println(ans);
    }
}
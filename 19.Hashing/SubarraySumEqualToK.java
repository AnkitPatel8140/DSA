import java.util.HashMap;

public class SubarraySumEqualToK {
    public static void main(String[] args) {
        int arr[]={10,2,-2,-20,10};
        int k=-10;

        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int count=0;
        hm.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            int j=sum-k;
            if(hm.containsKey(j)){
                count+=hm.get(j);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        System.out.println(count);
    }
}

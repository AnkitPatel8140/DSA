import java.util.Arrays;
import java.util.Comparator;

public class FractionalKanpsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) value[i] / weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        double ans = 0;
        int capacity = w;

        for (int i = value.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                capacity -= weight[idx];
                ans += (weight[idx] * ratio[i][1]);
            } else {
                ans += (capacity * ratio[i][1]);
                capacity = 0;
            }

        }
        System.out.println(ans);
    }
}

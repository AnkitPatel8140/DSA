
import java.util.PriorityQueue;

public class KNearestCars {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance){
            this.x=x;
            this.y=y;
            this.distance=distance;
        }

        @Override
        public int compareTo(Point p2){
            return this.distance-p2.distance;
        }
    }

    public static void main(String[] args) {
        int points[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int i=0; i<points.length; i++){
            int distance=(int)Math.pow(points[i][0], 2)+ (int)Math.pow(points[i][1], 2);
            pq.add(new Point(points[i][0], points[i][1], distance));
        }

        for(int i=0; i<k; i++){
            Point curr=pq.remove();
            System.out.println(curr.x+" "+curr.y);
        }
    }
}

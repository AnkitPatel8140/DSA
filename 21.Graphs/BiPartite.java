import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartite {

    static class Edge {
        int src, des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0)); 
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                queue.add(i);
                color[i] = 0; // yellow
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    for (int j = 0; j < graph[cur].size(); j++) {
                        Edge e = graph[cur].get(j);

                        if (color[e.des] == -1) {
                            int nextColor = color[cur] == 0 ? 1 : 0;
                            color[e.des]=nextColor;
                            queue.add(e.des);
                        } else if (color[e.des] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[5];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}

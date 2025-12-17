
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSortDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortDFSUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }

    public static void topSortDFSUtil(ArrayList<Edge>[] graph, int cur, boolean[] vis, Stack<Integer> s) {
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!vis[e.des]) {
                topSortDFSUtil(graph, e.des, vis, s);
            }
        }
        s.push(cur);
    }

    public static void calIndgree(ArrayList<Edge>[] graph, int[] indegree) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.des]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge>[] graph) {
        int[] indegree = new int[graph.length];
        calIndgree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.remove();
            System.out.print(v + " ");
            for (int i = 0; i < graph[v].size(); i++) {
                Edge e = graph[v].get(i);
                indegree[e.des]--;
                if (indegree[e.des] == 0)
                    q.add(e.des);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        topSortDFS(graph);
        System.out.println();
        topSortBFS(graph);
    }
}

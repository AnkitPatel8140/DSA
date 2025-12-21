
import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
    static class Edge {
        int src, dst;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int cur, boolean[] vis, Stack<Integer> s){
        vis[cur]=true;
        for(int i=0; i<graph[cur].size(); i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dst]){
                topSort(graph,e.dst, vis, s);
            }
        }
        s.push(cur);
    }

    public static void dfs(ArrayList<Edge>[] graph, int cur, boolean[] vis)
    {
        vis[cur]=true;
        System.out.print(cur+" ");
        for(int i=0; i<graph[cur].size(); i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dst]){
                dfs(graph,e.dst,vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V){
        // Step 1 Topological sorting
        Stack<Integer> s = new Stack<>();
        boolean[] vis=new boolean[V];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        // Step 2 Transpose Graph
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e=graph[i].get(j);
                transpose[e.dst].add(new Edge(e.dst, e.src));
            }
        }

        vis=new boolean[V];
        // Step 3 DFS on trapnspose
        while(!s.isEmpty()){
            int cur=s.pop();
            if(!vis[cur]){
                System.out.print("SCC->");
                dfs(transpose, cur, vis);
                System.out.println();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}

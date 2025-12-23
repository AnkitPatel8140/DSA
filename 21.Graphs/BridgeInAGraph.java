import java.util.ArrayList;

public class BridgeInAGraph {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));
        
        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge>[] graph, int cur, int par, int dt[], int low[],boolean[] vis, int time){
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        for (int idx = 0; idx < graph[cur].size(); idx++) {
            Edge e=graph[cur].get(idx);
            int neigh=e.dst;
            if(e.dst==par){
                continue;
            }
            else if(!vis[neigh]){
                dfs(graph, neigh, cur, dt, low, vis, time);
                low[cur]=Math.min(low[cur], low[neigh]);
                if(dt[cur]<low[neigh]){
                    System.out.println("Bridge : "+e.src+"->"+e.dst);
                }
            }
            else{
                low[cur]=Math.min(low[cur], dt[neigh]);
            }

            
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}

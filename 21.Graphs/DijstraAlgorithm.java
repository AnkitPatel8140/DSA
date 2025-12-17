import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijstraAlgorithm {
    
    static class Edge {
        int src, des, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int n,path;
        public Pair(int n, int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    // TC V+ElogE
    public static void dijstra(ArrayList<Edge>[] graph, int src){
        int[] dist=new int[graph.length]; // dist[i] => src to i
        for(int i=0; i<dist.length; i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE; //+infinity
            }
        }

        boolean[] vis=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!vis[cur.n]){
                vis[cur.n]=true;
                // neighbours
                for(int i=0; i<graph[cur.n].size(); i++){
                    Edge e=graph[cur.n].get(i);
                    int u=e.src;
                    int v=e.des;
                    int wt=e.wt;

                    if(dist[u]+wt < dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[6];
        create(graph);
        int src=0;
        dijstra(graph, src);
    }
}
// Dijsktra does not gurantee to find correct path in negative weight edge
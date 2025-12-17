import java.util.ArrayList;

public class BellManFordAlgorithm {
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

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }


    // O(VE)
    public static void bellManFord(ArrayList<Edge>[] graph, int src){
        int[] dist=new int[graph.length]; // dist[i] => src to i
        for(int i=0; i<dist.length; i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE; //+infinity
            }
        }
        int V = graph.length;
        // O(V)
        for(int i=0; i<V-1; i++){
            // O(E)
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.des;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for(int dis:dist){
            System.out.print(dis+" ");
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[5];
        create(graph);
        int src=0;
        bellManFord(graph, src);
    }

}

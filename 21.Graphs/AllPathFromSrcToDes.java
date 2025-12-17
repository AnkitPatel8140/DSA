import java.util.ArrayList;

public class AllPathFromSrcToDes {
    

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

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

//  exponential T.C
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int des, String path)
    {
        if(src == des){
            System.out.println(path+des);
            return ;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.des, des, path+src);
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        int src = 5, des = 1;
        printAllPath(graph, src, des, "");
    }
}
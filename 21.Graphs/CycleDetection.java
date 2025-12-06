import java.util.ArrayList;
public class CycleDetection {

    static class Edge {
        int src, des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1));
        //graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        //graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean cycleDetection(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(cycleDetectionUtil(graph, visited, i, -1)) return true;
            }
        }
        return false;
    }

    public static boolean cycleDetectionUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent ){
        visited[current]=true;
        for(int i=0; i<graph[current].size(); i++){
            Edge e=graph[current].get(i);
            if(!visited[e.des]){
                if(cycleDetectionUtil(graph, visited, e.des, e.src))
                    return true;
            }
            else if(visited[e.des] && e.des!=parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[5];
        createGraph(graph);
        System.out.println(cycleDetection(graph)+"$$$$$");
    }
}
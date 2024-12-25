package Graph;
import java.util.*;
/*
 *  Shortest Path from source to all vertices(weighted graph)
 * 
 * 
 * 
 *              2       7       1
 *         0------->1------->3------>5
 *          \       |       /|\     /|\
 *          4\      |1       |2      |5
 *            \    \|/       |       |
 *             ---->2------->4-------
 *                      3
 */
public class Dijkstra {//greedy based algo
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    static ArrayList<Edge>[] createGraph(int vertices) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3,5, 1));

        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 5));

        return graph;
    }

    static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print("[" + edge.dest + "] ");
            }
            System.out.println();
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    static void dijkstra(ArrayList<Edge>[] graph,int src){//O(V+ElogV)
        int dist[]=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i!=src)
                dist[i]=Integer.MAX_VALUE;
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        //print all source to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 6;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);
        dijkstra(graph, 0);
    }
}

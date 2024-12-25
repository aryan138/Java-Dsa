package Graph;
import java.util.*;
/*
 *  Shortest Path from source to all vertices(weighted graph)
 *  Performs this operation v-1 times: for all edges(u,v)
 *                                          if(dist[u]+wt(u,v)<dist[v])
 *                                              dist[v]=dist[u]+wt(u,v)
 * 
 * 
 *              2       -1   
 *         0------->1<-------4
 *          \       |       /|\             
 *          4\      |-4      |4 
 *            \    \|/       | 
 *             ---->2------->3
 *                      2
 * 
 *  NOTE: It doesn't work for Negative Weight Cycles(cycles whose total weight comes out to be negative)
 */
public class BellmanFord {//dp based algo
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

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3,2));

        graph[3].add(new Edge(3,4, 4));

        graph[4].add(new Edge(4,1,-1));

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
    static void bellmanFord(ArrayList<Edge>[] graph,int src){//O(V*E)
        int dist[]=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i!=src)
                dist[i]=Integer.MAX_VALUE;
        }
        int V=graph.length;
        for (int i = 0; i < V-1; i++) {//algo
           //edges-O(E)
           for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Edge e=graph[j].get(k);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
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
        int vertices = 5;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);
        bellmanFord(graph, 0);
    }
}

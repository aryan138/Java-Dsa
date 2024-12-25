package Graph;
import java.util.*;
/*
 *  MST-Minimum Spanning Tree or Minimum Weight Spanning Treeia a subset of edges of a coonected, edge-weighted undirected graph that connects allhe vertices together, without any cycles and with the minimumpossible total edge weight.
 * 
 * 
 *              0
 *             /|\     
 *            / | \  
 *         10/  |  \15
 *          /   |   \
 *         1    |30  2   
 *          \   |   /
 *         40\  |  /50
 *            \ | /
 *             \|/
 *              3 
 */
public class Prim {
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
        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));

        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,40));

        graph[2].add(new Edge(2, 0,3));
        graph[2].add(new Edge(2, 3,40));

        graph[3].add(new Edge(3,1, 40));
        graph[3].add(new Edge(3,2, 50));

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
        int v;
        int cost;
        Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    static void prim(ArrayList<Edge>[] graph){//O(V+ElogV)
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println(finalcost);
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 5;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);
        prim(graph);
    }
}

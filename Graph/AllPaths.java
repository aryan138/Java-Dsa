package Graph;
import java.util.*;
/*
 *          5------>0<-------4
 *          |       |        |
 *          |       |        |
 *         \|/     \|/      \|/
 *          2------>3------->1
 */
public class AllPaths {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    static ArrayList<Edge>[] createGraph(int vertices) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

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

    static void all_path(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e=graph[src].get(i);
            //e.dest->neighbour
            all_path(graph, e.dest, dest, path+src);
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 6;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);
        all_path(graph, 5, 1, "");
    }
}

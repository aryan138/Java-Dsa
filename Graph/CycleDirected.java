package Graph;

import java.util.ArrayList;

public class CycleDirected {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    /*
     *         1------>0<------3                2<-------0------>1
     *                 |      /|\                \               /
     *                 |       |                  \             /
     *                \|/      |                   \           /
     *                 2--------                    ---->3<----
     *             
     *               
     */
    static ArrayList<Edge>[] createGraph(int vertices) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 2));

        // 1-vertex
        graph[1].add(new Edge(1, 0));

        // 2-vertex
        graph[2].add(new Edge(2, 3));

        // 3-vertex
        graph[3].add(new Edge(3, 0));

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

    static boolean detect_cycle(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detect_cycle_util(graph,i,vis,stack)){
                    return true;//cycle exists in one of parts
                }
            }
        }
        return false;
    }

    static boolean detect_cycle_util(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack){
        vis[curr]=true;
        stack[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]&&detect_cycle_util(graph, e.dest,vis,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 4;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);

        System.out.println(detect_cycle(graph));

    }
}

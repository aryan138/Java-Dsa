package Graph;

import java.util.ArrayList;

/*
 * Un-Directed: DFS
 *              BFS
 *              DSU(Disjoint set union)
 * Directed: DFS
 *           BFS
 *           Topological Sort(Kahn's Algorithm)
 * 
 * Cycle Dection: Three cases in which neighbour exist:- CASE 1:  vis[neighbour] True but it is not a parent--->Cycle exist
 *                                                       CASE 2:  vis[neighbour] True and it is a parent---> can't say continie;
 *                                                       CASE 3:  vis[neighbour] False--->perform normal DFS
 */
public class CycleUnDirected {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    /*
     *              0------3
     *             /|      |
     *            / |      |
     *           1  |      4
     *            \ |
     *             \|
     *              2 
     */
    static ArrayList<Edge>[] createGraph(int vertices) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1-vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2-vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4-vertex
        graph[4].add(new Edge(4, 3));

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
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detect_cycle_util(graph,i,-1,vis)){
                    return true;//cycle exists in one of parts
                }
            }
        }
        return false;
    }

    static boolean detect_cycle_util(ArrayList<Edge>[] graph,int curr,int par,boolean[] vis){
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            //CASE 3:
            if(!vis[e.dest]){
                if(detect_cycle_util(graph, e.dest, curr, vis))
                return true;
            }
            //CASE 1:
            else if(vis[e.dest]&& e.dest!=par){
                return true;
            }
            //CASE 2: DO NOTHING
        }
        return false;
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 5; // 0 to 6
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);

        System.out.println(detect_cycle(graph));

    }
}

package Graph;
/*
 *  Bypartite graph is a graph whose vertices are divided into 2 independent sets, U and V such that every edge (u,v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge(u,v), either u belongs to U and v to V,or u belongs to V and v belongs to U. We can also say that there is no edge that connects vertices of same sets
 * 
 *              0                                    0
 *             / \                                 /   \
 *            /   \                               /     \ 
 *           1     4                             1       2
 *            \   /                               \     /
 *             \ /                                 3---4     
 *              3  
 *          SET(U):{0,3}                        It is not can be divided into 2 sets 
 *          SET(V):{1,2}....It is bypartite
 */

import java.util.*;

public class Bypartite {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

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

        // 1-vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3-vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // 4-vertex
        graph[4].add(new Edge(4, 2));
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

    static boolean is_bypartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;// no color
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {// BFS
                q.add(i);
                col[i] = 0;// yellow color
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextcol = (col[curr] == 0) ? 1 : 0;
                            col[e.dest]=nextcol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 5; // 0 to 6

        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);

        // Print the graph
        printGraph(graph);

        System.out.println(is_bypartite(graph));

    }
}

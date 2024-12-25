package Graph;
//There is no condition in graph which tells that graph can only be connected 
//so for those unconnecetd cases normal bfs and dfs fails
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class connectedComponents {
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
    /*                    1------3     
    *                   /       |\               
    *                  0        | 5----6   
    *                   \       |/ 
    *                    2------4  
    */
    static ArrayList<Edge>[] createGraph(int vertices) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5-vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6-vertex
        graph[6].add(new Edge(6, 5, 1));

        return graph;
    }

    static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print("[" + edge.dest + ", " + edge.wt + "] ");
            }
            System.out.println();
        }
    }

    static void B_F_S(ArrayList<Edge>[] graph) {
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i])
            B_F_S_util(graph, vis);
        }
    }

    static void B_F_S_util(ArrayList<Edge>[] graph,boolean vis[]) {//O(n)->O(V+E)
        Queue<Integer> q=new LinkedList<>();
        //boolean vis[]=new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    static void D_F_S(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                D_F_S_util(graph, i, vis);
            }
        }
    }
    
    static void D_F_S_util(ArrayList<Edge>[] graph, int curr, boolean[] vis) { // O(V + E)
        // Visit the current node
        System.out.print(curr + " ");
        vis[curr] = true;
    
        // Traverse all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                D_F_S_util(graph, e.dest, vis);
            }
        }
    }
    

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 7; // 0 to 6
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);

        // BFS of the graph
        B_F_S(graph);

        System.out.println();

        // DFS of the graph
        D_F_S(graph);

    }
}

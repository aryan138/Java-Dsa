package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Directed Acyclic Graph(DAG) is a directed graph with no cycles.Topological sorting is used only for DAGs(not for non-DAGs).It is a linear order of vertices such that every directed edge u->v, the vertex u comes before v in the order.  
 * 
 *          5------>0<-------4
 *          |                |
 *          |                |
 *         \|/              \|/
 *          2------>3------->1
 * 
 *  Using BFS(Kahn's Algorithm) in-degree: nodes incomming edges    5<-----6
 *                              out-degree: nodes outgoing edges    5----->6
 *  FACT: DAGs has atleast one vertex with indegree 0 and one vertex with outdegree 0
 *  calculate indegree of each node i.e destination, add in queue whose indegree is 0 then while taking out from queue sub -1 indegree from neighbours then check if someones ingdree is 0 if yes then add in queue
 */
public class TopologicalSort {
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

    static void top_sort_dfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i])
                top_sort_dfs_util(graph,i,vis,s);
        }
        while(!s.isEmpty())
            System.out.print(s.pop()+" ");
    }

    static void top_sort_dfs_util(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> stack){
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                top_sort_dfs_util(graph, e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    static void cal_indeg(ArrayList<Edge>[] graph,int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e=graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    static void top_sort_bfs(ArrayList<Edge>[] graph){
        int indeg[]=new int[graph.length];
        Queue<Integer> q =new LinkedList<>();
        cal_indeg(graph, indeg);
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0)
                    q.add(e.dest);
            }
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 6;
        
        // Create the graph
        ArrayList<Edge>[] graph = createGraph(vertices);
        
        // Print the graph
        printGraph(graph);

        top_sort_dfs(graph);
        System.out.println();

        top_sort_bfs(graph);

    }
}

package Graph;

import java.util.ArrayList;

/*
 * Grapg has Vertex and edge            source,destination,weight
 * 
 * EDGES: Uni-Directional:  a-->b               Directed Graph
 *        Bi-Directional:   a<-->b              Un-Directed Graph
 *        Un-Directed:      a--b                Weighted Graph
 *                                              Un-Weighted Graph
 * 
 * In graph question there are some task that we need to perform quite often
 *      1. find your neighnour
 * 
 * Storing a Graph: Adjacency List: List of Lists ArrayList<ArrayList>, Array<ArrayList>, HashMap<int,list>
 *                  Adjacency Matrix
 *                  Edge List:  {{0,1},{1,2},{2,3},{3,2}}
 *                  2D Matric(Implicit Graph)                  0 1 2 3 
 *               0   2          0-[0]                      0 [[0,1,0,0]
 *                \ / \         1-[0,2,3]                  1  [1,0,1,1]
 *                 1---3        2-[1,3]                    2  [0,1,0,1]
 *                              3-[1,2]                    3  [0,1,1,0]]
 * 
 */         

 //creating a graph: Adjacency List
class Basics{
    @SuppressWarnings("unused")
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
    public static void main(String[] args) {
        /*
                 (5)
              0------1
                    / \
                (1)/   \(3)
                  /     \
                 2-------3 
                 |  (1)
             (2) |
                 |
                 4
         */
        int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        //0-vertex
        graph[0].add(new Edge(0, 1, 5));
        //1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        //2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        //3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        //4-vertex
        graph[4].add(new Edge(4, 2, 2));

        //2's neighbour
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
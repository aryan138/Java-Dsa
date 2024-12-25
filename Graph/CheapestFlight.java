package Graph;

import java.util.*;

/*
 *  There are n cities connected by some number of flights. You are given an array flights where flights[i]=[from,to,price] indicates that there is a flight.You are also given 3 integers src,dst,and k, return the cheapest with src to dst with atmost k stops. If there is no such route return -1. All values are positive.
 * 
 * 
 *                100     100                   flights=[[0,1,100],[1,2,100],[0,2,500]]
 *             0------>1------->2               src=0, dest=2, k=1
 *             |               /|\              ans=200;
 *             |       500      |
 *             ------------------
 * 
 * 
 *                     100
 *             ------------------
 *             |                |
 *             |   100     100 \|/                flights=[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
 *             1<------0------->2                 src=0, dest=3, k=1
 *             |                |                 ans=200;
 *             |   600      200 |
 *             --------->3<------
 * 
 *  Could be done without priority queue as stops inc by 1 i.e constant value so first to enter will always smaller whereas in case of cost/dist PQ is needed as they inc variablly.
 */

public class CheapestFlight {
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int src = flight[0], dst = flight[1], wt = flight[2];
            graph[src].add(new Edge(src, dst, wt));
        }
    }

    static class Info {
        int v, cost, stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        // Distance array
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // BFS Queue
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // Stop processing paths exceeding k stops
            if (curr.stops > k) {
                continue;
            }

            // Explore neighbors
            for (Edge e : graph[curr.v]) {
                int v = e.dest;
                int wt = e.wt;

                // Relax edge and add neighbor to the queue if cost improves
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        // Return the result
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 }
        };
        int src = 0, dst = 3, k = 1;

        int result = cheapestFlight(n, flights, src, dst, k);
        System.out.println(result); // Expected Output: 700
    }
}
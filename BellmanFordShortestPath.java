// import java.util.*;

// class BellmanFordShortestPath{
//     static class Edge{
//         int src, dest, weight;

//         Edge(int s, int d, int w){
//             src = s;
//             dest = d;
//             weight = w;
//         }
//     }

//     static class Graph{
//         int V, E;

//     }
// }


// // import java.util.*;

// // public class BellmanFordShortestPath {
// //     static class Edge {
// //         int src, dest, weight;

// //         Edge(int src, int dest, int weight) {
// //             this.src = src;
// //             this.dest = dest;
// //             this.weight = weight;
// //         }
// //     }

// //     static class Graph {
// //         int V, E;
// //         Edge edge[];

// //         Graph(int v, int e) {
// //             V = v;
// //             E = e;
// //             edge = new Edge[E];
// //             for (int i = 0; i < e; ++i)
// //                 edge[i] = new Edge(0, 0, 0);
// //         }

// //         void addEdge(int u, int v, int w, int i) {
// //             edge[i].src = u;
// //             edge[i].dest = v;
// //             edge[i].weight = w;
// //         }

// //         void BellmanFord(int src) {
// //             int[] dist = new int[V];
// //             Arrays.fill(dist, Integer.MAX_VALUE);
// //             dist[src] = 0;

// //             for (int i = 1; i < V; ++i) {
// //                 for (int j = 0; j < E; ++j) {
// //                     int u = edge[j].src;
// //                     int v = edge[j].dest;
// //                     int weight = edge[j].weight;
// //                     if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
// //                         dist[v] = dist[u] + weight;
// //                     }
// //                 }
// //             }

// //             // Check for negative cycles
// //             for (int j = 0; j < E; ++j) {
// //                 int u = edge[j].src;
// //                 int v = edge[j].dest;
// //                 int weight = edge[j].weight;
// //                 if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
// //                     System.out.println("Graph contains negative weight cycle");
// //                     return;
// //                 }
// //             }

// //             printDistances(dist);
// //         }

// //         void printDistances(int[] dist) {
// //             System.out.println("Vertex \t Distance from Source");
// //             for (int i = 0; i < V; ++i)
// //                 System.out.println(i + "\t\t" + dist[i]);
// //         }
// //     }

// //     public static void main(String[] args) {
// //         int V = 5; // Number of vertices
// //         int E = 8; // Number of edges

// //         Graph graph = new Graph(V, E);

// //         graph.addEdge(0, 1, -1, 0);
// //         graph.addEdge(0, 2, 4, 1);
// //         graph.addEdge(1, 2, 3, 2);
// //         graph.addEdge(1, 3, 2, 3);
// //         graph.addEdge(1, 4, 2, 4);
// //         graph.addEdge(3, 2, 5, 5);
// //         graph.addEdge(3, 1, 1, 6);
// //         graph.addEdge(4, 3, -3, 7);

// //         int src = 0; // Source vertex

// //         graph.BellmanFord(src);
// //     }
// // }


import java.util.Scanner;

public class BellmanFordShortestPath {
    static void BellmanFord(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                for(int k = 0; k < V; k++){
                    if(graph[j][k] != Integer.MAX_VALUE && dist[])
                }
            }
        }

        printSolution(dist);
    }

    static void printSolution(int dist[]) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < dist.length; ++i)
            System.out.println(i + "\t\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        int graph[][] = new int[V][V];
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println("Enter the number of edges: (Input: v1 v2 weight)");
        int e = scanner.nextInt();
        for(int i = 0; i < e; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int w = scanner.nextInt();
            graph[v1][v2] = w;
            // graph[v2][v1] = w;
        }
        // System.out.println("Enter the adjacency matrix:");

        System.out.println("Enter the source vertex:");
        int src = scanner.nextInt();
        scanner.close();

        BellmanFord(graph, src);
    }
}

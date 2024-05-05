// 5
// 6
// 0 1
// 0 2
// 1 2 
// 1 3
// 2 4
// 3 4


import java.util.*;

// There is no need for weight actually

public class BFS{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int num = sc.nextInt();
        int mat[][] = new int[num][num];
        System.out.println("Enter number of edges: ");
        int edges = sc.nextInt();
        for(int i = 0; i < num; i++){
            Arrays.fill(mat[i], 0);
        }

        System.out.println("Input: vertex1 vertex2");

        // // For unidirected graph
        // for(int i = 0; i < edges; i ++){ // Input vertex1 vertex2 weight
        //     int v1 = sc.nextInt();
        //     int v2 = sc.nextInt();
        //     // int w = sc.nextInt();
        //     // mat[v1][v2] = w;
        //     mat[v1][v2] = 1;
        // }
        // For bidirected graph
        for(int i = 0; i < edges; i++){ // Input vertex1 vertex2 weight
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            // int w = sc.nextInt();
            // mat[v1][v2] = w;
            if(v1 >= num || v2 >= num){
                System.out.println("Vertex value is overflowing. Try again");
                i--;
            }
            else{
                mat[v1][v2] = 1;
                mat[v2][v1] = 1;
            }
        }

        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

        // BFS
        LinkedList<Integer> visited = new LinkedList<Integer>();
        // int order[] = new int [num];
        // int nv[] = new int[num];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        System.out.println("Enter starting node: ");
        int s = sc.nextInt();
        
        queue.add(s);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            visited.add(curr);

            for(int i = 0; i < num; i++){
                if(mat[curr][i] != 0 && !visited.contains(i) && !queue.contains(i)){
                    queue.add(i);
                }
            }
        }

        System.out.println(visited.toString());

        sc.close();
    }
}








// import java.util.*;

// public class Graph {
//     private int V;
//     private List<Integer> adj[];

//     // Create a graph
//     Graph(int v) {
//         V = v;
//         adj = new LinkedList[v];
//         for (int i = 0; i < v; ++i)
//             adj[i] = new LinkedList<Integer>(); // Specify <Integer> here
//     }

//     // Add edges to the graph
//     void addEdge(int v, int w) {
//         adj[v].add(w);
//     }

//     // BFS algorithm
//     void BFS(int s) {
//         boolean visited[] = new boolean[V];
//         LinkedList<Integer> queue = new LinkedList<Integer>(); // Specify <Integer> here
//         visited[s] = true;
//         queue.add(s);
//         while (queue.size() != 0) {
//             s = queue.poll();
//             System.out.print(s + " ");
//             Iterator<Integer> i = adj[s].listIterator();
//             while (i.hasNext()) {
//                 int n = i.next();
//                 if (!visited[n]) {
//                     visited[n] = true;
//                     queue.add(n);
//                 }
//             }
//         }
//     }

//     public static void main(String args[]) {
//         Graph g = new Graph(4);

//         g.addEdge(0, 1);
//         g.addEdge(0, 2);
//         g.addEdge(1, 2);
//         g.addEdge(2, 0);
//         g.addEdge(2, 3);
//         g.addEdge(3, 3);

//         System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

//         g.BFS(2);
//     }
// }

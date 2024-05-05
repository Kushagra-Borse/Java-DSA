import java.util.*;

public class DFS {
    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int edge = sc.nextInt();

        int mat[][] = new int [num][num];

        for(int i = 0; i < num; i++){
            for(int j = 0; j  < num; j++){
                mat[i][j] = 0;
            }
        }

        for(int i = 0; i < edge; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            if (v1 >= num || v2 >= num) {
                System.out.println("Vertex value is overflowing. Try again");
                i--;
            } else {
                mat[v1][v2] = 1;
                mat[v2][v1] = 1;
            }
        }

        for(int i = 0;i < num; i++){
            for(int j = 0; j< num; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
        int s = sc.nextInt();

        // DFS
        Stack <Integer> stack = new Stack<Integer>();
        LinkedList<Integer> visited = new LinkedList<Integer>();
        // visited.add(s);
        stack.push(s);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            visited.add(curr);
            // if(!visited.contains(curr)){

                for(int i = num-1; i >= 0 ; i--){
                    if(mat[curr][i] == 1 && !visited.contains(i) && !stack.contains(i)){
                        stack.push(i);
                    }
                }
                // System.out.println(curr);
            // }
        }

        // while (!stack.isEmpty()) {
        //     int v = stack.pop();

        //     if (!visited.contains(v)) {
        //         System.out.print(v + " ");
        //         // visited[v] = true;
                
        //         for (int i = 0; i < num; i++) {
        //             if (mat[v][i] == 1 && !visited.contains(i)) {
        //                 stack.push(i);
        //             }
        //         }
        //     }
        // }
        System.out.println(visited.toString());
        sc.close();
    }
}

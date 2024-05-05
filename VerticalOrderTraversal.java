import java.util.*;

public class VerticalOrderTraversal{
    static class Node{
        int data;
        Node left, right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static void verticalOrderTraversal(int lis[]){
        // First convert it into graph
        Node root = new Node(lis[0]);

        list_to_tree(root, lis);

        int minMax [] = new int[2];
        finding_hd(root, minMax, 0);
        System.out.println("Min: " + minMax[0] + " Max: " + minMax[1]);

        System.out.println("Printing Vertical Order");
        
        for(int line = minMax[0]; line <= minMax[1]; line++){
            System.out.print(line + ": ");
            printing_vertical_order(root, line, 0);
            System.out.println("");
        }
    }

    public static void list_to_tree(Node root, int[] lis){
        if(root == null){
            return;
        }

        int len = lis.length;
        LinkedList <Node> queue = new LinkedList<Node>();
        queue.add(root);

        int i = 1;
        // Level order traversal to graph
        System.out.println("Making the tree");
        while(!queue.isEmpty() && i < lis.length){
            Node curr = queue.poll();
            if(lis[i] != 'N'){
                Node temp = new Node (lis[i]);
                queue.add(temp);
                curr.left = temp;
            }
            // if(lis[i] == 'N'){
            //     Node temp = new Node (-1);
            //     queue.add(temp);
            //     curr.left = temp;
            // }
            i++;
            if(i < lis.length && lis[i] != 'N'){
                Node temp = new Node(lis[i]);
                queue.add(temp);
                curr.right = temp;
            }
            // if(i < lis.length && lis[i] == 'N'){
            //     Node temp = new Node(-1);
            //     queue.add(temp);
            //     curr.right = temp;
            // }
            i++;

            // for(int i = 1; i < len; i = i + 2){
            //     if(lis[i] != 'N'){
            //         root.left = new Node(lis[i]);
            //     }
                
            //     if(lis[i+1] != 'N'){
            //         root.right = new Node(lis[i+1]);
            //     }
                
            //     root = root.left;
            // }
        }
        printTree(root);
    }

    public static void finding_hd(Node root, int [] minMax, int hd){
        if(root == null){
            return;
        }
        minMax[0] = Math.min(minMax[0], hd);
        minMax[1] = Math.max(minMax[1], hd);

        if(root.left != null){
            finding_hd(root.left, minMax, hd-1);
        }
        if(root.right != null){
            finding_hd(root.right, minMax, hd+1);
        }
    }

    public static void printing_vertical_order(Node root, int line, int hd){
        if(root == null){
            return;
        }
        // System.out.print(i + ": ");
        if(hd == line){
            System.out.print(root.data + " ");
        }

        printing_vertical_order(root.left, line, hd-1);
        printing_vertical_order(root.right, line, hd+1);
    }

    public static void printTree(Node root) {
        System.out.println("Printing the tree");
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        if(root == null){
            return;
        }
        LinkedList<Node> visited = new LinkedList<Node>();
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
            visited.add(curr);

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String lis0[] = str.split(" ");
        int lis [] = new int[lis0.length];

        for(int i = 0; i < lis0.length; i++){
            if(lis0[i].toCharArray()[0] == 'N'){
                lis[i] = 'N';
            }
            else{
                lis[i] = Integer.parseInt(lis0[i]);
            }
        }

        verticalOrderTraversal(lis);
        sc.close();
    }
}



// import java.util.*;

// public class VerticalOrderTraversal {
//     static class Node {
//         int data;
//         Node left, right;

//         Node(int item) {
//             data = item;
//             left = right = null;
//         }
//     }

//     static Node build(String s[]) {
//         if (s.length == 0 || s[0].equals("N"))
//             return null;
        
//         int lis[] = new int[s.length];
//         for(int i = 0; i < lis.length; i++){
//             lis[i] = Integer.parseInt(s[i]);
//         }

//         Node root = new Node(lis[0]);
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
    
//         for (int i = 1; i < s.length; i += 2) {
//             Node curr = q.poll();
//             if (!s[i].equals("N")) {
//                 curr.left = new Node(lis[i]);
//                 q.add(curr.left);
//             }
//             if (i + 1 < s.length && !s[i + 1].equals("N")) {
//                 curr.right = new Node(lis[i+1]);
//                 q.add(curr.right);
//             }
//         }
//         return root;
//     }
    

//     static void verticalOrder(Node root) {
//         if (root == null)
//             return;

//         // Find the minimum and maximum horizontal distances from the root
//         int[] minMax = new int[2];
//         findMinMax(root, minMax, 0);
//         System.out.println(minMax[0] + " sdfdsc " + minMax[1]);

//         // Iterate through all possible horizontal distances and print nodes
//         for (int line = minMax[0]; line <= minMax[1]; line++) {
//             printVerticalLine(root, line, 0);
//             System.out.println();
//         }
//     }

//     static void findMinMax(Node root, int[] minMax, int hd) {
//         if (root == null)
//             return;

//         // Update minimum and maximum horizontal distances
//         minMax[0] = Math.min(minMax[0], hd);
//         minMax[1] = Math.max(minMax[1], hd);

//         // Recur for left and right subtrees
//         findMinMax(root.left, minMax, hd - 1);
//         findMinMax(root.right, minMax, hd + 1);
//     }

//     static void printVerticalLine(Node root, int line, int hd) {
//         if (root == null)
//             return;

//         // Print nodes at the current horizontal distance
//         if (hd == line)
//             System.out.print(root.data + " ");

//         // Recur for left and right subtrees
//         printVerticalLine(root.left, line, hd - 1);
//         printVerticalLine(root.right, line, hd + 1);
//     }

//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter level order traversal string (separated by space):");
//         String input = sc.nextLine();
//         String[] treeArray = input.split("\\s+");

//         Node root = build(treeArray);

//         System.out.println("Vertical order traversal:");
//         verticalOrder(root);

//         sc.close();
//         // Node root = new Node(1);
//         // root.left = new Node(2);
//         // root.right = new Node(3);
//         // root.left.left = new Node(4);
//         // root.left.right = new Node(5);
//         // root.right.left = new Node(6);
//         // root.right.right = new Node(7);

//         // System.out.println("Vertical order traversal:");
//         // verticalOrder(root);
//     }
// }



// // // a node of a binary tree  
// // class TreeNode {
// //     // for holding value of the node
// //     int val;
// //     // for referring to the other nodes
// //     // left for the left child and right to the right child
// //     TreeNode left, right;

// //     // constructor of the class TreeNode
// //     // the construct initializes the class fields
// //     public TreeNode(int i) {
// //         val = i;
// //         right = left = null;
// //     }
// // }

// // // a class for storing the farthest value in the left as well as in the right
// // // direction from
// // // the root node
// // class Values {
// //     public int maximum;
// //     public int minimum;
// // }

// // public class VerticalOrderTraversalExample {
// //     TreeNode r;
// //     Values v = new Values();

// //     // A utility method to look for the minimum and maximum distances with respect
// //     // to
// //     // root.
// //     void findMinMaximum(TreeNode nde, Values min, Values max, int h) {
// //         // the base case
// //         if (nde == null) {
// //             return;
// //         }
// //         // Updating the minimum and maximum
// //         if (h < min.minimum) {
// //             min.minimum = h;
// //         } else if (h > max.maximum) {
// //             max.maximum = h;
// //         }
// //         // applying recursion for the right and left subtrees
// //         findMinMaximum(nde.left, min, max, h - 1);
// //         findMinMaximum(nde.right, min, max, h + 1);
// //     }

// //     // A utility method for displaying all of the nodes on the given line_num.
// //     // h is the horizontal distance of the current node by taking root as the
// //     // reference.
// //     void displayVerticalLine(TreeNode nde, int line_num, int h) {
// //         // the base case
// //         if (nde == null) {
// //             return;
// //         }
// //         // If the node is lying on the line number
// //         // print the value of that node
// //         if (h == line_num) {
// //             System.out.print(nde.val + " ");
// //         }
// //         // applying recursion for the right and left subtrees
// //         displayVerticalLine(nde.left, line_num, h - 1);
// //         displayVerticalLine(nde.right, line_num, h + 1);
// //     }

// //     // The main method that displays the given binary tree in
// //     // the vertical order
// //     void verticalOrder(TreeNode nde) {
// //         // Find min and max distances with resepect to root
// //         findMinMaximum(nde, v, v, 0);
// //         // iterating across all of the possible vertical lines beginning from
// //         // the left most line and displaying the nodes line by line
// //         for (int line_num = v.minimum; line_num <= v.maximum; line_num++) {
// //             displayVerticalLine(nde, line_num, 0);
// //             System.out.println("");
// //         }
// //     }

// //     // main method
// //     public static void main(String argvs[]) {
// //         // creating an object of the class VerticalOrderTraversalExample
// //         VerticalOrderTraversalExample tree = new VerticalOrderTraversalExample();
// //         // constructing the binary tree as shown
// //         // in the above diagram
// //         tree.r = new TreeNode(4);
// //         tree.r.left = new TreeNode(2);
// //         tree.r.right = new TreeNode(5);
// //         tree.r.left.left = new TreeNode(1);
// //         tree.r.left.right = new TreeNode(3);
// //         tree.r.right.left = new TreeNode(6);
// //         tree.r.right.right = new TreeNode(7);
// //         tree.r.right.left.right = new TreeNode(18);
// //         tree.r.right.right.right = new TreeNode(19);
// //         // print statement
// //         System.out.println("The vertical order traversal of the binary tree is :");
// //         // invoking method verticalOrder()
// //         tree.verticalOrder(tree.r);
// //     }
// // }
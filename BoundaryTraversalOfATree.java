import java.util.*;

//Only completed one part

public class BoundaryTraversalOfATree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] arg) {
        // First doing with level order tree input
        System.out.println("First doing woth level order tree input");
        // levelOrderTraversal();

        // Now doing with a proper tree
        System.out.println("\nNow doing with a proper tree");
        treeApproach();
    }

    public static void levelOrderTraversal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your level order tree input : ");
        String str = sc.nextLine();
        String[] lis0 = str.split(" ");
        int[] lis = new int[lis0.length];
        for (int i = 0; i < lis0.length; i++) {
            lis[i] = Integer.parseInt(lis0[i]);
        }

        System.out.println("Boundary traversal: ");
        // First only the left side
        System.out.println("First the left side nodes");
        int j = 0;
        for (int i = 0; i < lis0.length; i = (int) Math.pow(2, j) - 1) {
            System.out.print(lis[i] + " ");
            j++;
        }

        // Secondly the leaf nodes
        System.out.println("\nNow the leaf nodes");
        // Finding the level of the tree
        // j is the final level
        for (int i = (int) Math.pow(2, j - 1); i < lis0.length; i++) {
            System.out.print(lis[i] + " ");
        }

        // Thirdly only the right side
        System.out.println("\nFinally the third side nodes");
        for (int i = (int) Math.pow(2, j - 1) - 2; i > 1; i = (int) Math.pow(2, j - 1) - 2) {
            System.out.print(lis[i] + " ");
            j--;
        }

        System.out.println("\nFinal answer : ");

        j = 0;
        for (int i = 0; i < lis0.length; i = (int) Math.pow(2, j) - 1) {
            System.out.print(lis[i] + " ");
            j++;
        }
        for (int i = (int) Math.pow(2, j - 1); i < lis0.length; i++) {
            System.out.print(lis[i] + " ");
        }
        for (int i = (int) Math.pow(2, j - 1) - 2; i > 1; i = (int) Math.pow(2, j - 1) - 2) {
            System.out.print(lis[i] + " ");
            j--;
        }
    }

    public static void treeApproach() {
        Scanner sc = new Scanner(System.in);
        // int data;
        // System.out.println("Enter the number of nodes you are going to input: ");
        // int len = sc.nextInt();
        // Node tree = new Node(0);
        // System.out.println("Enter the nodes one by one");
        // Node curr = tree;
        // for(int i = 0 ; i < len; i++){
        // curr.right
        // }
        Node tree = new Node(8);
        tree.right = new Node(10);
        tree.left = new Node(3);
        tree.left.left = new Node(1);
        tree.left.right = new Node(6);
        tree.left.right.left = new Node(4);
        tree.left.right.right = new Node(7);
        tree.right.right = new Node(14);
        tree.right.right.left = new Node(13);

        boundaryTraversal(tree);
    }

    // public static void printLeaves(Node root) {
    //     if (root.left != null) {
    //         printLeaves(root);
    //     }
    //     if (root.left == null && root.right == null) {
    //         System.out.print(root.data + " ");
    //     }
    //     if (root.right != null) {
    //         printLeaves(root);
    //     }
    // }

    // public static void printLeaves(Node root) {
    //     if (root == null) {
    //         return;
    //     }
    
    //     Stack<Node> stack = new Stack<>();
    //     stack.push(root);
    
    //     while (!stack.isEmpty()) {
    //         Node node = stack.pop();
    //         if (node.left == null && node.right == null) {
    //             System.out.print(node.data + " ");
    //         }
    //         if (node.right != null) {
    //             stack.push(node.right);
    //         }
    //         if (node.left != null) {
    //             stack.push(node.left);
    //         }
    //     }
    // }

    static void printLeaves(Node node)
    {
        if (node == null)
            return;
 
        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }
 
    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(Node node)
    {
        if (node == null)
            return;
 
        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
 
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
 
    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(Node node)
    {
        if (node == null)
            return;
 
        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    public static void boundaryTraversal(Node node) {
        if (node == null)
            return;
 
        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }
}

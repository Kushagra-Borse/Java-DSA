// Did using arrays ;)

import java.util.*;

public class BITONIC_DLL_Sorting {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your input: ");
        String lis0 = sc.nextLine();
        lis0 = lis0.replace("  ", " ");
        String[] lis1 = lis0.split(" ");
        int lis[] = new int [lis1.length];

        for(int i = 0; i < lis.length; i++){
            lis[i] = Integer.parseInt(lis1[i]);
        }
        
        Node dll = new Node(lis[0]);
        Node curr = dll;
        for(int i = 1; i < lis.length; i++){
            // curr.next = new Node(lis[i]);
            // curr = curr.next;
            addNode(curr, lis[i]);
            curr = curr.right;
        }

        printList(dll);
        printReverseList(dll);

        Arrays.sort(lis);

        for (int i = 0; i < lis.length; i++){
            System.out.print(lis[i] + " => ");
        }
        System.out.println(" ");
    }

    public static void addNode(Node node, int data){
        Node temp = new Node(data);
        node.right = temp;
        temp.left = node;
    }

    public static void printList(Node node){
        System.out.println("Printing node from head to tail");
        while(node != null){
            System.out.print("=>" + node.data);
            node = node.right;
        }
        System.out.println("");

        // System.out.println("The linked list is :");
        // System.out.print(node.data);
        // node = node.right;

        // while(node != null){
        //     System.out.print("=>" + node.data);
        //     node = node.right;
        // }
        // System.out.println("");
    }
    public static void printReverseList(Node node){
        System.out.println("Printing node from tail to head i.e. in reverse order");
        while(node.right != null){
            node = node.right;
        }
        while(node != null){
            System.out.print("=>" + node.data);
            node = node.left;
        }
        System.out.println("");
    }
}

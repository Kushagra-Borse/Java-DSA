import java.util.Arrays;
import java.util.Scanner;

class LoopDetection{
    
    static class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your linked list");

        String str = sc.nextLine();
        
        String lis[] = str.split(" ");

        int lis1 [] = new int [lis.length];

        for(int i = 0; i < lis1.length; i++){
            lis1[i] = Integer.parseInt(lis[i]);
        }

        System.out.println(Arrays.toString(lis1));

        Node LL = new Node(lis1[0]);
        Node curr = LL;
        for(int i = 1; i < lis.length; i++){
            Node temp = new Node(lis1[i]);
            curr.next = temp;
            curr = curr.next;
        }

        
        // curr.next = LL.next.next;
        curr.next = LL;
        
        // Now the real code starts
        Node slow = LL;
        Node fast = LL;
        if(LL.next.next != null){
            fast = LL.next.next;
        }
        else{
            System.out.println("Cannot man!!!!!!!!!!");
        }
        
        
        int bool = 0;
        
        // while(slow != fast && fast.next.next != null && slow.next != null){
        while(fast.next.next != null && slow.next != null){
            if(slow == fast){
                bool = 1;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(bool == 1){
            System.out.println("The loop was detected");
        }
        else{
            System.out.println("Loop isn't detected!");
            PrintLinkedList(LL);
        }
    }

    public static void PrintLinkedList(Node LL){
        System.out.println("The linked list is :");
        System.out.print(LL.data);
        LL = LL.next;

        while(LL.next != null){
            System.out.print("=>" + LL.data);
            LL = LL.next;
        }
        System.out.println("");
    }
}
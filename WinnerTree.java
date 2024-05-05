import java.util.*;

class Node {
    int data;
    Node left, right;
}

public class WinnerTree {
    static Node createNode(int data) {
        Node t = new Node();
        t.left = t.right = null;
        t.data = data;
        return t;
    }

    static void traverseHeight(Node root, int[] arr, int[] res) {
        if (root == null || (root.left == null && root.left == null))
            return;
        if (res[0] > arr[root.left.data] && root.left.data != root.data) {
            res[0] = arr[root.left.data];
            traverseHeight(root.right, arr, res);
        } else if (res[0] > arr[root.right.data] && root.right.data != root.data) {
            res[0] = arr[root.right.data];
            traverseHeight(root.left, arr, res);
        }
    }

    static void findSecondMin(int[] arr, int n) {
        List<Node> li = new LinkedList<>();
        Node root = null;
        for (int i = 0; i < n; i += 2) {
            Node t1 = createNode(i);
            Node t2 = null;
            if (i + 1 < n) {
                t2 = createNode(i + 1);
                root = (arr[i] < arr[i + 1]) ? createNode(i) : createNode(i + 1);
                root.left = t1;
                root.right = t2;
                li.add(root);
            } else
                li.add(t1);
        }
        int lsize = li.size();
        while (lsize != 1) {
            int last = (lsize & 1) == 1 ? lsize - 2 : lsize - 1;
            for (int i = 0; i < last; i += 2) {
                Node f1 = li.remove(0);
                Node f2 = li.remove(0);
                root = (arr[f1.data] < arr[f2.data]) ? createNode(f1.data) : createNode(f2.data);
                root.left = f1;
                root.right = f2;
                li.add(root);
            }
            if ((lsize & 1) == 1) {
                li.add(li.get(0));
                li.remove(0);
            }
            lsize = li.size();
        }
        int[] res = { Integer.MAX_VALUE };
        traverseHeight(root, arr, res);
        System.out.println("Minimum: " + arr[root.data] + ", Second minimum: " + res[0]);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        findSecondMin(arr, n);

    }
}

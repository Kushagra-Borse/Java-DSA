    import java.util.Stack;

    public class RecoverBinarySearchTree {
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
                left = null;
                right = null;
            }
        }

        public void recoverTree(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;
            TreeNode lastProcessed = null;
            TreeNode[] swapped = new TreeNode[2];
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                if (lastProcessed != null && lastProcessed.val > current.val) {
                    if (swapped[0] == null) {
                        swapped[0] = lastProcessed;
                        swapped[1] = current;
                    } else {
                        swapped[1] = current;
                        break;
                    }
                }
                lastProcessed = current;
                current = current.right;
            }
            int temp = swapped[0].val;
            swapped[0].val = swapped[1].val;
            swapped[1].val = temp;
        }

        static void printInorder(TreeNode node) {
            if (node == null)
                return;
            printInorder(node.left);
            System.out.print(" " + node.val);
            printInorder(node.right);
        }

        public static void main(String[] args) {
            // Create your binary tree and call methods here
            TreeNode root = new TreeNode(8);
            root.left = new TreeNode(6);
            root.right = new TreeNode(12);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(10);

            RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
            tree.recoverTree(root);
            printInorder(root);
        }
    }

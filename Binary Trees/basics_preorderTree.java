import java.util.*;

public class basics_preorderTree {// O(n)
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node builtTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = builtTree(nodes);
            newNode.right = builtTree(nodes);
            return newNode;
        }

        public void preorder(Node root) {// O(n )
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) {// O(n )
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void postorder(Node root) {// O(n )
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {// O(n)
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.levelOrder(root);
    }

}

// public static Node build(List<Integer> v) {
// if (v.isEmpty()) {
// return null;
// }

// Queue<Node> q = new LinkedList<>();
// Node root = new Node(v.get(0));
// q.add(root);
// int i;
// for (i = 1; i < v.size(); i += 2) {
// Node current = q.poll();
// if (v.get(i) != -1) {
// current.left = new Node(v.get(i));
// q.add(current.left);
// }
// if (i + 1 < v.size() && v.get(i + 1) != -1) {
// current.right = new Node(v.get(i + 1));
// q.add(current.right);
// }
// }
// return root;
// }

// Queue<Node> q = new LinkedList<>();
// q.add(root);
// while(!q.isEmpty()){
// Node temp1=q.poll();
// if(temp1.left==null){
// temp1.left=new Node(data);
// break;
// }
// else{
// q.add(temp1.left);
// }
// if(temp1.right==null){
// temp1.right=new Node(data);
// break;
// }
// else{
// q.add(temp1.right);
// }
// }
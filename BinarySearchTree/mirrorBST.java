package BinarySearchTree;

public class mirrorBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            //left subtree
            root.left=insert(root.left,val);
        }
        else{
            //right subtree
            root.right=insert(root.right,val);
        }
        return root;

    }
    public static void inorder(Node root){//O(n )
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftmirror=createMirror(root.left);
        Node rightmirror=createMirror(root.right);
        root.left=rightmirror;
        root.right=leftmirror;
        return root;
    }
    public static void preorder(Node root){//O(n )
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,13};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        root=createMirror(root);
        preorder(root);
    }
}

public class diameter {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        } 
    }
    public static int height(Node root){//o(n)
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int Diameter(Node root){//o(n^2)
        if(root==null){
            return 0;
        }
        int ld=Diameter(root.left);
        int lh=height(root.left);
        int rd=Diameter(root.right);
        int rh=height(root.right);
        int selfDiameter=lh+rh+1;
        return Math.max(Math.max(ld,rd),selfDiameter);    
    }
    static class Info{
        int dia;
        int ht;
        public Info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        } 
    }
    public static Info betterDiameter(Node root){//o(n)
        if(root==null){
            return new Info(0,0);
        }
        Info linfo=betterDiameter(root.left);
        Info rinfo=betterDiameter(root.right);
        int dia=Math.max(Math.max(linfo.dia,rinfo.dia),linfo.ht+rinfo.ht+1);
        int ht=Math.max(linfo.ht,rinfo.ht)+1;
        return new Info(dia,ht);    
    }
    public static void main(String[] args) {
        /*
                       1
                      / \
                     2   3
                    / \ / \
                   4   56  7
        */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(Diameter(root));
        System.out.println(betterDiameter(root).dia);
    }
}

public class search {
    public static class Node{
        int data;
        Node next; 

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data){//O(1)
        //Create a new Node
        Node newNode= new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        //newNode next=head
        newNode.next=head;
        //head=newNode
        head=newNode;
    }
    public int itrSearch(int key){//O(n)
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key)
            return i;
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int recHelper(Node head,int key){//O(n)
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=recHelper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;

    }
    public int recSearch(int key){//O(n)
        return recHelper(head, key);
    }
    public static void main(String[] args) {
        search ll= new search();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        System.out.println(ll.itrSearch(9));
        System.out.println(ll.itrSearch(3));
        System.out.println(ll.recSearch(1));
    }
}

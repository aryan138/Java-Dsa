public class doubly_ll {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){//O(1)
        //Create a new Node
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //newNode next=head
        newNode.next=head;
        head.prev=newNode;
        //head=newNode
        head=newNode;
    }
    public void print(){//O(n)
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public void rev(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        doubly_ll dll=new doubly_ll();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        System.out.println(size);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.rev();
        dll.print();
        System.out.println(size);
    }
}

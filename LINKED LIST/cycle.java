public class cycle {
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
    public boolean isCycle(){
        Node slow=head;
        Node fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        cycle ll= new cycle();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        head.next.next.next=head;
        System.out.println(ll.isCycle());
    }
}

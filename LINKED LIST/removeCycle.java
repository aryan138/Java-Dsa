public class removeCycle {
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
    public static boolean isCycle(){
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
    public static void remCycle(){
        //detect cycle
        Node slow=head;
        Node fast= head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle= true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null;//last node
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //remove cycle->last.next=null
        prev.next=null;
    }
    public static void main(String[] args) {
        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        System.out.println(isCycle());
        remCycle();
        System.out.println(isCycle());
    }
}

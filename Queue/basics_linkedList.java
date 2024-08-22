//O(1)

package Queue;

public class basics_linkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class queuell{
        static Node head=null; 
        static Node tail=null; 
        public boolean isEmpty(){
            return head==null&&tail==null;
        }
        public void add(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public int remove(){//O(1)
            if(isEmpty()){
                System.out.println("queuell is empty");
                return -1;
            }
            int front =head.data;
            //single element
            if(tail==head){
                tail=head=null;
            }
            else{
                head=head.next;
            }
            return front;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("queuell is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        queuell q= new queuell();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

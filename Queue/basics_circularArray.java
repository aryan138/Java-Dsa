package Queue;

public class basics_circularArray {
    static class queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;//new 
        queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }
        public  boolean isEmpty(){
            return rear==-1&&front==-1;
        }
        public  boolean isFull(){//new
            return (rear+1)%size==front;
        }
        public  void add(int data){
            if(isFull()){//new
                System.out.println("queue is full");
                return;
            }
            if(front==-1){//new
                front=0;
            }
            rear=(rear+1)%size;//new
            arr[rear]=data;
        }
        public  int remove(){//O(1)
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int result=arr[front];
            //last element remove
            if(rear==front){
                rear=front=-1;
            }
            else{
                front=(front+1)%size;
            }
            return result;
        }
        public  int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        queue q= new queue(5);
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

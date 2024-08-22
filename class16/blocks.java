package class16;
//In java global variables are known as instance variables
public class blocks {
    static int i,j,k;
    @SuppressWarnings("static-access")
    blocks(int i,int j,int k){
        this.i=i;
        this.j=j;
        this.k=k;
        // System.out.println("Constructor Invoked");
    }
    static void method(){
        System.out.println(i+" "+j+" "+k);
    }
    {
        System.out.println("Initializer block invoked");
    }
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        blocks b=new blocks(1,2,3);
        method();
        // System.out.println("Main Block");
    }
}

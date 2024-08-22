package class16;
class A{
    void demo(){
        System.out.println("hi!");
    }
}
public class oops {
    String name;
    int rollno;
    int age;
    void info(){
        System.out.println("Name :"+name);
        System.out.println("Rollno :"+rollno);
        System.out.println("age :"+age);
    }
    public static void main(String[] args) {
        oops o=new oops();
        A a=new A();
        a.demo();
        o.name="Aryan";
        o.rollno=1383;
        o.age=21;
        o.info();
    }
}

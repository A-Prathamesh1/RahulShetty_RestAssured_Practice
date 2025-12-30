package coding_basics.OOP.plymorphism.runTimeDemo;

public class RunTimePolyDemo {
    public static void main(String[] args) {
        B b = new B();
        b.show(); // from B show
        System.out.println("************");
        A a = new A();
        a.show(); // from A show
        System.out.println("************");
        A c = new B();
        c.show(); // from B show

    }
}

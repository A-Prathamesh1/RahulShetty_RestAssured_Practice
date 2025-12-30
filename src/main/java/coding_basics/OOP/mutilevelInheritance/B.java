package coding_basics.OOP.mutilevelInheritance;

public class B extends A {
    public void display() {
        System.out.println("display from B");
        A a = new A();
        a.reveal();
    }
}

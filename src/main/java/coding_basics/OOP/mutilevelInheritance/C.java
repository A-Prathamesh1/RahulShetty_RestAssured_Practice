package coding_basics.OOP.mutilevelInheritance;

public class C extends B {
    public void show() {
        System.out.println("show from C");
        C c = new C();
        c.display();
    }
}

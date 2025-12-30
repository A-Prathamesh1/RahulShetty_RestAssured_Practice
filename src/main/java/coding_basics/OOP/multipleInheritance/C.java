package coding_basics.OOP.multipleInheritance;

public class C implements A, B {
    //    @Override
    public void show() {
        System.out.println("show from interface A");
    }

    //    @Override
    public void display() {
        System.out.println("display from interface B");
    }
}

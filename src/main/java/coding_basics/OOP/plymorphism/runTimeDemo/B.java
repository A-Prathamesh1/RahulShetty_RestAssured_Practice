package coding_basics.OOP.plymorphism.runTimeDemo;

public class B extends A {
    public B() {
        System.out.println("constructor B called");
    }

    @Override
    public void show() {
        System.out.println("from B show");
//        super.show();
    }
}

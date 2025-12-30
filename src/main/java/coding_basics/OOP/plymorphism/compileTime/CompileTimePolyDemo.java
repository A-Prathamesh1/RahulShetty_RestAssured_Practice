package coding_basics.OOP.plymorphism.compileTime;

public class CompileTimePolyDemo {
    public void show(String arg) {
        System.out.println("this arg: " + arg);
    }

    public void show(String arg, int a) {
        System.out.println("plain show");
    }

    public static void main(String[] args) {
        CompileTimePolyDemo c = new CompileTimePolyDemo();
        /*
         * which method should be called decided at compile time
         * */
        c.show("something", 1);
        c.show("something");

    }
}

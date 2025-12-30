package ClassTypes.InnerClass;

public class A {
    public void show() {
        System.out.println("In A show");
    }

    static class B {
        public void show() {
            System.out.println("In B show");
        }
    }
}

class Demo {
    public static void main(String[] args) {
        // how to use inner class
        A a1 = new A();
        //A.B a = a1.new B();
        //a.show(); // since class B is a member of class A, it will be accessible only through the instance of class A,
        // unless class B is static.

        // if class B is static member of A, then it will be accessible through A
        A.B b = new A.B();
        b.show(); // B show
    }
}

public class InterFace {

    interface A {
        default void show() {
            System.out.print("a");
        }
    }

    interface B {
        default void show() {
            System.out.print("b");
        }
    }

    class C implements A, B {
        // Must override show() to resolve default method conflict
        public void show() {
            System.out.print("c");
        }
    }

    public static void main(String[] args) {
        InterFace outer = new InterFace(); // Because C is non-static
        C obj = outer.new C();             // Create inner class instance
        obj.show();                        // Output will be: c
    }
}


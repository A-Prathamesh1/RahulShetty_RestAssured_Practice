package ClassTypes.AnonymousInnerClass;

class A {
    public void show() {
        System.out.println("Inside the Anonymous show");
    }
}
// B has only 1 purpose to provide the own implementation of show
/*
class B extends A {
    public void show() { // B is implementing the own version of show,
        System.out.println("Inside B show");
    }
}*/

class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        A a = new A() {
            public void show() {
                System.out.println("Inside overridden show");
            }
        };
        a.show();
    }
}

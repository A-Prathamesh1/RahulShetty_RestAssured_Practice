package LambdaExpression;

@FunctionalInterface
interface A {
    int show(int a, int b);
}

/*class B implements A {
    @Override
    public void show() {
        System.out.println("in show B");
    }
}*/

class LambdaExpression {
    public static void main(String[] args) {
        A b = (s, a) -> s + a;
        b.show(10, 12);
    }
}

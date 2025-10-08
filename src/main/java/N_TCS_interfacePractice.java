// Online Java Compiler
// Use this editor to write, compile and run your Java code online


class N_TCS_interfacePractice implements A, B{
    @Override
    public void show() {
        A.super.show();
        B.super.show();
    }

    // @Override
    // public void show(){
    //     System.out.println("Try programiz.pro show");
    // }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        N_TCS_interfacePractice m = new N_TCS_interfacePractice();
        m.show();
    }
}
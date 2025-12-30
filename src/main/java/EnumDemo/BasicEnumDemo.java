package EnumDemo;

enum Status {
    Initialized, Running, Failed, Pending, Success;
}

public class BasicEnumDemo {
    public static void main(String[] args) {
        Status s = Status.Initialized;
        System.out.println("current status: " + s);
        System.out.println("status is declared in class: " + s.getDeclaringClass());
        Status[] s1 = Status.values();
        for (Status st : s1) {
            System.out.println(st + " name: " + st.name() + " " + st.ordinal());
        }

        switch (s) {
            case Running:
                System.out.println("running");
                break;

            case Initialized:
                System.out.println("ini");
                break;

            case Failed:
                System.out.println("Failed");
                break;

            case Success:
                System.out.println("success");
                break;
        }

        System.out.println("enum's super class is: " + s.getClass().getSuperclass());
    }
}

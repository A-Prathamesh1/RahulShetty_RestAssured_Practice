package coding_basics.Exceptions.tryWithResources;

public class MyResource implements AutoCloseable {

    public void use() {
        System.out.println("Using resource");
    }

    @Override
    public void close()  {
        throw new RuntimeException("error closing 1");
       // throw new RuntimeException("error closing 2");
    }
}

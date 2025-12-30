package coding_basics.Exceptions.tryWithResources;

public class TryWithResourcesDemo {
    public static void main(String[] args) throws Exception {
        try (MyResource rs = new MyResource()) {
            throw new Exception("Main exception");
        } catch (Exception e) {
            System.out.println("error message: " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("supressed: " + t);
            }
        }
        System.out.println("This will execute");
    }
}

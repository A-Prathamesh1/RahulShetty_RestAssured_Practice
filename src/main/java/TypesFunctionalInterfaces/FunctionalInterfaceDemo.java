package TypesFunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Consumer Interface consumes input and does not return anything
        Consumer<String> c = (s) -> System.out.println("Your name is " + s);
        c.accept("Abcd");

        // Supplier interface supplies values
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println("Random no: " + getRandom.get());

        // Predicate tests the provided value
        Predicate<String> p = (s) -> s.length() > 5;
        System.out.println("Is abcdes has length > 5: " + p.test("abcdes"));

        // Function apply function to arguments & return
        Function<String, Integer> f = (s) -> s.length();
        System.out.println("length of test is: " + f.apply("test"));

        

    }

}

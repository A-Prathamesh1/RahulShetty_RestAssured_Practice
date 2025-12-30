package LambdaExpression.MethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class User {
    String name;

    public String getName() {
        return this.name;
    }
}

public class MethodRefDemo {
    public static void main(String[] args) {
        // static method reference: refType:staticMethod
//        DoubleUnaryOperator sqrt = i -> Math.sqrt(i);
        DoubleUnaryOperator sqrt = Math::sqrt;

//        IntBinaryOperator max = (a, b) -> Integer.max(a, b);
        IntBinaryOperator max = Integer::max;


        // Unbound: methods that do not take any argument
//        Function<String, Integer> getLength = s -> s.length();
        Function<String, Integer> getLength = String::length;

//        Function<User, String> getName = u -> u.getName();
        Function<User, String> getName = User::getName;


        // Bound: Object u on which the method is called is part of syntax
        // exp::instanceMeth = exp <- something that returns an object, instanceMeth <- method defined on the instance class
        User u = new User();
        Function<User, String> getName1 = User::getName;
        String name = getName1.apply(u);


        // Constructor
//        Supplier<List<String>> s = () -> new ArrayList<>(); can be written as
        Supplier<List<String>> s = ArrayList::new;

    }
}

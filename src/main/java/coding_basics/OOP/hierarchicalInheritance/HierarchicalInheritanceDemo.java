package coding_basics.OOP.hierarchicalInheritance;

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        /*
         * Animal > Dog
         *        > Cat
         *
         * both cat & dog are inheriting the Animal class
         * */
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}

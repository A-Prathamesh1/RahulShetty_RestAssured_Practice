package coding_basics.OOP.abstraction.interfaces;

public class Tesla implements Car {
    /*
     * Implementation of applyBreaks & honk are dependent on the child classes
     * */
    @Override
    public void applyBreaks() {
        System.out.println("apply breaks");
    }

    @Override
    public void honk() {
        System.out.println("honks");
    }

    public void printPrice() {
        System.out.println(" prices: " + price);
    }
}

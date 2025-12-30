package EnumDemo;

import org.apache.commons.math3.distribution.LaplaceDistribution;

enum Laptop {
    MacB(1200), XPS(1000), Surface(800), Thinkpad;

    private int price;

    Laptop() {
        this.price = 200;
    }

    Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumClassDemo {
    public static void main(String[] args) {
        Laptop l = Laptop.MacB;
        System.out.println("Price of " + l + " is " + l.getPrice());

        for (Laptop l1 : Laptop.values()) {
            System.out.println(l1 + " has price: " + l1.getPrice());
        }
        l = Laptop.Thinkpad;
        System.out.println(l + " has price: " + l.getPrice());
    }
}

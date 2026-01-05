package JavaGenerics;

import java.io.Serializable;

public class Printer<T extends Animal> {

    T thingToPrint;

    Printer(T ThingToPrint) {
        this.thingToPrint = ThingToPrint;
    }

    public void integerPrinter() {
        thingToPrint.eat();
        System.out.println(thingToPrint);
    }


}

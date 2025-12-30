package ClassTypes.LocalClassDemo;

public class GenerateBill {
    private int billAmount = 10;

    public void calcTax() {
        class CalcTax {
            public int calc() {
                billAmount += (0.10 * billAmount);
                return billAmount;
            }
        }
        CalcTax c = new CalcTax();
        System.out.println("tax: " + c.calc());
    }

    public static void main(String[] args) {
        GenerateBill b = new GenerateBill();
        b.calcTax();
    }
}

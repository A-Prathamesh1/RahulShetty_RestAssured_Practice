package what_is_op;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = ArithmeticException.class)
    public void firstTest(){
        int i = 1/1;
        System.out.println(i);
    }
}

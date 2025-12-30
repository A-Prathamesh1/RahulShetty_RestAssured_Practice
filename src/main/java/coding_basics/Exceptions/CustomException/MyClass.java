package coding_basics.Exceptions.CustomException;

public class MyClass {
    public void method(int j) throws MyCustomException {
        int i = j;
        if (i <= 0) {
            throw new MyCustomException("custom exception since i < 0");
        }
    }
}

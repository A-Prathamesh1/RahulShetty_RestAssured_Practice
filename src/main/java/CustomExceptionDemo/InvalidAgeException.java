package CustomExceptionDemo;

public class InvalidAgeException extends Exception{
    InvalidAgeException(){
        super("Invalid age Exception");
    }
    InvalidAgeException(String m){
        super(m);
    }
}

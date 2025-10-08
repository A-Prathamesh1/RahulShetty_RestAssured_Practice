package CustomExceptionDemo;

import java.util.Scanner;

public class CustomExcepDemo {

    public static void validateAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw  new InvalidAgeException("Invalid age is less than 18: " + age);
        }else {
            System.out.println("Age is valid");
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you age: ");
        int age = sc.nextInt();
        sc.close();

        try{
            validateAge(age);
        }catch (InvalidAgeException ive){
            System.out.println("message: " + ive.getMessage());
            ive.printStackTrace();
        }
    }

}

import java.util.*;

public class MiniCalculator{

  public MiniCalculator(){

  }
  public double add(double x, double y){
    return x + y;

  }

  public double multiply(double x, double y){
    return x * y;

  }

  public double toThePowerOf(double x, double y){
    return Math.pow(x, y);

  }

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    MiniCalculator calc = new MiniCalculator();

    System.out.println("Java Calculator");
    System.out.println("-----------------------");

    System.out.println("This calculator can solve a few problems. What would you like to know?");
    System.out.println("1. Add");
    System.out.println("2. Multiply");
    System.out.println("3. Exponent");

    int operationChoice = input.nextInt();

    if(operationChoice == 1){
      System.out.println("Enter first number: ");
      double firstNum = input.nextDouble();
      System.out.println("Enter second number: ");
      double secondNum = input.nextDouble();

      System.out.println(firstNum + " plus " + secondNum + " is equal to " + calc.add(firstNum, secondNum));
    }
    if(operationChoice == 2){
      System.out.println("Enter first number: ");
      double firstNum = input.nextDouble();
      System.out.println("Enter second number: ");
      double secondNum = input.nextDouble();

      System.out.println(firstNum + " times " + secondNum + " is equal to " + calc.multiply(firstNum, secondNum));
    }
    if(operationChoice == 3){
      System.out.println("Enter base: ");
      double firstNum = input.nextDouble();
      System.out.println("Enter exponent: ");
      double secondNum = input.nextDouble();

      System.out.println(firstNum + " to the power of " + secondNum + " is equal to " + calc.toThePowerOf(firstNum, secondNum));
    }

    input.close();
  }

}

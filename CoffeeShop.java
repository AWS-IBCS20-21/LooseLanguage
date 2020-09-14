import java.util.*;

public class CoffeeShop{

  public static void main(String[] args){
    System.out.println("---------------------");
    System.out.println("Java Coffee Shop");
    System.out.println("---------------------");
    System.out.println("");

    System.out.println("Welcome to NotStarbucks, may I take your order?");

    Scanner input = new Scanner(System.in);
    String userOrder = input.nextLine();

    System.out.println("Can I have a name with that?");
    String userName = input.nextLine();

    System.out.println("One moment please...");
    System.out.println(userName + "! Your " + userOrder + " is ready.");

    input.close();



  }

}

import java.util.*;

public class FavoriteAnimal{
  String name;
  String habitat;
  int height;
  String similarAnimals;
  String specialty;

  public FavoriteAnimal(){
    name = "Acinonyx jubatus";
    habitat = "Grasslands and open plains";
    height = 3;
    similarAnimals = "lions, caracals, and cougars";
    specialty = "The cheetah is the fastest land animal";
  }

  public String returnName(){
    return name;
  }

  public String returnHabitat(){
    return habitat;
  }

  public int returnHeight(){
    return height;
  }

  public String returnSimlarAnimals(){
    return similarAnimals;
  }

  public String returnSpecialty(){
    return specialty;
  }

  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    FavoriteAnimal cheetah = new FavoriteAnimal();

    System.out.println("This Program is all about Cheetahs. What would you like to know?");
    System.out.println("1. Scientific Name");
    System.out.println("2. Habitat");
    System.out.println("3. Height");
    System.out.println("4. Similar Animals");
    System.out.println("5. What makes them special");

    int userChoice = input.nextInt();

    if(userChoice == 1){
      System.out.println(cheetah.returnName());
    }
    if(userChoice == 2){
      System.out.println(cheetah.returnHabitat());
    }
    if(userChoice == 3){
      System.out.println(cheetah.returnHeight());
    }
    if(userChoice == 4){
      System.out.println(cheetah.returnSimlarAnimals());
    }
    if(userChoice == 5){
      System.out.println(cheetah.returnSpecialty());
    }

    input.close();


  }

}

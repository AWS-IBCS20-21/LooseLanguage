import java.util.*;

public class Halloween{
  public static void main(String[] args){
    Random myR = new Random();

		// generate neighborhood matrix
		float[][] neighMatrix = new float[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				neighMatrix[i][j] = myR.nextFloat() * 10;
			}
		}

		//print neighborhood matrix
		for(int i=0; i<neighMatrix.length; i++) {
			System.out.print("Street " + (i+1) + ": {");
			for(int j=0; j<neighMatrix[i].length; j++) {
				if(j==neighMatrix[i].length-1) {
					System.out.print(neighMatrix[i][j]);
				}
				else {
				System.out.print(neighMatrix[i][j] + ", ");
				}
			}
			System.out.println("}");

		}
		System.out.println("");
		System.out.println("");



  	// find top 5 houses
		System.out.println("Welcome to the Halloween Strategizer!");
		System.out.println("Here is your top 5 houses list: ");
		System.out.println("");

		// first house
		int street= 0;
		int house = 0;
		float maxGenerosity = neighMatrix[0][0];
		for (int i = 0; i < neighMatrix.length; i++) {
			for (int j = 0; j < neighMatrix[i].length; j++) {
				if (neighMatrix[i][j] > maxGenerosity) {
					maxGenerosity = neighMatrix[i][j];
					street = i+1;
					house = j+1;
				}
			}

		}
		System.out.println("1. House #" + house + " on Street #" + street);
		float gen1 = maxGenerosity;

		// second house
		maxGenerosity = neighMatrix[0][0];
		for (int i = 0; i < neighMatrix.length; i++) {
			for (int j = 0; j < neighMatrix[i].length; j++) {
				if (neighMatrix[i][j] > maxGenerosity && (neighMatrix[i][j] != gen1)) {
					maxGenerosity = neighMatrix[i][j];
					street = i+1;
					house = j+1;
				}
			}

		}
		System.out.println("2. House #" + house + " on Street #" + street);
		float gen2 = maxGenerosity;


		// third house
		maxGenerosity = neighMatrix[0][0];
		for (int i = 0; i < neighMatrix.length; i++) {
			for (int j = 0; j < neighMatrix[i].length; j++) {
				if (neighMatrix[i][j] > maxGenerosity && (neighMatrix[i][j] != gen1) && (neighMatrix[i][j] != gen2)) {
					maxGenerosity = neighMatrix[i][j];
					street = i+1;
					house = j+1;
				}
			}

		}
		System.out.println("3. House #" + house + " on Street #" + street);
		float gen3 = maxGenerosity;


		//fourth house
		maxGenerosity = neighMatrix[0][0];
		for (int i = 0; i < neighMatrix.length; i++) {
			for (int j = 0; j < neighMatrix[i].length; j++) {
				if (neighMatrix[i][j] > maxGenerosity && (neighMatrix[i][j] != gen1) && (neighMatrix[i][j] != gen2) && (neighMatrix[i][j] != gen3)) {
					maxGenerosity = neighMatrix[i][j];
					street = i+1;
					house = j+1;
				}
			}

		}
		System.out.println("4. House #" + house + " on Street #" + street);
		float gen4 = maxGenerosity;


		//fifth house
		maxGenerosity = neighMatrix[0][0];
		for (int i = 0; i < neighMatrix.length; i++) {
			for (int j = 0; j < neighMatrix[i].length; j++) {
				if (neighMatrix[i][j] > maxGenerosity && (neighMatrix[i][j] != gen1) && (neighMatrix[i][j] != gen2) && (neighMatrix[i][j] != gen3) && (neighMatrix[i][j] != gen4)) {
					maxGenerosity = neighMatrix[i][j];
					street = i+1;
					house = j+1;
				}
			}

		}
		System.out.println("5. House #" + house + " on Street #" + street);
  }


}

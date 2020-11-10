import java.util.*;

public class BubbleSort{

  public static int[] randomIntArray(int x){

    int[] arr = new int[x];
    for(int i=0; i<arr.length; i++){
      arr[i] = (int)(Math.random()*100);
    }
    return arr;
  }

  public static int[] bubbleSort(int[] arr){

    for(int i=1; i<arr.length; i++){
      for(int j=0; j<arr.length-i; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args){
    //long startTime = System.currentTimeMillis();
    long startTime = System.nanoTime();

    int[] myArr = bubbleSort(randomIntArray(10));
    for(int i=0; i<myArr.length; i++){
      System.out.print(myArr[i] + " ");
    }
    //long endTime = System.currentTimeMillis();
    long endTime = System.nanoTime();
    System.out.println("\nTotal Time: " + (endTime - startTime)/(Math.pow(10.0, 9.0)) + " seconds");
  }
}

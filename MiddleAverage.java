public class MiddleAverage{

  public static double middleAverage(int[] a){
    int b = a.length/4;
    int sum = 0;


    for(int i=b; i<a.length - b; i++){
      sum = sum + a[i];
    }
     double avg = (double)sum/(a.length-(2*b));
     return avg;
  }

  public static void main(String[] args){
    int[] a = {1, 2, 3, 4};
    System.out.println(middleAverage(a));
  }
}

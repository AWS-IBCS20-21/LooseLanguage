import java.io.*;
import java.util.*;

public class FileParser{

  public static void main(String[] args){

    StringBuilder fullText = new StringBuilder();

    try{
      File f = new File("huckleberry.txt");
      Scanner fReader = new Scanner(f);

      while(fReader.hasNextLine()){
        fullText.append(fReader.nextLine());
      }

    } catch(FileNotFoundException e){
      System.out.println("File not found");
      e.printStackTrace();
    }

    //prints out total number of characters
    //System.out.println("Number of characters: " + fullText.length());

    String fullS = fullText.toString();


    String[] words = fullS.split(" ");

    /*for(int j=0; j<words.length; j++){
      words[j].replace('.',' ');
      words[j].replace(',',' ');
      words[j].replace('-',' ');
    }*/

    //prints number of words
    //System.out.println("Number of words: " + words.length);

    //prints average word length
    System.out.println("Average word length: " + fullText.length()/words.length + " characters");


//finds and prints longest "word"
    int max = 0;
    for(int i=1; i<words.length; i++){
      if(words[i].length() > words[max].length()){
        max = i;
      }
    }
    System.out.println("Longest word: " + words[max]);
    //System.out.println("Length: " + words[max].length());

//finds most common "word"
    ArrayList<String> uniqwords = new ArrayList<String>();
    ArrayList<Integer> freq = new ArrayList<Integer>();
    int maxFreq = 0;
    int maxIndex = 0;

    for(String word : words){
      int index = uniqwords.indexOf(word);
      if(index == -1){
        uniqwords.add(word);
        freq.add(1);
        index = uniqwords.size() - 1;
      }else{
        freq.set(index, freq.get(index)+1);
      }
      if(maxFreq < freq.get(index)){
        maxFreq = freq.get(index);
        maxIndex = index;
      }
    }
    System.out.println("Most common word: " + uniqwords.get(maxIndex));


  }


}

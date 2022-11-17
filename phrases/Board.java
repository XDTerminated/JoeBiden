import java.util.Scanner;
import java.io.File;
public class Board {


  private static String loadPhrase() {
    String tempPhrase = "";
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try {
      
      Scanner sc = new Scanner(new File("/workspace/Joe-Biden/phrases/phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try {
      int count = 0;
      Scanner sc = new Scanner(new File("/workspace/Joe-Biden/phrases/phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    return tempPhrase;
  }

  public static String getLines(String phrase) {
    String lines = "";
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.substring(i, i+1).equals(" ")) {
        lines+=" ";
      } else {
        lines+="-";
      }
    }

    return lines;
  }

  public static String getPhrase() {
    String s = loadPhrase();
    return s;
  }
}

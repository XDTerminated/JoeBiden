import java.util.*;

public class Main {
    public static void main(String[] args) { 
        
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();
        String phrase = board.getPhrase();

        String lines = board.getLines(phrase);
        
        int tries = 10;
        while (true) {
            System.out.println("Tries Left: " + tries);
            System.out.println(lines);
            String character = scanner.next();
            
            if (!phrase.contains(character)) {
                tries--;
            }

            while (phrase.contains(character)) {
                int index = phrase.indexOf(character);
                phrase = phrase.substring(0, index) + "*"
            + phrase.substring(index + 1, phrase.length());

                lines = lines.substring(0, index) + character
            + lines.substring(index + 1, lines.length());
            }

            if (tries == 0) {
                System.out.println("You lost, better luck next time");
                break;
            } else if (!lines.contains("-")) {
                System.out.println("Congratulations, you win.");
                break;
            }

        }


        scanner.close();
        
    }
}
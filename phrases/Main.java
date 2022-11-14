import java.util.*;

public class Main {
    public static void main(String[] args) { 
        
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();
        String phrase = board.getPhrase();

        String lines = board.getLines(phrase);

        System.out.println("Player 1 Name: ");
        String player1name = scanner.next();
        System.out.println("Player 2 Name: ");
        String player2name = scanner.next();

        Player player1 = new Player(player1name, 0);
        Player player2 = new Player(player2name, 0);

        
        int playerTries1 = 5;
        int playerTries2 = 5;

        int turn = 0;

        while (true) {

            if (turn == 0) {
                System.out.println("Player 1 Turn: ");
                System.out.println("Tries Left: " + playerTries1);
            } else {
                System.out.println("Player 2 Turn: ");
                System.out.println("Tries Left: " + playerTries1);
            }

            System.out.println(lines);
            String character = scanner.next();
            
            if (!phrase.contains(character)) {
                if (turn == 0) {
                    playerTries1--;
                } else {
                    playerTries2--;
                }
            }

            while (phrase.contains(character)) {
                int index = phrase.indexOf(character);
                phrase = phrase.substring(0, index) + "*"
            + phrase.substring(index + 1, phrase.length());

                lines = lines.substring(0, index) + character
            + lines.substring(index + 1, lines.length());
            }

            if (playerTries1 == 0) {
                System.out.println(player1.getPlayerName() + " loses, " + player2.getPlayerName() + " wins.");
                break;
            } else if (playerTries2 == 0) {
                System.out.println(player2.getPlayerName() + " loses, " + player1.getPlayerName() + " wins.");
                break;
            } else if (!lines.contains("-") && turn == 0) {
                System.out.println("Congratulations"  + player1.getPlayerName() + " win.");
                break;
            }

            if (turn == 0) {
                turn = 1;
            } else {
                turn = 0;
            }


        }


        scanner.close();
        
    }
}
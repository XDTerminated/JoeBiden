import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Variables
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter Player 1 name: ");
        Player player1 = new Player(scanner.next(), 0);

        System.out.println("Enter Player 2 name: ");
        Player player2 = new Player(scanner.next(), 0);

        boolean game = true;

        System.out.println("Welcome to hangman. Try to guess the word before your opponent to win!");

        // Game
        while (game) {
            String phrase = Board.getPhrase();
            String phraseGuess = "";

            for (int i = 0; i < phrase.length(); i++) {
                if (phrase.substring(i, i + 1).equals(" ")) {
                    phraseGuess = phraseGuess + " ";
                } else {
                    phraseGuess = phraseGuess + "-";
                }
            }

            int turn = rand.nextInt(2);
            System.out.println("Player " + (turn + 1) + " will go first\n\n");

            while (true) {
                if (turn == 0) {
                    System.out.println(player1.getName() + "\'s turn: ");
                } else if (turn == 1) {
                    System.out.println(player2.getName() + "\'s turn: ");
                }

                System.out.println(phraseGuess);

                System.out.println("Make a guess (If you type in multiple characters, only the first character will be considered)");

                String guess = scanner.next().substring(0, 1);

                if (phrase.contains(guess) && !guess.equals(" ")) {
                    for (int i = 0; i < phrase.length(); i++) {
                        if (phrase.substring(i, i+1).equals(guess)) {
                            phraseGuess = phraseGuess.substring(0, i) + guess + phraseGuess.substring(i + 1, phrase.length());
                        }
                    }
                } else {
                    System.out.println("That letter does not exist in the phrase.");
                    if (turn == 0) {
                        turn++;
                    } else {
                        turn--;
                    }
                }

                if (turn == 0) {
                    if (!phraseGuess.contains("-")) {
                        System.out.println("Player 1 Wins");
                        player1.setScore(player1.getScore() + 1);
                        break;
                    }
                } else if (turn == 1) {
                    if (!phraseGuess.contains("-")) {
                        System.out.println("Player 2 Wins");
                        player2.setScore(player2.getScore() + 1);
                        break;
                    }
                }
            }

            System.out.println("Would you like to play again? (1 for yes, 0 for no)");
            if (scanner.nextInt() == 0) {
                System.out.println("Final Score: \n\t" + player1.getName() + ": " + player1.getScore() + "\n\t" + player2.getName() + ": " + player2.getScore());
                break;
            }

        }

        scanner.close();

    }
}
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter player 1 name: ");
        Player player1 = new Player(scanner.next(), 0);

        System.out.println("Enter player 2 name: ");
        Player player2 = new Player(scanner.next(), 0);

        System.out.println("Welcome to Nims Game. Players take turns removing pieces from the pile. Players must take at least one piece but no more than half the size of the pile. The last player to take a piece loses.");

        Game game = new Game(rand.nextInt(10, 51), rand.nextInt(2));

        while (true) {
            if (game.getTurn() == 0) {
                System.out.println("Player 1 goes first: \n\n");
            } else {
                System.out.println("Player 2 goes first: \n\n");
            }

            while (game.getPieces() > 0) {
                if (game.getTurn() == 0) {
                    System.out.println("Player 1 turn: ");
                } else {
                    System.out.println("Player 2 turn");
                }

                System.out.println("Pieces Remaining: " + game.getPieces());

                int pieces = game.turnPlayed();


                if (game.getTurn() == 0) {
                    player1.setPieces(pieces);
                    game.setTurn(1);
                } else if (game.getTurn() == 1) {
                    player2.setPieces(pieces);
                    game.setTurn(0);
                }
            }

            if (game.getTurn() == 0) {
                System.out.println("Player 1 won!");
                System.out.println("Player 1 Pieces: " + player1.getPieces());
                System.out.println("Player 2 Pieces: " + player2.getPieces());
                player1.setScore(1);
            } else {
                System.out.println("Player 2 won!");
                System.out.println("Player 1 Pieces: " + player1.getPieces());
                System.out.println("Player 2 Pieces: " + player2.getPieces());
                player2.setScore(1);
            }

            System.out.println("Do you want to play again? (Y: Yes (Y must be capitalized), anything else no)");
            String a = scanner.next();

            if (a.equals("Y")) {
                player1.resetPieces();
                player2.resetPieces();
                game.setPieces(rand.nextInt(0, 51));
            } else {
                System.out.println("Player 1 Score: " + player1.getScore());
                System.out.println("Player 2 Score: " + player2.getScore());
                break;
            }
        }

        scanner.close();



    }
}
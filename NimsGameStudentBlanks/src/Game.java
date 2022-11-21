import java.util.*;

class Game {

    Scanner scanner = new Scanner(System.in);

    private int pieces;
    private int turn;

    Game(int pieces, int turn) {
        this.pieces = pieces;
        this.turn = turn;
    }

    public int turnPlayed() {
        System.out.println("How many pieces do you want to take out? ");

        int numOfPieces = scanner.nextInt();
        if (numOfPieces == 1) {

        } else {
            while ((numOfPieces > (int) this.pieces/2) || (numOfPieces < 1)) {
                System.out.println("Try Again: ");
                numOfPieces = scanner.nextInt();
            }
        }


        this.pieces = this.pieces - numOfPieces;
        return numOfPieces;
    }

    public int getPieces() {
        return this.pieces;
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }




    

}
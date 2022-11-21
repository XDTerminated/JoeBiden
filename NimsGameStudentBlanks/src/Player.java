class Player {
    private String name;
    private int score;
    private int pieces;

    Player(String name, int score) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces + this.pieces;
    }

    public void resetPieces() {
        this.pieces = 0;
    }

    public void setScore(int score) {
        this.score = score + this.score;
    }

    public String getName() {
        return this.name;
    }

    public int getPieces() {
        return this.pieces;
    }

    public int getScore() {
        return this.score;
    }
}
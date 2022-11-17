class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
public class Player {
    private String name; 
    private int score;

    public Player() {
        name = "John Doe";
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void move() {}
}

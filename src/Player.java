public class Player {
    //instance variables
    private String name;
    private int chips;
    private int wager;
    private int score;
    private Die die = new Die();

    //constructor
    public Player(String name, int wager) {
        this.name = name;
        this.wager = wager;
        score = 0;
        chips = 100;
    }

    //getter methods
    public String getName() {
        return name;
    }
    public int getChips() {
        return chips;
    }
    public int getWager() {
        return wager;
    }
    public int getPScore() {
        score = die.getScore();
        return score;
    }

    //setter methods
    public void setWager(int newWager) {
        wager = newWager;
    }
    public void setScore(int newScore) { score = newScore; }
    //other methods
    public void subtract(int val) {
        chips -= val;
    }
    public void add(int val) {
        chips += val;
    }

    //other methods
    public void playerRoll() {
        die.roll();
        int die1 = die.getDie1();
        int die2 = die.getDie2();
        int die3 = die.getDie3();
        System.out.println(getName() + "rolls: " + die1 + ", " + die2 + ", " + die3);

    }
    public int pWin() {
        return die.win();
    }


}

public class Banker {
    //instance variables
    private int chips;
    private int score;
    private Die die = new Die();

    //constructor
    public Banker() {
        chips = 1000;
    }
    //getter methods
    public int getBScore() {
        score = die.getScore();
        return score;
    }
    public int getBChips() {
        return chips;
    }
    //setter methods
    public void setBChips(int newChips) {
        chips = newChips;
    }


    //other methods
    public int bWin() {
        return die.win();
    }
    public void subtract(int val) {
        chips -= val;
    } //subtracts chips from Banker

    public void add(int val) {
        chips += val;
    } //adds chips to Banker

    public void bankerRoll() {
        die.roll();
        int die1 = die.getDie1();
        int die2 = die.getDie2();
        int die3 = die.getDie3();
        System.out.println("Banker rolls: " + die1 + ", " + die2 + ", " + die3);

    }
}



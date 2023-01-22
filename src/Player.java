public class Player {
    //instance variables
    private String name;
    private int chips;
    private int wager;
    private int score;
    private static int topScore;
    private static String topScoreName;
    private Die die = new Die();

    //constructor
    public Player(String name, int wager) {
        this.name = name;
        this.wager = wager;
        score = 0;
        chips = 100;
        topScore = 100;
        topScoreName = null;
    }

    //getter methods
    public String getName() {
        return name;
    }
    public int getPChips() {
        return chips;
    }
    public static int topScore() {
        return topScore;
    }
    public static String topScoreName() {
        return topScoreName;
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
    public void setPChips(int newChips) {
        chips = newChips;
    }
    //other methods
    public void subtract(int val) {     //subtracts chips from the player
        chips -= val;
        if(chips <= 0) {
            chips = 0;
            System.out.println(name + " has no more chips and is out of the game");
            wager = 0;
        }
    }
    public void add(int val) {          //adds chips to the player
        chips += val;
        if(chips > this.topScore) {     //changes the top score if the number of chips a current player has a higher value
            this.topScore = chips;
            this.topScoreName = getName();
        }
    }

    //other methods
    public void playerRoll() {      //helps the player roll and prints out result
        die.roll();
        int die1 = die.getDie1();
        int die2 = die.getDie2();
        int die3 = die.getDie3();
        System.out.println(getName() + " rolls: " + die1 + ", " + die2 + ", " + die3);

    }
    public int pWin() {
        return die.win();
    }


}

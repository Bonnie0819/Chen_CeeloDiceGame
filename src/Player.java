public class Player {
    //instance variables
    private String name;
    private int chips;
    private int wager;

    //constructor
    public Player(String name, int wager) {
        this.name = name;
        this.wager = wager;
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
    //setter methods
    public void setWager(int newWager) {
        wager = newWager;
    }
    //other methods
    public void subtract(int val) {
        chips -= val;
    }
    public void add(int val) {
        chips += val;
    }


}

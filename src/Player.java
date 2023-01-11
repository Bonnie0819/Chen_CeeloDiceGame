public class Player {
    //instance variables
    private String name;
    private int chips;

    //constructor
    public Player(String name) {
        this.name = name;
        chips = 100;
    }

    //getter methods
    public String getName() {
        return name;
    }
    public int getChips() {
        return chips;
    }
    //other methods
    public void subtract(int val) {
        chips -= val;
    }
    public void add(int val) {
        chips += val;
    }


}

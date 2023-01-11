public class Die {
    private int die1;
    private int die2;
    private int die3;
    private int rollTotal;

    //getter methods
    public int getRollTotal() {
        return rollTotal;
    }

    //other methods
    public void roll() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        die3 = (int) (Math.random() * 6) + 1;
        rollTotal = die1 + die2 + die3;
    }

}

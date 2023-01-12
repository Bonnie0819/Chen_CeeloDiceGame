public class Die {
    private int die1;
    private int die2;
    private int die3;
    private int rollTotal;

    //getter methods
    public int getRollTotal() {
        return rollTotal;
    }
    public int getDie1() {
        return die1;
    }
    public int getDie2() {
        return die2;
    }
    public int getDie3() {
        return die3;
    }
    //setter methods
    public void setDie1(int newDie1) {
        die1 = newDie1;
    }
    public void setDie2(int newDie2) {
        die2 = newDie2;
    }
    public void setDie3(int newDie3) {
        die3 = newDie3;
    }


    //other methods
    public void roll() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        die3 = (int) (Math.random() * 6) + 1;
    }

}

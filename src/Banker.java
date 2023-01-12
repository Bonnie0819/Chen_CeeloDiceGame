public class Banker {
    //instance variables
    private int chips;
    private Die die;

    //constructor
    public Banker() {
        chips = 1000;
        die = new Die();
    }


    //other methods
    public void subtract(int val) {
        chips -= val;
    }
    public void add(int val) {
        chips += val;
    }
    }

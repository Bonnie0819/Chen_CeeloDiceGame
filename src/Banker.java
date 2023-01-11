public class Banker {
    //instance variables
    private int chips;

    //constructor
    public Banker() {
        chips = 1000;
    }

    //other methods
    public void subtract(int val) {
        chips -= val;
    }
    public void add(int val) {
        chips += val;
    }
    }

public class Die {
    private int die1;
    private int die2;
    private int die3;
    private int score;
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
    public int getScore() { return score; }
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
        if(die1 > die2) {
            int temp = die2;
            die2 = die1;
            die1 = temp;
        }
    }


    //private helper methods
    //calculates the score of the dice
    private int score() {
        if(die1 == die2 && die2 != die3) {
            score = die3;
            return score;
        } else if(die1 == die3 && die1 != die2) {
            score = die2;
            return score;
        } else if(die2 == die3 && die2 != die1) {
            score = die1;
            return score;
        } else {
            score = die1 + die2 + die3;
            return score;
        }

    //checks to see if player/banker wins
    private int win() {
        if (die1 == die2 == die3) {
            return 0;       // 0 indicates a win
        } else if (die1 == 4) {

        } else if ()
            return 1;      // 1 indicates a loss
        }
        return 2;          // 2 indicates reroll
         }




    }

}

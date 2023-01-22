import java.util.Scanner;
public class Ceelo {
    //instance variables
    private Scanner scan;
    private Banker banker = new Banker();

    //constructor
    public Ceelo() {
        scan = new Scanner(System.in);
    }
    public void play() {
        System.out.println("Welcome to Cee-lo Dice Game!");

        //creating player and die objects
        Die die = new Die();
        System.out.print("Enter Player1 Name: ");
        String name = scan.nextLine();
        System.out.print("Wager Amount (You start with 100 chips): ");
        int wager = scan.nextInt();
        scan.nextLine();
        Player player1 = new Player(name, wager);
        System.out.print("Enter Player2 Name: ");
        name = scan.nextLine();
        System.out.print("Wager Amount (You start with 100 chips): ");
        wager = scan.nextInt();
        scan.nextLine();
        Player player2 = new Player(name, wager);
        System.out.print("Enter Player3 Name: ");
        name = scan.nextLine();
        System.out.print("Wager Amount (You start with 100 chips): ");
        wager = scan.nextInt();
        scan.nextLine();
        Player player3 = new Player(name, wager);
        int wagerTotal = player1.getWager() + player2.getWager() + player3.getWager();
        System.out.println("---------------------------------------------------");

        //banker rolls
        banker.bankerRoll();
        while(banker.bWin() == 3) {
            System.out.println("Invalid Roll! Banker Rerolls!");
            banker.bankerRoll();
        }
        if(banker.bWin() == 0) {               //announces how much each player loses after banker wins
            System.out.println("Banker Wins!");
            System.out.println(player1.getName() + " loses " + player1.getWager());
            player1.subtract(player1.getWager());
            System.out.println(player2.getName() + " loses " + player2.getWager());
            player1.subtract(player2.getWager());
            System.out.println(player3.getName() + " loses " + player3.getWager());
            player1.subtract(player3.getWager());
            System.out.println("Banker gains " + wagerTotal);       //adds the wager amount to banker
            banker.add(wagerTotal);
        } else if(banker.bWin() == 1) {        //annouces how much each player wins after banker loses
            System.out.println("Banker Loses!");
            System.out.println(player1.getName() + " gains " + player1.getWager());
            player1.add(player1.getWager());
            System.out.println(player2.getName() + " gains " + player2.getWager());
            player1.add(player2.getWager());
            System.out.println(player3.getName() + " gains " + player3.getWager());
            player1.add(player3.getWager());
            System.out.println("Banker loses " + wagerTotal);      //subtracts the wager amount from banker
            banker.subtract(wagerTotal);
        } else if(banker.bWin() == 2) {
            System.out.println("Banker rolls a double and scores: " + banker.getBScore());
            if(player1.getChips() > 0) {
                player1.playerRoll();
                while(player1.pWin() == 3) {
                    player1.playerRoll();
                }
                if(player1.pWin() == 0) {
                    System.out.println(player1.getName() + " wins " + player1.getWager() + " !");
                    banker.subtract(player1.getWager());
                    player1.add(player1.getWager());
                } else if(player1.pWin() == 1) {
                    System.out.println(player1.getName() + "loses " + player1.getWager() + " !");
                    banker.add(player1.getWager());
                    player1.subtract(player1.getWager());
                }  else if(player1.pWin() == 2) {
                    if(banker.getBScore() > player1.getPScore()) {
                        System.out.println("The Banker wins " + player1.getWager());
                        banker.add(player1.getWager());
                        player1.subtract(player1.getWager());
                    } else {
                        System.out.println(player1.getName() + " wins" + player1.getWager());
                        banker.subtract()
                    }
                }
            }
        }
     }

    //private methods
    private void menu() {          //prints out a menu for the user to chose from
        System.out.println("1. Roll Dice ");
        System.out.println("2. Check Chip Balance ");
        System.out.println("3. Change Wager");
    }






}

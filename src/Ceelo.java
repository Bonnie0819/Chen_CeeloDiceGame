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

        //banker rolls
        banker.bankerRoll();
    }

    //private methods
    private void menu() {          //prints out a menu for the user to chose from
        System.out.println("1. Roll Dice ");
        System.out.println("2. Check Chip Balance ");
        System.out.println("3. Change Wager");
    }






}

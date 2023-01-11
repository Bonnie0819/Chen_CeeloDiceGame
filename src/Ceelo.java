import java.util.Scanner;
public class Ceelo {
    //instance variables
    private Scanner scan;

    //constructor
    public Ceelo() {
        scan = new Scanner(System.in);
    }
    public void play() {
        System.out.println("Welcome to Cee-lo Dice Game!");

        //creating player objects
        System.out.println("Enter Player1 Name: ");
        String name = scan.nextLine();
        Player player1 = new Player(name);
        System.out.println("Enter Player2 Name: ");
        name = scan.nextLine();
        Player player2 = new Player(name);
        System.out.println("Enter Player3 Name: ");
        name = scan.nextLine();
        Player player3 = new Player(name);


    }

}

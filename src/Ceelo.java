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
        gameRules();

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

        boolean play = true;
        while(play = true) {
            //banker rolls
            int choice = 0;
            while (banker.getBChips() > 0 && (player1.getPChips() > 0 || player2.getPChips() > 0 || player3.getPChips() > 0) && choice != 6) {
                banker.bankerRoll();
                while (banker.bWin() == 3) {
                    System.out.println("Invalid Roll! Reroll!");
                    banker.bankerRoll();
                }
                if (banker.bWin() == 0) {               //announces how much each player loses after banker wins
                    System.out.println("---------------------------------------------------");
                    System.out.println("Banker Wins!");
                    if(player1.getPChips() > 0) {
                        System.out.println(player1.getName() + " loses " + player1.getWager() + " chips!");
                        player1.subtract(player1.getWager());
                    }
                    if(player2.getPChips() > 0) {
                        System.out.println(player2.getName() + " loses " + player2.getWager() + " chips!");
                        player1.subtract(player2.getWager());
                    }
                    if(player3.getPChips() > 0) {
                        System.out.println(player3.getName() + " loses " + player3.getWager() + " chips!");
                        player1.subtract(player3.getWager());
                    }
                    System.out.println("Banker gains " + wagerTotal);       //adds the wager amount to banker
                    banker.add(wagerTotal);
                } else if (banker.bWin() == 1) {        //annouces how much each player wins after banker loses
                    System.out.println("---------------------------------------------------");
                    System.out.println("Banker Loses!");
                    System.out.println(player1.getName() + " gains " + player1.getWager() + " chips!");
                    player1.add(player1.getWager());
                    System.out.println(player2.getName() + " gains " + player2.getWager() + " chips!");
                    player1.add(player2.getWager());
                    System.out.println(player3.getName() + " gains " + player3.getWager() + " chips!");
                    player1.add(player3.getWager());
                    System.out.println("Banker loses " + wagerTotal);      //subtracts the wager amount from banker
                    banker.subtract(wagerTotal);
                } else if (banker.bWin() == 2) {
                    System.out.println("Banker rolls a double and scores: " + banker.getBScore());
                    System.out.println("---------------------------------------------------");
                    //rolls for player1
                    if (player1.getPChips() > 0) {
                        player1.playerRoll();
                        while (player1.pWin() == 3) {
                            System.out.println("Invalid Roll! Reroll!");
                            player1.playerRoll();
                        }
                        if (player1.pWin() == 0) {
                            System.out.println(player1.getName() + " wins " + player1.getWager() + " chips!");
                            banker.subtract(player1.getWager());
                            player1.add(player1.getWager());
                        } else if (player1.pWin() == 1) {
                            System.out.println(player1.getName() + " loses " + player1.getWager() + " chips!");
                            banker.add(player1.getWager());
                            player1.subtract(player1.getWager());
                        } else if (player1.pWin() == 2) {
                            System.out.println(player1.getName() + " rolls a double and scores: " + player1.getPScore());
                            if (banker.getBScore() > player1.getPScore()) {
                                System.out.println("The Banker scores higher with a score of " + banker.getBScore());
                                System.out.println("The Banker wins " + player1.getWager() + " chips!");
                                banker.add(player1.getWager());
                                player1.subtract(player1.getWager());
                            } else {
                                System.out.println(player1.getName() + " scores higher with a score of " + player1.getPScore());
                                System.out.println(player1.getName() + " wins " + player1.getWager() + " chips!");
                                banker.subtract(player1.getWager());
                                player1.add(player1.getWager());
                            }
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    //rolls for player2
                    if (player2.getPChips() > 0) {
                        player2.playerRoll();
                        while (player2.pWin() == 3) {
                            System.out.println("Invalid Roll! Reroll!");
                            player2.playerRoll();
                        }
                        if (player2.pWin() == 0) {
                            System.out.println(player2.getName() + " wins " + player2.getWager() + " chips!");
                            banker.subtract(player2.getWager());
                            player2.add(player2.getWager());
                        } else if (player2.pWin() == 1) {
                            System.out.println(player2.getName() + " loses " + player2.getWager() + " chips!");
                            banker.add(player2.getWager());
                            player2.subtract(player2.getWager());
                        } else if (player2.pWin() == 2) {
                            System.out.println(player2.getName() + " rolls a double and scores: " + player2.getPScore());
                            if (banker.getBScore() > player2.getPScore()) {
                                System.out.println("The Banker scores higher with a score of " + banker.getBScore());
                                System.out.println("The Banker wins " + player2.getWager() + " chips!");
                                banker.add(player2.getWager());
                                player2.subtract(player2.getWager());
                            } else {
                                System.out.println(player2.getName() + " scores higher with a score of " + player2.getPScore());
                                System.out.println(player2.getName() + " wins " + player2.getWager() + " chips!");
                                banker.subtract(player2.getWager());
                                player2.add(player2.getWager());
                            }
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    //rolls for player3
                    if (player3.getPChips() > 0) {
                        player3.playerRoll();
                        while (player3.pWin() == 3) {
                            System.out.println("Invalid Roll! Reroll!");
                            player3.playerRoll();
                        }
                        if (player3.pWin() == 0) {
                            System.out.println(player3.getName() + " wins " + player3.getWager() + " chips!");
                            banker.subtract(player3.getWager());
                            player3.add(player3.getWager());
                        } else if (player3.pWin() == 1) {
                            System.out.println(player3.getName() + " loses " + player3.getWager() + " chips!");
                            banker.add(player3.getWager());
                            player3.subtract(player3.getWager());
                        } else if (player3.pWin() == 2) {
                            System.out.println(player3.getName() + " rolls a double and scores: " + player3.getPScore());
                            if (banker.getBScore() > player3.getPScore()) {
                                System.out.println("The Banker scores higher with a score of " + banker.getBScore());
                                System.out.println("The Banker wins " + player3.getWager() + " chips!");
                                banker.add(player3.getWager());
                                player3.subtract(player3.getWager());
                            } else {
                                System.out.println(player3.getName() + " scores higher with a score of " + player3.getPScore());
                                System.out.println(player3.getName() + " wins " + player3.getWager() + " chips!");
                                banker.subtract(player3.getWager());
                                player3.add(player3.getWager());
                            }
                        }
                    }
                    System.out.println("---------------------------------------------------");
                }
                if(player1.getPChips() < 0 && player2.getPChips() < 0 && player3.getPChips() < 0) {
                    System.out.println("Would you like to play again? (1) yes (2) no");
                    int ans = scan.nextInt();
                    if(ans == 2) {
                        play = false;
                    }
                } else {
                    //prints out the menu
                    while (choice != 4) {
                        menu();
                        System.out.print("Choice: ");
                        choice = scan.nextInt();
                        scan.nextLine();
                        System.out.println("---------------------------------------------------");
                        if (choice == 1) {
                            System.out.println(player1.getName() + " has " + player1.getPChips() + " chips");
                            System.out.println(player2.getName() + " has " + player2.getPChips() + " chips");
                            System.out.println(player3.getName() + " has " + player3.getPChips() + " chips");
                        }
                        if (choice == 2) {
                            System.out.println("The top score is held by " + Player.topScoreName() + " with " + Player.topScore() + " chips!");
                        }
                        if (choice == 3) {
                            gameRules();
                        }
                        if (choice == 5) {
                            play = false;
                        }
                        System.out.println("---------------------------------------------------");

                    }
                }
                    System.out.println("Setting New Wagers: ");
                    if (player1.getPChips() > 0) {
                        System.out.print(player1.getName() + " set wager: ");
                        player1.setWager(scan.nextInt());
                        scan.nextLine();
                    }
                    if (player2.getPChips() > 0) {
                        System.out.print(player2.getName() + " set wager: ");
                        player2.setWager(scan.nextInt());
                        scan.nextLine();
                    }
                    if (player3.getPChips() > 0) {
                        System.out.print(player3.getName() + " set wager: ");
                        player3.setWager(scan.nextInt());
                        scan.nextLine();
                    }
                }

            }
        }


        //private methods
        private void menu () {          //prints out a menu for the user to chose from
            System.out.println("1. Check Chip Balance");
            System.out.println("2. View Top Score");
            System.out.println("3. Game Rules");
            System.out.println("4. Continue to Next Round");
            System.out.println("5. Quit");
        }



        private void gameRules () {         //prints out the game rules for Ceelo
            System.out.println("GAME RULES: \n");
            System.out.println("1. Banker starts with 1000 chips and each player starts with 100 chips.");
            System.out.println("2. Scoring with 3 dice occurs in the following ways: " +
                    "\n    a. Roll of triples equals automatic win \n    b. Three dice displaying 4, 5, 6 equals automatic win" +
                    "\n    c. Three dice displaying 1, 2, 3 equals automatic loss \n    d. Roll of double results in a score of the third die" +
                    "\n    e. Any other roll is invalid (e.g. 1, 4, 5) and the Banker or Player will reroll dice until a valid roll");
            System.out.println("3. Each round starts by asking each player to make a wager between 0 chips and # of chips they have individually; Banker doesn't wager");
            System.out.println("4. Banker rolls first every round. \n    a. If Banker rolls a win, Banker will collect wagered amount of chips from each player and round ends" +
                    "\n    b. If Banker rolls a loss, Banker will pay each player their wagered amount of chips and round ends" +
                    "\n    c. If Banker rolls a double, the round continues and each player gets to roll");
            System.out.println("5. In the case of 4c: \n    If player rolls a win, they win their wagered chips" +
                    "\n    If player roll a loss, then they lose their wagered chips" +
                    "\n    If player rolls a double: " +
                    "\n    - Banker wins if score is higher than player's score" +
                    "\n    - Player wins if score is equal or higher than Banker's score");
            System.out.println("6. When a player's chips reaches 0, they are out of the game and won't participate in further rounds");
            System.out.println("7. Game ends when all three players run out of chips (Banker wins) or if the Banker runs out of chips (player with the most chips wins)");
            System.out.println("---------------------------------------------------");
        }
    }









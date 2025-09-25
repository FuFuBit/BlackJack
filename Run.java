import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner input = new Scanner(System.in);

        int playerCount = 0;

        while (true) 
        {
            System.out.print("How many players would you like? (1 to 4): ");
            if (input.hasNextInt()) 
            {
                playerCount = input.nextInt();
                input.nextLine();
                if (playerCount >= 1 && playerCount <= 4) 
                {
                    break;
                } 
                else 
                {
                    System.out.println("Please enter a number between 1 and 4.");
                }
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
        
        ArrayList<Player> playerList = new ArrayList<>();
        
        for (int i = 1; i <= playerCount; i++) 
        {
            String playerName;
            int playerMoney;

            while (true) {
                System.out.print("\nEnter name for Player " + i + ": ");
                playerName = input.nextLine().trim();
                if (!playerName.isEmpty()) 
                {
                    break;
                } 
                else 
                {
                    System.out.println("Name cannot be empty.");
                }
            }

            while (true) {
                System.out.print("Enter starting money for " + playerName + ": ");
                if (input.hasNextInt()) 
                {
                    playerMoney = input.nextInt();
                    input.nextLine();
                    if (playerMoney > 0) 
                    {
                        break;
                    } 
                    else 
                    {
                        System.out.println("Money must be a positive number.");
                    }
                } 
                else 
                {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();
                }
            }

            playerList.add(new Player(playerName, playerMoney));
        }

        // System.out.println("\n" + playerList);

        // System.out.println("\nWhich character would you like to be? ");
        // for(int i = 0; i < playerList.size(); i++)
        // {
        //     System.out.println("\n" + (i + 1) + ". " + playerList.get(i));
        // }

        // int playerCharacter = 0;
        // while (true) {
        //     System.out.print("\nEnter the number corresponding to your character: ");
        //     if (input.hasNextInt()) 
        //     {
        //         playerCharacter = input.nextInt() - 1;
        //         input.nextLine();

        //         if (playerCharacter >= 0 && playerCharacter < playerList.size()) 
        //         {
        //             break;
        //         } 
        //         else 
        //         {
        //             System.out.println("Invalid choice. Please choose a number between  and " + (playerList.size() - 1) + ".");
        //         }
        //     } 
        //     else 
        //     {
        //         System.out.println("Invalid input. Please enter a number.");
        //         input.nextLine();
        //     }
        // }

        // System.out.println("You chose: " + playerList.get(playerCharacter));
        System.out.println("");
        Utils.loopingEllipsisWithMessage("The game is now starting", 4,400);

        playerList.get(0).hit(deck);
    }
    
}

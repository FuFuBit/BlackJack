import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Player
{
    private String name;
    private int money;
    private int bet;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
    }

    public void playTurn(Deck deck)
    {
        Scanner input = new Scanner(System.in);
        Set<String> hitOptions = Set.of("h", "hit");
        Set<String> stayOptions = Set.of("s", "stay");

        while (true) 
        {
            System.out.println("Hit or Stay? You can type h, or s as well: ");
            String action = input.nextLine().toLowerCase().trim(); 

            if (hitOptions.contains(action)) 
            {
                hit(deck);
            } 
            else if (stayOptions.contains(action)) 
            {
                return;
            } 
            else 
            {
                System.out.println("Invalid input. Please type Hit (h) or Stay (s).");
            }
        }
    }

    public void hit(Deck deck)
    {
        hand.add(deck.getTopCard());
    }

    public int getHandValue()
    {
        int handValue = 0;
        int aceCount = 0;

        for(int i = 0; i < hand.size(); i++)
        {
            Card current_card = hand.get(i);
            if(current_card.getFace() == "A")
            {
                aceCount++;
                handValue += 11;
            }

            else
            {
                handValue += current_card.getValue();
            }
        }

        while(handValue > 21 && aceCount > 0)
        {
            handValue -= 10;
            aceCount--;
        }

        return handValue;
    }

    public void setBet(int playerMoney)
    {
        Scanner input = new Scanner(System.in);
        while (true) 
            {
                System.out.println("Please place a bet: ");

                if (input.hasNextInt()) 
                {
                    int betAmount = input.nextInt();

                    if (betAmount > playerMoney) 
                    {
                        System.out.println("You do not have that much to bet.");
                    }
                    else if (betAmount <= 0)
                    {
                        System.out.println("Bet must be a positive number.");
                    }
                    else
                    {
                        System.out.println("Your bet is: " + betAmount);
                        break;
                    }
                }

                else
                {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    input.next();
                }
            }

        input.close();
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }
}
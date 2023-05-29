package card;

import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            int randomValue = rand.nextInt(13) + 1; // random number between 1 and 13
            int randomSuitIndex = rand.nextInt(4); // random number between 0 and 3

            c.setValue(randomValue);
            c.setSuit(Card.SUITS[randomSuitIndex]);

            magicHand[i] = c;
        }
        
        // Hard code the lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(7); // for example, value 7
        luckyCard.setSuit(Card.SUITS[2]); // for example, suit Spades

        // Ask the user to pick a card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King):");
        int userValue = scanner.nextInt();
        System.out.println("Pick a suit (0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs):");
        int userSuitIndex = scanner.nextInt();

        // Check if the user's card matches the lucky card
        if (userValue == luckyCard.getValue() && userSuitIndex == 2) {
            System.out.println("Congratulations! You picked the lucky card!");
        } else {
            System.out.println("Sorry, that's not the lucky card.");
        }

        // Check if the lucky card is in the magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equals(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The lucky card is in the magic hand!");
        } else {
            System.out.println("Unfortunately, the lucky card is not in the magic hand.");
        }

        scanner.close();
    }
}

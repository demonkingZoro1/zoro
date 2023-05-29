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
        luckyCard.setValue(13); // King
        luckyCard.setSuit(Card.SUITS[0]); // Hearts

        // Check if the lucky card is in the magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equals(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("The lucky card (King of Hearts) is in the magic hand!");
        } else {
            System.out.println("Unfortunately, the lucky card (King of Hearts) is not in the magic hand.");
        }
    }
}


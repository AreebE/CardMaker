
//This will randomly assign cards in the deck to ransom pistions 
import java.util.ArrayList;
import java.util.Random;

//need to randomize deck 

public class Deck {
  final static int numOfCards = 52;

  public static Card[] getRandomizedDeck() {
    Card[] deck = new Card[52];
    Random rand = new Random();

    //sets the deck up
    for (int i = 0; i < 52; i++) {
      if (i / 12 == 0) {
        deck[i] = new Card(i%12 +1, Util.Suit.DIAMOND);
      } else if (i / 12 == 1) {
        deck[i] = new Card(i%12 + 1, Util.Suit.HEART);
      } else if (i / 12 == 2) {
        deck[i] = new Card(i%12 + 1, Util.Suit.CLUB);
      } else {
        deck[i] = new Card(i%12 +1, Util.Suit.SPADE);
      }

    }

    //re-arranges the deck 
    for (int j = 0; j < 52; j++) {
      //switches the place of two random cards
      int n = (int) (Math.random() * 51);
      int m = (int) (Math.random() * 51);
      if (m == n) {
        n = (int) (Math.random() * 51);
        m = (int) (Math.random() * 51);
      }
      Card aCard = deck[n];
      Card bCard = deck[m];

      deck[n] = bCard;
      deck[m] = aCard;
      
    }
    return deck;
  }

}
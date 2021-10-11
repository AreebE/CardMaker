
//This will randomly assign cards in the deck to ransom pistions 
import java.util.ArrayList;
import java.util.Random;

//need to randomize deck 

public class Deck {
  final static int numOfCards = 52;
  private ArrayList<Card> deck; 
  
  public Deck(){
    //sets the deck up
    deck = new ArrayList<>();
    for (int i = 0; i < 52; i++) {
      if (i / 13 == 0) {
        deck.add(i, new Card(i%13 +1, Util.Suit.DIAMOND
        ));
      } else if (i / 13 == 1) {
        deck.add(i, new Card(i%13 +1, Util.Suit.SPADE
        ));;
      } else if (i / 13 == 2) {
        deck.add(i, new Card(i%13 +1, Util.Suit.CLUB
        ));
      } else {
        deck.add(i, new Card(i%13 +1, Util.Suit.HEART
        ));
      }
    }
    
    //re-arranges the deck 
    for (int j = 0; j < 52; j++) {
      //switches the place of two random cards
      int n = (int) (Math.random() * 51);
      int m = (int) (Math.random() * 51);
      while (m == n) {
        n = (int) (Math.random() * 51);
        m = (int) (Math.random() * 51);
      }
      Card aCard = deck.get(n);
      Card bCard = deck.get(m);

      deck.set(n, bCard);
      deck.set(m, aCard);
      
    }
  }

  public Card drawCard(){
    Card first = deck.remove(0);
    deck.add(numOfCards - 1, first);
    return first;
  }

  @Override
  public String toString(){
    StringBuilder output = new StringBuilder();
    for(Card c: deck){
      output.append(c).append("\n");
    }
    return output.toString();
  }
}
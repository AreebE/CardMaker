import java.util.HashSet;

public class TwoPair extends Hand {

  public TwoPair(Card[] hand){
    super(Util.TWO_PAIR, hand);
    
  }
  
  @Override
  protected String createString(Card[] hand){
    String returnValue = "";
    HashSet<Integer> values = new HashSet<>(); 
    int indexForPairs = 0;
    int index = 0;
    int[] orderedCards = new int[Util.HAND_SIZE - 2];

    for (int i = 0; i < hand.length; i++){
      int value = Util.getValue(hand[i].getRank());
      if (values.contains(value)){
        int j = indexForPairs;
        while (j < orderedCards.length && orderedCards[j] != value)
          j++;

        int holder = orderedCards[j];
        orderedCards[j] = orderedCards[indexForPairs];
        orderedCards[indexForPairs] = holder;
        indexForPairs++;
      }
      else {
        orderedCards[index++] = value;
        values.add(value);
      }

    }
    Util.sort(orderedCards, 0, 2);
    String orderOfCards = "";
    for (int card: orderedCards){
      orderOfCards += Util.translateValueToChar(card);
    }
    return orderOfCards;
  }
}

import java.util.HashSet;

public class OnePair extends Hand {

  public OnePair(Card[] hand){
    super(Util.ONE_PAIR, hand);
  }
  
  @Override
  protected String createString(Card[] hand){ 
    String returnValue = "";
    int pairOfValues = -1;
    HashSet<Integer> values = new HashSet<>(); 
    int index = 0;
    int[] orderedCards = new int[Util.HAND_SIZE - 1];
   
    for (int i = 0; i < hand.length; i++){
      int val = Util.interpretValue(hand[i].getValue());
      if (values.contains(val)){
        int j = 0;
        while (j < orderedCards.length && orderedCards[j] != val)
          j++;

        int holder = orderedCards[j];
        orderedCards[j] = orderedCards[0];
        orderedCards[0] = holder;
      }
      else {
        orderedCards[index++] = val;
        values.add(val);
      }
    }

    Util.sort(orderedCards, 1);
    String orderOfCards = "";
    for (int card: orderedCards){
      orderOfCards += Util.translateValueToChar(card);
    }
    return orderOfCards;
  }
}

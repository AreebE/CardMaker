import java.util.HashSet;
public class ThreeOfAKind extends Hand {

  public ThreeOfAKind(Card[] hand){
    super(Util.THREE_OF_A_KIND, hand);    
  }


  @Override
  protected String createString(Card[] hand){ 
    String returnValue = "";
    HashSet<Integer> values = new HashSet<>(); 

    int index = 0;
    int[] orderedCards = new int[Util.HAND_SIZE - 2];

    for (int i = 0; i < hand.length; i++) {
      int value = Util.getValue(hand[i].getRank());
      if (values.contains(value)){
        int j = 0;
        while (j < orderedCards.length && orderedCards[j] != value) {
          j++;
        }

        if (j != 0) {
          int holder = orderedCards[j];
          orderedCards[j] = orderedCards[0];
          orderedCards[0] = holder;
        }
      }
      else {
        orderedCards[index++] = value;
        values.add(value);
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

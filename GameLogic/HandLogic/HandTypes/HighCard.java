
public class HighCard extends Hand {
  public HighCard(Card[] hand){
    super(Util.HIGH_CARD, hand);
  }
  
  @Override
  protected String createString(Card[] hand){ 
    int[] orderedCards = new int[Util.HAND_SIZE];
    for (int i = 0; i < hand.length; i++){
      orderedCards[i] = Util.getValue(hand[i].getRank());
    }
    Util.sort(orderedCards, 0);
    String orderOfCards = "";
    for (int card: orderedCards){
      orderOfCards += Util.getChar(card);
    }
    return orderOfCards;
  }
}

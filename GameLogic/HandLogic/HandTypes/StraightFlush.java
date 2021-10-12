public class StraightFlush extends Hand {
  
  public StraightFlush(Card[] hand){
    super(Util.STRAIGHT_FLUSH, hand);
  }
  
  @Override
  protected String createString(Card[] hand){ 
    int bestValue = Util.getValue(hand[0].getRank());
    boolean containsFive = false;
    for (int i = 1; i < hand.length; i++){
      int value = Util.getValue(hand[i].getRank());
      if (bestValue < value){
        bestValue = value;
      }
      containsFive = value == Util.getValue(Util.Rank.FIVE);
    }
    
    if (bestValue == Util.getValue(Util.Rank.ACE) && containsFive){
      return Util.getChar(Util.FIVE) + "";
    }
    return Util.getChar(bestValue) + "";
  }
}

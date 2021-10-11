public class Straight extends Hand {

  public Straight(Card[] hand){
    super(Util.STRAIGHT, hand);
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
      return Util.getValue(Util.Rank.FIVE) + "";
    }
    return Util.translateValueToChar(bestValue) + "";
  }

}

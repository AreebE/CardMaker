public class Straight extends Hand {

  public Straight(Card[] hand){
    super(Util.STRAIGHT, hand);
  }
  
  @Override
  protected String createString(Card[] hand){ 
    int bestValue = Util.interpretValue(hand[0].getValue());
    boolean containsFive = false;
    
    for (int i = 1; i < hand.length; i++){
      int value = Util.interpretValue(hand[i].getValue());
      if (bestValue < value)
        bestValue = value;
      containsFive = value == 5;
    }  

    if (bestValue == Util.ACE_HIGH && containsFive){
      return Util.FIVE + "";
    }
    return Util.translateValueToChar(bestValue) + "";
  }

}

public class RoyalFlush extends Hand {

  public RoyalFlush(Card[] hand){
    super(Util.ROYAL_FLUSH, hand);
  }

  @Override
  protected String createString(Card[] hand){ 
    return "" + Util.getChar(Util.ACE);
  }
  
}
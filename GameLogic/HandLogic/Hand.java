import java.lang.Comparable;
import java.util.Arrays;

abstract public class Hand implements Comparable<Hand>{
  private Card[] cardsInHand;
  private int handType;
  private String cardsToCompare;

  public Hand(int handType, Card[] hand){
    this.handType = handType;
    cardsInHand = hand;
    cardsToCompare = createString(hand);
  }

  @Override
  public int compareTo(Hand other){
    if (handType == other.getHandType()){
      return compareToSameTypeHand(other);
    }
    return handType - other.getHandType();
  }

  public int compareToSameTypeHand(Hand other){
    String otherSetOfCards = other.getCardsToCompare();
    for (int i = 0; i < cardsToCompare.length(); i++){
      int thisCardValue = Util.getValue(cardsToCompare.charAt(i));
      int otherCardValue = Util.getValue(otherSetOfCards.charAt(i));
      if (thisCardValue != otherCardValue){
        return thisCardValue - otherCardValue;
      }
    }
    return 0;
  }

  public int getHandType(){
    return handType;
  }



  public String getCardsToCompare(){
    return cardsToCompare;
  }

  @Override
  public String toString(){
    String returnValue = "";
    for (Card c: cardsInHand){
      returnValue += "* " + c.toString() + "\n";
    }
    return returnValue;
  } 

  protected abstract String createString(Card[] hand);
}
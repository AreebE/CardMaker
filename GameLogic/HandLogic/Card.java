import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.lang.Comparable;

/*
 * The card class is designed to hold a value and a suit,
 * Both assigned when the constructor is called.
 * Afterwards, the card is able to draw itself, so long 
 * as it is given the necessary things like a canvas 
 * and starting coordinates
 * (made mostly by me, before me and Moira worked 
 * together)
*/
public class Card implements Comparable<Card>{

  private final int VALUE;
  private final Util.Suit SUIT;
 

  /*
   * This is the public constructor that initializes the card
   *
   * @param v The value/rank of the card (ex. King or Ace)
   * 
   * @param s The suit the card belongs to (ex. Heart)
   */
  public Card(int v, Util.Suit s) {
    VALUE = v;
    SUIT = s;
  }


  /*
   * Gives the suit of the card
   *
   * @return  The suit of this card
  */
  public Util.Suit getCardSuit() {
    return SUIT;
  }

  /*
   * Gives the value of the card
   *
   * @return  The value of this card
  */
  public int getValue(){
    return VALUE;
  }

  public static Util.Suit getSuit(int s){
    switch(s){
      case 0:
        return Util.Suit.DIAMOND;
        case 1:
        return Util.Suit.HEART;
        case 2:
        return Util.Suit.CLUB;
        case 3:
        return Util.Suit.SPADE;
    }
      return null;

  }

  @Override
  public int compareTo(Card other){
    return VALUE - other.getValue();
  }

  @Override 
  public String toString(){
    return VALUE + " of " + SUIT.name();
  }
}

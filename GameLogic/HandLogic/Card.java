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

  private final Util.Rank RANK;
  private final Util.Suit SUIT;
 

  /*
   * This is the public constructor that initializes the card
   *
   * @param v The value/rank of the card (ex. King or Ace)
   * 
   * @param s The suit the card belongs to (ex. Heart)
   */
  public Card(Util.Rank r, Util.Suit s) {
    RANK = r;
    SUIT = s;
  }


  /*
   * Gives the suit of the card
   *
   * @return  The suit of this card
  */
  public Util.Suit getSuit() {
    return SUIT;
  }

  /*
   * Gives the value of the card
   *
   * @return  The value of this card
  */
  public Util.Rank getRank(){
    return RANK;
  }

  @Override
  public int compareTo(Card other){
    return Util.getValue(RANK) - Util.getValue(other.getRank());
  }

  @Override 
  public String toString(){
    return RANK.name() + " of " + SUIT.name();
  }
}

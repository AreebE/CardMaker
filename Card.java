import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/*
 * The card class is designed to hold a value and a suit,
 * Both assigned when the constructor is called.
 * Afterwards, the card is able to draw itself, so long 
 * as it is given the necessary things like a canvas 
 * and starting coordinates
 * (made mostly by me, before me and Moira worked 
 * together)
*/
public class Card {

  public enum Suit {
    SQUARE, SPADE, DIAMOND, HEART, CLUB
  }

  private final int VALUE;
  private final Suit SUIT;
  private final int BLOCK_SIZE = Blueprint.BLOCK_SIZE;
 

  /*
   * This is the public constructor that initializes the card
   *
   * @param v The value/rank of the card (ex. King or Ace)
   * 
   * @param s The suit the card belongs to (ex. Heart)
   */
  public Card(int v, Suit s) {
    VALUE = v;
    SUIT = s;
  }


  /*
   * This method will draw this card, using some helper methods. After getting the
   * appropiate artist for the given suit and translating the origin, it will go
   * on to draw the white card background, an outline, the corners, and the middle
   * of the cards. Once that is done, the canvas's transformations are reset.
   * 
   * @param   canvas      The place where the card will be drawn 
   * 
   * @param   startX      The x-coordinate of the upper left corner 
   * 
   * @param   startY      The y-coordinate of the upper left corner 
   * 
   * @param   scaleFactor How much the card will be scaled 
   * based on its original size. Each card is 25 blocks high
   * and 15 blocks wide, where each block is 10px by 10px.
   */
  public void drawCard(Graphics2D canvas, int startX, int startY, double scaleFactor) {
    if (scaleFactor < 1){
      scaleFactor = 1.0;
    }
    CardFaceDrawer artist = getCardDrawer(SUIT);
    AffineTransform oldConditions = canvas.getTransform();
    canvas.translate(startX, startY); // sets origin to upper left corner
    int blockSize = (int) (BLOCK_SIZE * scaleFactor);
    int width = 15 * blockSize;
    int height = 25 * blockSize;
    
    // Draws the card's outline, then its white background
    canvas.setColor(Color.BLACK);
    canvas.fillRect(-blockSize / 2, -blockSize / 2, width + blockSize, height + blockSize);
    canvas.setColor(Color.WHITE);
    canvas.fillRect(0, 0, width, height);

    drawCorners(canvas, blockSize, height, width, artist);

    // Draws the middle part of the card using a blueprint
    ArrayList<Object[]> shapesToDraw = Blueprint.getBlueprint(VALUE, blockSize);
    for (Object[] values : shapesToDraw) {
      int x = (Integer) values[0];
      int y = (Integer) values[1];
      int size = (Integer) values[2];
      boolean isReversed = (Boolean) values[3];
      artist.drawShape(canvas, x, y, size, isReversed, VALUE);
    }
    canvas.setTransform(oldConditions);
  }


  /*
   * As the name of the method says, this draws the 
   * corners of each card. It uses two types of font, 
   * one normal and one reversed, to draw the letters 
   * at each corner. Afterwards, it draws a symbol in 
   * each corner, which is normal in the upper left and * reversed in the lower right, just like the letters
   * 
   * @param   canvas    Where the card was drawn 
   * 
   * @param   height    How high the card is 
   * 
   * @param   width     How wide the card is 
   * 
   * @param   artist    The artist that draws the given symbol 
  */
  private void drawCorners(Graphics2D canvas, int blockSize, int height, int width, CardFaceDrawer artist) {

    Font normalFont = new Font("Monospaced", Font.PLAIN, (int) (blockSize * 1.5));
    AffineTransform inverter = new AffineTransform();
    inverter.rotate(Math.PI);
    Font reversedFont = normalFont.deriveFont(inverter);

    canvas.setColor(artist.getColor());
    String cardValue = getCardValue(VALUE);

    // Draws value in upper left corner, then the lower right corner
    canvas.setFont(normalFont);
    canvas.drawString(cardValue, blockSize, (int) (blockSize * 25.0 / 13));
    canvas.setFont(reversedFont);
    canvas.drawString(cardValue, width - blockSize, height - (int) (blockSize * 25.0 / 13));

    // Draws the symbol for the card (first upper left, then lower right).
    artist.drawShape(canvas, 
        (int) (0.75 * blockSize), 
        (int) (1.5 * blockSize * 5.0 / 3), 
        (int) (1.5 * blockSize),
        false, CardFaceDrawer.BASIC_SYMBOL);
    artist.drawShape(canvas, 
        width - (int) (0.75 * blockSize + 1.5 * blockSize),
        height - (int) (1.5 * blockSize * 5.0 / 3 + 1.5 * blockSize), 
        (int) (1.5 * blockSize), 
        true, CardFaceDrawer.BASIC_SYMBOL);
  }


  /*
   * Based on the value of the card, this returns the letter representing 
   * that card 
   *
   * @param   value   The value/rank of the card
   * 
   * @return  The string that represents the value (ex. 1 = 'A')
  */
  public static String getCardValue(int value) {
    switch (value) {
      case 1:
        return "A";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
      default:
        return value + "";
    }
  }

  /*
   * Based on the suit of the card, this returns an artist able to draw 
   * that suit
   *
   * @param   suit   The suit of the card
   * 
   * @return  The artist that represents that suit
  */
  public static CardFaceDrawer getCardDrawer(Suit suit) {
    switch (suit) {
      case SQUARE:
        return new Square();

      case SPADE:
        return new Spade();

      case CLUB:
        return new Club();

      case HEART:
        return new Heart();

      case DIAMOND:
        return new Diamond();

      default:
        return null;
    }
  }

  /*
   * Gives the suit of the card
   *
   * @return  The suit of this card
  */
  public Suit getCardSuit() {
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

  public static Suit getSuit(int s){
    switch(s){
      case 0:
        return Suit.DIAMOND;
        case 1:
        return Suit.HEART;
        case 2:
        return Suit.CLUB;
        case 3:
        return Suit.SPADE;
    }
      return null;

  }
}

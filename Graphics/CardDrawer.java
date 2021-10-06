import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class CardDrawer {

  private static int BLOCK_SIZE = Blueprint.BLOCK_SIZE;
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
  public static void drawCard(Graphics2D canvas, int startX, int startY, double scaleFactor, Card c) {
    int value = c.getValue();
    Util.Suit suit = c.getCardSuit();
    if (scaleFactor < 1){
      scaleFactor = 1.0;
    }
    CardFaceDrawer artist = getCardDrawer(suit);
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

    drawCorners(canvas, blockSize, height, width, artist, value);

    // Draws the middle part of the card using a blueprint
    ArrayList<Object[]> shapesToDraw = Blueprint.getBlueprint(value, blockSize);
    for (Object[] values : shapesToDraw) {
      int x = (Integer) values[0];
      int y = (Integer) values[1];
      int size = (Integer) values[2];
      boolean isReversed = (Boolean) values[3];
      artist.drawShape(canvas, x, y, size, isReversed, value);
    }
    
    canvas.setTransform(oldConditions); // resets to original conditions
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
  private static void drawCorners(Graphics2D canvas, int blockSize, int height, int width, CardFaceDrawer artist, int value) {

    Font normalFont = new Font("Monospaced", Font.PLAIN, (int) (blockSize * 1.5));
    AffineTransform inverter = new AffineTransform();
    inverter.rotate(Math.PI);
    Font reversedFont = normalFont.deriveFont(inverter);

    canvas.setColor(artist.getColor());
    String cardValue = getCardValue(value);

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
  public static CardFaceDrawer getCardDrawer(Util.Suit suit) {
    switch (suit) {
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
}
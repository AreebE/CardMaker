import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/*
  This class is designed to draw the face of EVERY card, not just 
  the face cards. This also means it will draw the symbols
  that would represent the suit of the card
*/
public abstract class CardFaceDrawer {

  public static final int BASIC_SYMBOL = -1;
  
  /* Gets whether the card is meant to be red or black
  */
  abstract public Color getColor();

  /* Draws the symbol representing the cardś suit
  */
  abstract void drawSymbol(Graphics2D canvas, int size);

  private void drawJack(Graphics2D canvas, int size){
    canvas.setColor(Color.YELLOW);
    /* Insert drawJack code here

    */
    canvas.setColor(getColor());
    canvas.fillRect(0, 0, size, size);
  }

  private void drawQueen(Graphics2D canvas, int size){
    canvas.setColor(Color.YELLOW);
    /* Insert drawQueen code here
    
    */
    canvas.setColor(getColor());
    canvas.fillRect(0, 0, size, size);
  }

  private void drawKing(Graphics2D canvas, int size){
    canvas.setColor(Color.YELLOW);
    /* Insert drawKing method here
    
    */
    canvas.setColor(getColor());
    canvas.fillRect(0, 0, size, size);
  }

  /*
  * 
  */
  public void drawShape(Graphics2D canvas, int x, int y, int size, boolean isReversed, int value){
    AffineTransform oldConditions = canvas.getTransform();
    if (isReversed){
      canvas.translate(size + x, size + y);
      canvas.rotate(Math.PI);
    }
    else {
      canvas.translate(x, y);
    }
    switch(value){
      case 13:
        drawKing(canvas, size);
        break;
      case 12:
        drawQueen(canvas, size);
        break;
      case 11:
        drawJack(canvas, size);
        break;
      default:
        drawSymbol(canvas, size);
        break;
    }
    canvas.setTransform(oldConditions);
  }
}
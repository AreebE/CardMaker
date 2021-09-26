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

  private void drawJack(Graphics2D g, int s){
    g.setColor(Color.YELLOW);
    int[] xCords = new int[7];
    int[] yCords = new int[7];
    int x = 0;
    for(int i = 0; i < 4; i++){
      xCords[i] = x;
      x += s/4;
      if(i%2 == 0){
        yCords[i] = 0;
      }
      else{
        yCords[i] = s/3;
      }
    }
    xCords[4] = s;
    yCords[4] = 0;
    xCords[5] = s;
    yCords[5] = s;
    xCords[6] = 0;
    yCords[6] = s;

    g.fillPolygon(xCords, yCords, 7);
    g.setColor(Color.BLACK);
    g.drawPolygon(xCords, yCords, 7);
    // canvas.setColor(getColor());
    // canvas.fillRect(0, 0, size, size);
  }

  private void drawQueen(Graphics2D g, int s){
    g.setColor(Color.YELLOW);
    g.setColor(Color.YELLOW);
    int[] xCords = new int[9];
    int[] yCords = new int[9];
    int x = 0;
    for(int i = 0; i < 7; i++){
      if(i == 6){
        xCords[i] += s;
      } 
      else{
        xCords[i] = x;
      }
      x =  x + (s/6);
      if(i%2 == 0){
        yCords[i] = 0;
       }
      else{
        yCords[i] = s/3;
       }
    }
      xCords[7] = s;
      xCords[8]  = 0;
      yCords[7] = s;
      yCords[8] = s;
    
      g.fillPolygon(xCords, yCords, 9);
      g.setColor(Color.BLACK);
      g.drawPolygon(xCords, yCords, 9);
    // canvas.setColor(getColor());
    // canvas.fillRect(0, 0, size, size);
  }

  private void drawKing(Graphics2D g, int s){
    // canvas.setColor(Color.YELLOW);
    g.setColor(Color.YELLOW);
    int [] xCords = new int[11];
    int [] yCords = new int[11];
    int x = 0;
    for(int i = 0; i < 8; i++){
      xCords[i] = x;
      x = x+(s/8);
      if(i%2 == 0){
        yCords[i] = 0;
      }
      else{
        yCords[i] = s/3;
      }
    }
    xCords[8] = s;
    xCords[9] = s;
    xCords[10] = 0;
    yCords[8] = 0;
    yCords[9] = s;
    yCords[10] = s;

    g.fillPolygon(xCords, yCords, 11);
    g.setColor(Color.BLACK);
    g.drawPolygon(xCords, yCords, 11);
    // canvas.setColor(getColor());
    // canvas.fillRect(0, 0, size, size);
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
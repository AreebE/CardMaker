import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

/*
 * This class is used for spades
*/
class Spade extends CardFaceDrawer {
  /* 
  * Returns the color of the symbol 
  * 
  * @return Color.BLACK
  */
  @Override
  public Color getColor(){
    return Color.BLACK;
  }

  /* As the name of the class implies, this draws a spade for a symbol.
  *
  * @param  canvas    The place where the symbol is drawn
  * @param  size      The size of the box this symbol is in
  */
  @Override
  void drawSymbol(Graphics2D g, int s){
    g.setColor(Color.BLACK);
    g.fillOval(0, s/3, s/2+ s/ 100, s/2+ s / 100);
    g.fillOval(s/2- s/ 100, s/3, s/2+ s / 100, s/2+ s / 100);
    //x & y cords for the top point
    int[] xCords = new int[3];
    xCords[0] += 0 + s / 33;
    xCords[1] += s - s / 33;
    xCords[2] += s/2;
    int[] yCords = new int[3];
    yCords[0] += s/2 - s/20;
    yCords[1] += s/2 - s/20;
    yCords[2] = 0;
    g.fillPolygon(xCords, yCords, 3);
    g.fillRect(s/4, s/3, s/2, s/3);
    //x & y points for the tail(?)
    int [] xInts = new int[3];
    xInts[0] += s/2;
    xInts[1] += s-s/3;
    xInts[2] += s/3;
    int [] yInts = new int[3];
    yInts[0] += s/2;
    yInts[1] += s;
    yInts[2] += s;
    g.fillPolygon(xInts, yInts, 3);
  }
}


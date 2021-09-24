import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

/*
 * This class is used for hearts
*/
class Heart extends CardFaceDrawer {
  /* Returns the color of the diamond 
  * 
  * @return Color.RED
  */
  @Override
  public Color getColor(){
    return Color.RED;
  }

   /* As the name of the class implies, this draws a heart for a symbol.
   * 
   * @param  canvas    The place where the symbol is drawn
  * @param  size        The size of the box this symbol is in
  */
  @Override
  void drawSymbol(Graphics2D g, int s){
    g.setColor(Color.RED);
   g.fillOval(0, 0, s/2, s/2);
   g.fillOval(s/2, 0, s/2, s/2);
   int[] xCords = new int[3];
   xCords[0] += (0);
   xCords[1] += (s);
   xCords[2] += (s/2);
   int [] yCords = new int[3];
   yCords[0] += (s/3);
   yCords[1] += (s/3);
   yCords[2] += s;
   g.fillPolygon(xCords, yCords, 3);
   g.fillRect(s/3, s/4, s/2, s/5);
  }
}
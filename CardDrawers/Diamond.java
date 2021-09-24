import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

/*
 * This class is used for diamonds
*/
class Diamond extends CardFaceDrawer {
  /* 
  * Returns the color of the diamond 
  * 
  * @return Color.RED
  */
  @Override
  public Color getColor(){
    return Color.RED;
  }

  /* As the name of the class implies, this draws a diamond for a symbol.
  *
  * @param  canvas    The place where the symbol is drawn
  * @param  size        The size of the box this symbol is in
  */
  @Override
  void drawSymbol(Graphics2D canvas, int size){
    canvas.setColor(Color.RED);
    int [] xCords = new int[4];
    xCords[0] = 0;
    xCords[1] += (size/2);
    xCords[2] += (size);
    xCords[3] += ((size/2));
    int [] yCords = new int[4];
    yCords[0] = (size/2);
    yCords[1] = 0;
    yCords[2] = (size/2);
    yCords[3] = size;
    canvas.fillPolygon(xCords, yCords, 4);
  }
}
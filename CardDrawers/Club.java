import java.awt.Graphics2D;
import java.awt.Color;

/*
* This class is used to draw clubs
*/
class Club extends CardFaceDrawer {
  /* 
  * Returns the color of the symbol 
  * 
  * @return Color.BLACK
  */
  @Override
  public Color getColor(){
    return Color.BLACK;
  }

   /* As the name of the class implies, this draws a club for a symbol.
   * 
   * @param  canvas    The place where the symbol is drawn
  * @param  size        The size of the box this symbol is in
  */
  @Override
  void drawSymbol(Graphics2D canvas, int size){
    canvas.setColor(Color.BLACK);
    canvas.fillOval(0, size / 3, size / 2, size / 2);
    canvas.fillOval(size / 2, size / 3, size / 2, size / 2);
    canvas.fillOval(size / 4, size / 17, size / 2, size / 2);
    int[] xCords = new int[3];
    xCords[0] += (size / 2);
    xCords[1] += (size / 2) + (size / 6);
    xCords[2] += (size / 2) - (size / 6);
    int[] yCords = new int[3];
    yCords[0] += (2 * size / 3) - (size / 6);
    yCords[1] += (2 * size / 3) + (size / 3);
    yCords[2] += (2 * size / 3) + (size / 3);
    canvas.fillPolygon(xCords, yCords, 3);
  }
}
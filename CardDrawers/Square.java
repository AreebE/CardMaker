import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

/*
 * This class is used for drawing squares
*/
class Square extends CardFaceDrawer {
  /* 
  * Returns the color of the symbol 
  * 
  * @return Color.RED
  */
  @Override
  public Color getColor(){
    return Color.RED;
  }

   /* As the name of the class implies, this draws a square for a symbol.
   *
   * @param  canvas    The place where the symbol is drawn
  * @param  size        The size of the box this symbol is in
  */
  @Override
  void drawSymbol(Graphics2D canvas, int size){
    canvas.fillRect(0, 0, size, size);
  }
}
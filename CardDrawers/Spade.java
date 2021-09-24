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
  void drawSymbol(Graphics2D canvas, int size){
    
    
    
  }
}


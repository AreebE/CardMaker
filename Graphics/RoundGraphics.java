import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class RoundGraphics {
  public static void drawRound(Card a){
    DrawingPanel dp = new DrawingPanel(650, 500);
    Color customColor = new Color(0,102,0);
    dp.setBackground(customColor);
    Graphics2D canvas = dp.getGraphics();
    //canvas.setColor(Color.BLUE); 
    CardDrawer.drawCard(canvas, 10, 240, 1, a);
    
  }

  //instead of drawing full table just draw player cards, pot and the cards on the table

}
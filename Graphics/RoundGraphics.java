import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class RoundGraphics {
  public static DrawingPanel dp = new DrawingPanel(650, 450);
  public static void drawRound(Card a, Card b, boolean confirmed, int pot, int currentCards, Card[] cardsOnTable){
    Graphics2D canvas = dp.getGraphics();
    Color customColor = new Color(0,102,0);
    dp.setBackground(customColor);
      if(confirmed == true){
      drawsPlayerHand(canvas, a, b, pot, currentCards, cardsOnTable);
      }
      else{
      drawsFullTable();
      }
    
  }

  public static void drawsFullTable(){

  }

  public static void drawsPlayerHand(Graphics2D canvas, Card a, Card b, int pot, int currentCards, Card[] cardsOnTable){
    canvas.setColor(Color.WHITE);
    canvas.fillRect(0,0, 125, 35);
    canvas.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    String potNum = String.valueOf(pot);
    canvas.setColor(Color.BLACK);
    canvas.drawString("POT: " + potNum , 25, 25);
    //drawString("abc", 25, 25); for pot
    
    CardDrawer.drawCard(canvas, 155, 190, 1, a);
    CardDrawer.drawCard(canvas, 335, 190, 1, b);

    drawsCardsOnTable(canvas, currentCards, cardsOnTable);
    
    //right now pot num is overlaping
  }

  public static void drawsCardsOnTable(Graphics2D canvas, int currentCards, Card[] cardsOnTable){
    String[] cards = new String[5];
    canvas.setColor(Color.BLUE);

    //gets suites and vals of the table cards
    Util.Suit suite1 = cardsOnTable[0].getSuit();
    Util.Suit suite2 = cardsOnTable[1].getSuit();
    Util.Suit suite3 = cardsOnTable[2].getSuit();
    Util.Suit suite4 = cardsOnTable[3].getSuit();
    Util.Suit suite5 = cardsOnTable[4].getSuit();
    String card1 = Integer.toString(Util.getValue(cardsOnTable[0].getRank()));
    String card2 = Integer.toString(Util.getValue(cardsOnTable[1].getRank()));
    String card3 = Integer.toString(Util.getValue(cardsOnTable[2].getRank()));
    String card4 = Integer.toString(Util.getValue(cardsOnTable[3].getRank()));
    String card5 =  Integer.toString(Util.getValue(cardsOnTable[4].getRank()));

    if(currentCards == 0){
      for(int i = 0; i < 5; i++){
        canvas.fillRect(140, 10, 80, 110);
        canvas.fillRect(240, 10, 80, 110);
        canvas.fillRect(340, 10, 80, 110);
        canvas.fillRect(440, 10, 80, 110);
        canvas.fillRect(540, 10, 80, 110);
      }
    }
    else if(currentCards == 3){

    }
    else if(currentCards == 4){

    }
    else{
      
    }
  }

}
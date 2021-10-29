import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

//TODO- rotate text and optimatze

public class RoundGraphics {
  public static DrawingPanel dp = new DrawingPanel(650, 450);
  public static void drawRound(Card a, Card b, boolean confirmed, int pot, int currentCards, Card[] cardsOnTable){
    
    Graphics2D canvas = dp.getGraphics();
    Color customColor = new Color(0,102,0);
    dp.setBackground(customColor);
    AffineTransform oldConditions = canvas.getTransform();
      if(confirmed == true){
      drawsPlayerHand(canvas, a, b, pot, currentCards, cardsOnTable);
      }
      else{
      drawsFullTable();
      }
    canvas.setTransform(oldConditions);
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
    
  }

  public static void drawsCardsOnTable(Graphics2D canvas, int currentCards, Card[] cardsOnTable){
    String[] cardsNums = new String[5];
    Util.Suit[] suits = new Util.Suit[5];
    AffineTransform oldConditions = canvas.getTransform();

     for(int i = 0; i < 5; i++){
       suits[i] = cardsOnTable[i].getSuit();
     }

     for(int i = 0; i < 5; i++){
       cardsNums[i] = Integer.toString(Util.getValue(cardsOnTable[i].getRank()));
     }
      
      //draws card backgrounds 
      int x = 140;
      for(int i = 0; i < 5; i++){
        if(i < currentCards){
          canvas.setColor(Color.WHITE);
        }
        else{
          canvas.setColor(Color.BLUE);
        }
        canvas.fillRect(x, 10, 80, 100);
        x += 100;
      }

        int numX = 140;
        for(int j = 0; j < currentCards; j++){
          String val = cardsNums[j];
          drawsCardVals(val, canvas, numX);
          numX += 100;
        }

        canvas.translate(160, 40);
        for(int k = 0; k < currentCards; k++){
          drawsSuit(canvas, suits[k]);
          canvas.translate(100, 0);
        }
        canvas.setTransform(oldConditions);
      }
    
     // canvas.drawString(card1 , 180, 25);
      //canvas.drawString(card2, 280, 25);
     // canvas.drawString(card3, 380, 25);

     // canvas.translate(160, 60);
     // drawsSuit(canvas, suite1);
     // canvas.translate(100, 0);
     // drawsSuit(canvas, suite2);

    
  


  public static void drawsSuit(Graphics2D canvas, Util.Suit suite){
    String suit = suite.toString();
    if(suit == "SPADES"){
      Spade sp = new Spade();
      sp.drawSymbol(canvas, 40);
    }
    else if(suit == "HEARTS"){
      Heart h = new Heart();
      h.drawSymbol(canvas, 40);
    }
    else if(suit == "CLUBS"){
      Club c = new Club();
      c.drawSymbol(canvas, 40); 
    }
    else{
      Diamond d = new Diamond();
      d.drawSymbol(canvas, 40);
    }
  }

  public static void drawsCardVals(String cardVal, Graphics2D canvas, int x){
    canvas.setFont(new Font("TimesRoman", Font.PLAIN, 10));
    canvas.setColor(Color.BLACK);
    int toCheck = Integer.parseInt(cardVal);
    if(toCheck > 10){
      if(toCheck == 11) cardVal = "J";
      else if(toCheck == 12) cardVal = "Q";
      else cardVal = "K";
    }
    if(toCheck == 10){
      canvas.drawString(cardVal, x+5, 20 );
      canvas.drawString(cardVal, x + 65, 105);
    }
    else{
      canvas.drawString(cardVal, x+10, 20);
      canvas.drawString(cardVal, x+65, 105);
    }
  }

}
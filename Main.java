// Areeb Emran & Moira Clancy
// 9 - 17 - 2021 to 9 - 24 - 2021
// Period 2
// A2b : Playing cards 
// areeb & mo
/*
 * The main goal of this assignment was to be able to draw all cards in a full deck.
 * There are four suits, Club, Diamond, Heart, and Spade
 * There are 13 values, which are Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, 
 * Queen, and King 
 * 
 * Not much more is needed to be said about this assignment, other than 
 * how we each contributed, but that was mentioned in the planning document 
*/

/* Sources:
* https://docs.oracle.com/javase/7/docs/api/java/awt/geom/AffineTransform.html
* https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java
* https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html
* https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
*/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;
import java.util.HashSet;
class Main {
  public static void main(String[] args) {
    // System.out.println("Hello world!");
    DrawingPanel drawingPanel = new DrawingPanel(1000, 800);
    drawingPanel.setBackground(Color.GRAY);
    Scanner text = new Scanner(System.in);
    Graphics2D canvas = drawingPanel.getGraphics();
    // canvas.translate(50, 50);
    // canvas.rotate(Math.PI / 4);
    Deck deck = new Deck();
    // for (Card c: deck){
      // CardDrawer.drawCard(canvas, 10, 10, 1, c);
      // text.next();
    // }
    HashSet<Card> allCards = new HashSet<>();
    
    // for (int i = 0; i < Deck.numOfCards; i++){
      // Card c = deck.drawCard();
      // System.out.println(c);
      // allCards.add(c);
    // }
    // System.out.println(allCards.size());
// =======
    // Card[] deck = Deck.getRandomizedDeck();
    // String[] players = Player.getListOfPlayers();
    // for (int i = 0; i < 52; i++)
    // {
      // CardDrawer.drawCard(canvas, 10, 10, 1, deck.drawCard());
      // text.next();
      // System.out.println(i);
    // }

    HandTester.testMethods();

    // new Game();
  }
}
public class Deck {
  private Card[][] deck;
  public Deck(){
    deck = new Card[4][13];
    for (int i = 0; i < 4; i++){
      Card.Suit suit = null;
      switch(i){
        case 0:
          suit = Card.Suit.CLUB;
          break;
        case 1:
          suit = Card.Suit.DIAMOND;
          break;
        case 2:
          suit = Card.Suit.HEART;
          break;
        case 3:
          suit = Card.Suit.SPADE;
          break;
      }
      for (int j = 1; j <= 13; j++){
        deck[i][j - 1] = new Card(j, suit);
      }
    }
  }

  

}
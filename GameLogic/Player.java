
import java.lang.Comparable;

public class Player implements Comparable<Player>{
  private int chips;
  private int betChips;
  private String name;
  private boolean folded;
  private boolean called;
  private Card[] cards;
  private Hand bestHand;

  public Player(int startingChips, String name){
    this.chips = startingChips;
    this.betChips = 0;
    this.name = name;
    this.folded = false;
    this.called = false;
    this.cards = new Card[2];
    this.bestHand = null;
  }

  /*
   * This resets all of the current conditions of the player,
   * for when a new round starts
  */
  public void startNewRound(){
    this.called = false;
    this.folded = chips == 0;
    this.bestHand = null;
    this.betChips = 0;
  }
  /*
   * This sets the card the player has.
   *
   * @param c   the other card 
  */
  public void setCards(Card first, Card second){
    this.cards[0] = first;
    this.cards[1] = second;
  }

  /*
   * @return the card the player has
  */
  public Card getCard(int index){
    return cards[index];
  }

  /*
   * This sets how many chips the player would have
  */  
  public void setChips(int startingCount){
    chips = startingCount;
  }
  
  /*
   * This allows the player to win chips if they win the pot
  */
  public void gainChips(int chipsGained){
    chips += chipsGained;
  }

  /*
   * This allows the player to bet chips. An exception is thrown 
   * if there are too many chips bet.
  */
  public void betChips(int chipsBetThisTurn) throws TooManyChipsBet{
    if (chips < chipsBetThisTurn){
      betChips += chips;
      int holder = chips;
      chips = 0;
      throw new TooManyChipsBet(holder);
    }
    betChips += chipsBetThisTurn;
    chips -= chipsBetThisTurn;
  }

  // The rest of these are getters and setters. The names are self-explanatory.
  public int getChips(){
    return chips;
  }

  public void setBestHand(Hand bestHand){
    this.bestHand = bestHand;
  }

  public Hand getBestHand(){
    return bestHand;
  }

  public String getName(){
    return name;
  }

  public void setFolded(boolean isFolding){
    this.folded = isFolding;
  }

  public boolean hasFolded(){
    return folded;
  }

  public void setCalled(boolean isCalling){
    this.called = isCalling;
  }

  public boolean hasCalled(){
    return called;
  }

  public int compareTwoCards(Player other){
    Card otherCard = other.getCard(0);
    return cards[0].compareTo(otherCard);
  }

  public int compareHands(Player other){
    Hand otherBest = other.getBestHand();
    return this.bestHand.compareTo(otherBest);
  }

  @Override
  public int compareTo(Player other){
    return this.chips - other.getChips();
  }

  public int getBetChips(){
    return betChips;
  }
}
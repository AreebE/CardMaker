import java.util.HashMap;

public class Util {
  public enum Suit {
    SPADES, DIAMONDS, HEARTS, CLUBS
  }
  
  public static final int CARDS_ON_TABLE = 7;
  
  public static final int ROYAL_FLUSH = 10;
  public static final int STRAIGHT_FLUSH = 9;
  public static final int FOUR_OF_A_KIND = 8;
  public static final int FULL_HOUSE = 7;
  public static final int FLUSH = 6;
  public static final int STRAIGHT = 5;
  public static final int THREE_OF_A_KIND = 4;
  public static final int TWO_PAIR = 3;
  public static final int ONE_PAIR = 2;
  public static final int HIGH_CARD = 1;


  public static enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
  }
  public static final int ACE = 1;
  public static final int TWO = 2;
  public static final int THREE = 3;
  public static final int FOUR = 4;
  public static final int FIVE = 5;
  public static final int SIX = 6;
  public static final int SEVEN = 7;
  public static final int EIGHT = 8;
  public static final int NINE = 9;
  public static final int TEN = 10;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE_HIGH = 14;

  public static final char ACE_CHAR = 'A';
  public static final char KING_CHAR = 'K';
  public static final char QUEEN_CHAR = 'Q';
  public static final char JACK_CHAR = 'J';
  public static final char TEN_CHAR = 'T';
  public static final char NINE_CHAR = '9';
  public static final char EIGHT_CHAR = '8';
  public static final char SEVEN_CHAR = '7';
  public static final char SIX_CHAR = '6';
  public static final char FIVE_CHAR = '5';
  public static final char FOUR_CHAR = '4';
  public static final char THREE_CHAR = '3';
  public static final char TWO_CHAR = '2';

  // private static final HashMap<Character, Integer> charToValue = new HashMap<>{

  // };

  private static HashMap<Rank, Integer> ranksToValues = new HashMap<>(){{
      put(Rank.ACE, 14);
      put(Rank.TWO, 2);
      put(Rank.THREE, 3);
      put(Rank.FOUR, 4);
      put(Rank.FIVE, 5);
      put(Rank.SIX, 6);
      put(Rank.SEVEN, 7);
      put(Rank.EIGHT, 8);
      put(Rank.NINE,9);
      put(Rank.TEN, 10);
      put(Rank.JACK, 11);
      put(Rank.QUEEN, 12);
      put(Rank.KING, 13);
  }};
  
  public static int getValue(Rank rank){
    return ranksToValues.get(rank);
  }

  
  private static HashMap<Integer, Rank> valuesToRanks = new HashMap<>(){{
    put(1, Rank.ACE);
    put(2, Rank.TWO);
    put(3, Rank.THREE);
    put(4, Rank.FOUR);
    put(5, Rank.FIVE);
    put(6, Rank.SIX);
    put(7, Rank.SEVEN);
    put(8, Rank.EIGHT);
    put(9, Rank.NINE);
    put(10, Rank.TEN);
    put(11, Rank.JACK);
    put(12, Rank.QUEEN);
    put(13, Rank.KING);
  }};

  public static Rank getRank(int value){
    return valuesToRanks.get(value);
  }

  private static Suit[] suits = new Suit[]{
    Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES
  };

  public static Suit getSuit(int index){
    return suits[index];
  } 

  public static int decipherCardValue(char card){
    switch (card){
      case KING_CHAR:
        return KING;
      case QUEEN_CHAR:
        return QUEEN;
      case JACK_CHAR:
        return JACK;
      case ACE_CHAR:
        return ACE_HIGH;
      case TWO_CHAR:
        return TWO;
      case THREE_CHAR:
        return THREE;
      case FOUR_CHAR:
        return FOUR;
      case FIVE_CHAR:
        return FIVE;
      case SIX_CHAR:
        return SIX;
      case SEVEN_CHAR:
        return SEVEN;
      case EIGHT_CHAR:
        return EIGHT;
      case NINE_CHAR:
        return NINE;
      case TEN_CHAR:
        return TEN;
    }
    return -1;
    // Model if new cards needed to be added:
    /*
      case Util.x_CHAR:
        return Util.x;
    */ 
  }

  public static char translateValueToChar(int value){
    switch (value){
      case KING:
        return KING_CHAR;
      case QUEEN:
        return QUEEN_CHAR;
      case JACK:
        return JACK_CHAR;
      case ACE_HIGH:
      case ACE:
        return ACE_CHAR;
      case TWO:
        return TWO_CHAR;
      case THREE:
        return THREE_CHAR;
      case FOUR:
        return FOUR_CHAR;
      case FIVE:
        return FIVE_CHAR;
      case SIX:
        return SIX_CHAR;
      case SEVEN:
        return SEVEN_CHAR;
      case EIGHT:
        return EIGHT_CHAR;
      case NINE:
        return NINE_CHAR;
      case TEN:
        return TEN_CHAR;
    }
    return 'N';
  }

  public static int interpretValue(int value){
    if (value == ACE){
      return ACE_HIGH;
    }
    return value;
  }
  
  public static final int HAND_SIZE = 5;

  public static void sort(int[] values, int start){
    sort(values, start, values.length);
  }

  public static void sort(int[] values, int start, int end){
    for (int i = start; i < end; i++){
      int indexOfLargest = i;
      for (int j = i + 1; j < end; j++){
        if (values[indexOfLargest] < values[j])
          indexOfLargest = j;
      }
      int holder = values[i];
      values[i] = values[indexOfLargest];
      values[indexOfLargest] = holder;
    }
  }

  public static void reverseArray(Object[] values){
    for (int i = 0; i < values.length / 2; i++){
      Object holder = values[i];
      values[i] = values[values.length - 1];
      values[values.length - 1] = holder;
    }
  }
  

  public static final String EMPTY_SPACE = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

}
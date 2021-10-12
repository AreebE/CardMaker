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

  private static final HashMap<Character, Integer> charToValue = new HashMap<>(){{
    put('A', ACE_HIGH);
    put('2', TWO);
    put('3', THREE);
    put('4', FOUR);
    put('5', FIVE);
    put('6', SIX);
    put('7', SEVEN);
    put('8', EIGHT);
    put('9', NINE);
    put('T', TEN);
    put('J', JACK);
    put('Q', QUEEN);
    put('K', KING);
  }};

  public static int getValue(char c){
    return charToValue.get(c);
  }

  private static final HashMap<Integer, Character> valueToChar = new HashMap<>(){{
    put(ACE_HIGH, 'A');
    put(ACE, 'A');
    put(TWO, '2');
    put(THREE, '3');
    put(FOUR, '4');
    put(FIVE, '5');
    put(SIX, '6');
    put(SEVEN, '7');
    put(EIGHT, '8');
    put(NINE, '9');
    put(TEN, 'T');
    put(JACK, 'J');
    put(QUEEN, 'Q');
    put(KING, 'K');
  }};

  public static char getChar(int value){
    return valueToChar.get(value);
  }

  private static HashMap<Rank, Integer> ranksToValues = new HashMap<>(){{
      put(Rank.ACE, ACE_HIGH);
      put(Rank.TWO, TWO);
      put(Rank.THREE, THREE);
      put(Rank.FOUR, FOUR);
      put(Rank.FIVE, FIVE);
      put(Rank.SIX, SIX);
      put(Rank.SEVEN, SEVEN);
      put(Rank.EIGHT, EIGHT);
      put(Rank.NINE, NINE);
      put(Rank.TEN, TEN);
      put(Rank.JACK, JACK);
      put(Rank.QUEEN, QUEEN);
      put(Rank.KING, KING);
  }};
  
  public static int getValue(Rank rank){
    return ranksToValues.get(rank);
  }

  
  private static HashMap<Integer, Rank> valuesToRanks = new HashMap<>(){{
    put(ACE, Rank.ACE);
    put(TWO, Rank.TWO);
    put(THREE, Rank.THREE);
    put(FOUR, Rank.FOUR);
    put(FIVE, Rank.FIVE);
    put(SIX, Rank.SIX);
    put(SEVEN, Rank.SEVEN);
    put(EIGHT, Rank.EIGHT);
    put(NINE, Rank.NINE);
    put(TEN, Rank.TEN);
    put(JACK, Rank.JACK);
    put(QUEEN, Rank.QUEEN);
    put(KING, Rank.KING);
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
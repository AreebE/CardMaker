import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;

public class HandDecider {
  
  private static final int HAND_SIZE = 5;

  public static Hand getBestHand(Card[] cardsOnTable){
    HashSet<Card> currentCards = new HashSet<>(); 
    for (int i = 1; i <= Util.HAND_SIZE; i++){
      currentCards.add(cardsOnTable[Util.CARDS_ON_TABLE - i]);
    }
    // System.out.println(currentCards);
    Hand bestHand = getHand(currentCards.toArray(new Card[Util.HAND_SIZE]));

    for (int i = 0; i < cardsOnTable.length - 1; i++){
      currentCards.remove(cardsOnTable[i]);
      for (int j = i + 1; j < cardsOnTable.length; j++){
        // System.out.println(currentCards);
        if (currentCards.remove(cardsOnTable[j])){
          if (j == i + 1)
            currentCards.add(cardsOnTable[cardsOnTable.length - 1]);
          else
            currentCards.add(cardsOnTable[j-1]);
        }
        // System.out.println(i + " " + j);
        Hand currentHand = getHand(currentCards.toArray(new Card[Util.HAND_SIZE]));
        if (bestHand.compareTo(currentHand) < 0){
          bestHand = currentHand;
        }
      }
      currentCards.add(cardsOnTable[i]);
    }
    return bestHand;
  }

    
  public static Hand getHand(Card[] hand){
    HashSet<Util.Suit> suits = new HashSet<>();
    HashSet<Integer> values = new HashSet<>();
    HashMap<Integer, Integer> frequenciesOfValues = new HashMap<>();

    for (Card c: hand){
      suits.add(c.getSuit());
      int value = Util.getValue(c.getRank());
      values.add(value);
      if (frequenciesOfValues.containsKey(value)){
        int currentAmountOfTimes = frequenciesOfValues.get(value);
        frequenciesOfValues.put(value, currentAmountOfTimes + 1);
      }
      else {
        frequenciesOfValues.put(value, 1);
      }
    }

    int[] frequencies = new int[HAND_SIZE];
    Iterator<Integer> allValues = values.iterator();
    while (allValues.hasNext()){
      int val = allValues.next();
      frequencies[frequenciesOfValues.get(val)]++;
    } 
    // System.out.println(suits);
    // System.out.println(values);
    // System.out.println(Arrays.toString(frequencies));
    // return 0;
    int type = getHandType(suits, values, frequencies);
    return createHand(type, hand);
  }

  /*
  */
  private static int getHandType(HashSet<Util.Suit> suits, HashSet<Integer> values, int[] frequencies){
    if (isRoyalFlush(suits, values)) 
      return Util.ROYAL_FLUSH;
    else if (isStraightFlush(suits, values)) 
      return Util.STRAIGHT_FLUSH;
    else if (isFourOfAKind(frequencies)) 
      return Util.FOUR_OF_A_KIND;
    else if (isFullHouse(frequencies)) 
      return Util.FULL_HOUSE;
    else if (isFlush(suits)) 
      return Util.FLUSH;
    else if (isStraight(values)) 
      return Util.STRAIGHT;
    else if (isThreeOfAKind(frequencies)) 
      return Util.THREE_OF_A_KIND;
    else if (isTwoPair(frequencies)) 
      return Util.TWO_PAIR;
    else if (isOnePair(frequencies)) 
      return Util.ONE_PAIR;
    return Util.HIGH_CARD;
  }

  private static Hand createHand(int type, Card[] hand){
    switch (type){
      case Util.ROYAL_FLUSH:
        return new RoyalFlush(hand);
      case Util.STRAIGHT_FLUSH:
        return new StraightFlush(hand);
      case Util.FOUR_OF_A_KIND:
        return new FourOfAKind(hand);
      case Util.FULL_HOUSE:
        return new FullHouse(hand);
      case Util.FLUSH:
        return new Flush(hand);
      case Util.STRAIGHT:
        return new Straight(hand);
      case Util.THREE_OF_A_KIND:
        return new ThreeOfAKind(hand);
      case Util.TWO_PAIR:
        return new TwoPair(hand);
      case Util.ONE_PAIR:
        return new OnePair(hand);
      default:
        return new HighCard(hand);
    }

  }

  private static boolean isRoyalFlush(HashSet<Util.Suit> suits, HashSet<Integer> values){
    if (suits.size() == 1 && values.size() == HAND_SIZE){
      return hasRoyals(values);
    }
    return false;
  }

  private static boolean isStraightFlush(HashSet<Util.Suit> suits, HashSet<Integer> values){
    if (suits.size() == 1 && values.size() == HAND_SIZE){
      return hasConsecutive(values);
    }
    return false;
  }

  private static boolean isFourOfAKind(int[] frequencies){
    return frequencies[4] == 1;
  }

  private static boolean isFullHouse(int[] frequencies){
    return frequencies[3] == 1 && frequencies[2] == 1;
  }

  private static boolean isFlush(HashSet<Util.Suit> suits){
    return suits.size() == 1;
  }

  private static boolean isStraight(HashSet<Integer> values){
    return hasRoyals(values) || hasConsecutive(values);
  }

  private static boolean isThreeOfAKind(int[] frequencies){
    return frequencies[3] == 1;  
  }

  private static boolean isTwoPair(int[] frequencies){
    return frequencies[2] == 2; 
  }

  private static boolean isOnePair(int[] frequencies){
    return frequencies[2] == 1;
  }

  private static boolean hasConsecutive(HashSet<Integer> values){
    int lowestValue = Util.ACE;
      while (!values.contains(lowestValue)) lowestValue++;

      for (int i = lowestValue + 1; i < lowestValue + HAND_SIZE; i++){
        if (!values.contains(i))
          return lowestValue == Util.TWO && i - 1 == Util.FIVE && values.contains(Util.ACE_HIGH);
      }
      return true;
  }

  private static boolean hasRoyals(HashSet<Integer> values){
    for (int i = Util.TEN; i <= Util.KING; i++){
      if (!values.contains(i))
        return false;
    }
    return values.contains(Util.getValue(Util.Rank.ACE));
  }
}
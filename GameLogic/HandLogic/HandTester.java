import java.util.ArrayList;
import java.util.Collections;

public class HandTester {
  public static void testMethods() {

    // System.out.println("Hello world!");

    // Royal Flushes 
    Card[] royalFlush1 = new Card[] {
      new Card(Util.Rank.JACK, Util.Suit.HEARTS),
      new Card(Util.Rank.TEN, Util.Suit.HEARTS),
      new Card(Util.Rank.QUEEN, Util.Suit.HEARTS),
      new Card(Util.Rank.ACE, Util.Suit.HEARTS),
      new Card(Util.Rank.KING, Util.Suit.HEARTS)
    };

    Card[] royalFlush2 = new Card[] {
      new Card(Util.Rank.JACK, Util.Suit.SPADES),
      new Card(Util.Rank.TEN, Util.Suit.SPADES),
      new Card(Util.Rank.QUEEN, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.SPADES),
      new Card(Util.Rank.KING, Util.Suit.SPADES)
    };

    // Straight Flushes
    Card[] straightFlush1 = new Card[] {
      new Card(Util.Rank.JACK, Util.Suit.CLUBS),
      new Card(Util.Rank.TEN, Util.Suit.CLUBS),
      new Card(Util.Rank.QUEEN, Util.Suit.CLUBS),
      new Card(Util.Rank.NINE, Util.Suit.CLUBS),
      new Card(Util.Rank.KING, Util.Suit.CLUBS)
    };

    Card[] straightFlush2 = new Card[] {
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS)
    };

    Card[] straightFlush3 = new Card[] {
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS),
      new Card(Util.Rank.EIGHT, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS)
    };


    // Four of a kind
    Card[] fourKind3 = new Card[] {
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.SPADES),
      new Card(Util.Rank.SEVEN, Util.Suit.CLUBS),
      new Card(Util.Rank.SEVEN, Util.Suit.HEARTS),
      new Card(Util.Rank.KING, Util.Suit.DIAMONDS)
    };

    Card[] fourKind1 = new Card[] {
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.SPADES),
      new Card(Util.Rank.SEVEN, Util.Suit.CLUBS),
      new Card(Util.Rank.SEVEN, Util.Suit.HEARTS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS)
    };

    Card[] fourKind2 = new Card[] {
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.SPADES),
      new Card(Util.Rank.THREE, Util.Suit.CLUBS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };

    Card[] fourKind4 = new Card[] {
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.HEARTS),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };
    

    // Full houses
    Card[] fullHouse1 = new Card[] {
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.ACE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.CLUBS),
      new Card(Util.Rank.FOUR, Util.Suit.HEARTS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS)
    };

    Card[] fullHouse5 = new Card[] {
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.SPADES),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.FOUR, Util.Suit.HEARTS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS)
    };

    Card[] fullHouse4 = new Card[] {
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.SPADES),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS)
    };

    Card[] fullHouse2 = new Card[] {
      new Card(Util.Rank.KING, Util.Suit.DIAMONDS),
      new Card(Util.Rank.KING, Util.Suit.SPADES),
      new Card(Util.Rank.KING, Util.Suit.CLUBS),
      new Card(Util.Rank.QUEEN, Util.Suit.HEARTS),
      new Card(Util.Rank.QUEEN, Util.Suit.DIAMONDS)
    };

    Card[] fullHouse3 = new Card[] {
      new Card(Util.Rank.QUEEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.QUEEN, Util.Suit.SPADES),
      new Card(Util.Rank.QUEEN, Util.Suit.CLUBS),
      new Card(Util.Rank.ACE, Util.Suit.HEARTS),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };
    
    // Flushes
    Card[] flush1 = new Card[]{
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };

    Card[] flush2 = new Card[]{
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.FOUR, Util.Suit.CLUBS),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS)
    };
    
    Card[] flush3 = new Card[]{
      new Card(Util.Rank.KING, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };

    Card[] flush4 = new Card[]{
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };

    // Straights
    Card[] straight1 = new Card[]{
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS)
    };

    Card[] straight2 = new Card[]{
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.KING, Util.Suit.DIAMONDS),
      new Card(Util.Rank.QUEEN, Util.Suit.CLUBS),
      new Card(Util.Rank.JACK, Util.Suit.DIAMONDS)
    };

    Card[] straight3 = new Card[]{
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.EIGHT, Util.Suit.CLUBS),
      new Card(Util.Rank.NINE, Util.Suit.DIAMONDS)
    };

    // Three of a kind 
    Card[] threeKind1 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.FOUR, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.DIAMONDS)
    };

    Card[] threeKind2 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS)
    };

    Card[] threeKind3 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.TWO, Util.Suit.CLUBS),
      new Card(Util.Rank.THREE, Util.Suit.CLUBS),
      new Card(Util.Rank.SIX, Util.Suit.DIAMONDS)
    };

    Card[] threeKind4 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.THREE, Util.Suit.CLUBS),
      new Card(Util.Rank.ACE, Util.Suit.CLUBS),
      new Card(Util.Rank.JACK, Util.Suit.DIAMONDS)
    };

    Card[] threeKind5 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.THREE, Util.Suit.CLUBS),
      new Card(Util.Rank.KING, Util.Suit.CLUBS),
      new Card(Util.Rank.JACK, Util.Suit.DIAMONDS)
    };

    // Two pairs
    Card[] twoPair1 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

     Card[] twoPair2 = new Card[]{
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.ACE, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.SIX, Util.Suit.SPADES),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS)
    };

     Card[] twoPair3 = new Card[]{
      new Card(Util.Rank.KING, Util.Suit.DIAMONDS),
      new Card(Util.Rank.KING, Util.Suit.HEARTS),
      new Card(Util.Rank.ACE, Util.Suit.CLUBS),
      new Card(Util.Rank.ACE, Util.Suit.SPADES),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS)
    };
    
     Card[] twoPair4 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS)
    };

     Card[] twoPair5 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.FIVE, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };

    // One pair
    Card[] onePair1 = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

    Card[] onePair2 = new Card[]{
      new Card(Util.Rank.TEN, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TEN, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.TWO, Util.Suit.DIAMONDS)
    };

    Card[] onePair3 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

    Card[] onePair4 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.THREE, Util.Suit.HEARTS),
      new Card(Util.Rank.SEVEN, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };
    
  // Highest

    Card[] highest1 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TWO, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };
    
    Card[] highest2 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.TEN, Util.Suit.HEARTS),
      new Card(Util.Rank.SIX, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

    Card[] highest3 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.NINE, Util.Suit.HEARTS),
      new Card(Util.Rank.FOUR, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

    Card[] highest4 = new Card[]{
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.NINE, Util.Suit.HEARTS),
      new Card(Util.Rank.TEN, Util.Suit.CLUBS),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.DIAMONDS)
    };

    // System.out.println(test.getClass() + "|" + test.getHandType());
    HandDecider maker = new HandDecider();

    

   
   
    Hand rflush1 = maker.getHand(royalFlush1);
    Hand rflush2 = maker.getHand(royalFlush2);
    Hand sflush1 = maker.getHand(straightFlush1);
    Hand sflush2 = maker.getHand(straightFlush2);
    Hand sflush3 = maker.getHand(straightFlush3);
    Hand fourk1 = maker.getHand(fourKind1);
    Hand fourk2 = maker.getHand(fourKind2);
    Hand fourk3 = maker.getHand(fourKind3);
    Hand fourk4 = maker.getHand(fourKind4);
    Hand full1 = maker.getHand(fullHouse1);
    Hand full2 = maker.getHand(fullHouse2);
    Hand full3 = maker.getHand(fullHouse3);
    Hand full4 = maker.getHand(fullHouse4);
    Hand full5 = maker.getHand(fullHouse5);
    Hand f1 = maker.getHand(flush1);
    Hand f2 = maker.getHand(flush2);
    Hand f3 = maker.getHand(flush3);
    Hand f4 = maker.getHand(flush4);
    Hand s1 = maker.getHand(straight1);
    Hand s2 = maker.getHand(straight2);
    Hand s3 = maker.getHand(straight3);
    Hand three1 = maker.getHand(threeKind1);
    Hand three2 = maker.getHand(threeKind2);
    Hand three3 = maker.getHand(threeKind3);
    Hand three4 = maker.getHand(threeKind4);
    Hand three5 = maker.getHand(threeKind5);
    Hand two1 = maker.getHand(twoPair1);
    Hand two2 = maker.getHand(twoPair2);
    Hand two3 = maker.getHand(twoPair3);
    Hand two4 = maker.getHand(twoPair4);
    Hand two5 = maker.getHand(twoPair5);
    Hand one1 = maker.getHand(onePair1);
    Hand one2 = maker.getHand(onePair2);
    Hand one3 = maker.getHand(onePair3);
    Hand one4 = maker.getHand(onePair4);
    Hand high1 = maker.getHand(highest1);
    Hand high2 = maker.getHand(highest2);
    Hand high3 = maker.getHand(highest3);
    Hand high4 = maker.getHand(highest4);


    ArrayList<Hand> testSorting = new ArrayList<>();
    testSorting.add(rflush1);
    testSorting.add(sflush1);
    testSorting.add(high1);
    testSorting.add(one1);
    testSorting.add(fourk1);
    testSorting.add(two1);
    testSorting.add(three1);
    testSorting.add(f1);
    testSorting.add(sflush2);
    testSorting.add(full1);
    testSorting.add(full2);
    testSorting.add(rflush2);
    testSorting.add(sflush3);
    testSorting.add(s2);
    testSorting.add(fourk2);
    testSorting.add(s1);
    testSorting.add(f2);
    testSorting.add(f3);
    testSorting.add(two2);
    testSorting.add(one2);
    testSorting.add(full3);
    testSorting.add(two3);
    testSorting.add(three2);
    testSorting.add(two4);
    testSorting.add(two5);
    testSorting.add(full4);
    testSorting.add(one3);
    testSorting.add(full5);
    testSorting.add(high2);
    testSorting.add(three3);
    testSorting.add(high3);
    testSorting.add(three4);
    testSorting.add(three5);
    testSorting.add(fourk3);
    testSorting.add(fourk4);
    testSorting.add(s3);
    testSorting.add(one4);
    testSorting.add(high4);  
    testSorting.add(f4);  

    // System.out.println(Hand.timesCalled);
    Collections.sort(testSorting);
    // System.out.println(hand[0]);
    // System.out.println(test.getCardsToCompare());
    for (Hand h: testSorting){
      System.out.println(h + "\n");
    }

    // Test hand 
    Card[] setOfCards = new Card[]{
      new Card(Util.Rank.TWO, Util.Suit.SPADES),
      new Card(Util.Rank.ACE, Util.Suit.SPADES),
      new Card(Util.Rank.SIX, Util.Suit.SPADES),
      new Card(Util.Rank.THREE, Util.Suit.DIAMONDS),
      new Card(Util.Rank.FOUR, Util.Suit.SPADES),
      new Card(Util.Rank.FIVE, Util.Suit.SPADES),
      new Card(Util.Rank.SEVEN, Util.Suit.DIAMONDS)
    };
    Hand h = maker.getBestHand(setOfCards);

        // System.out.println(Hand.timesCalled);

    // System.out.println(h);
    // System.out.println("\n\n\n\n" + testSorting);
  }
}
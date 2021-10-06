import java.util.ArrayList;
import java.util.Collections;

public class HandTester {
  public static void testMethods() {

    // System.out.println("Hello world!");

    // Royal Flushes 
    Card[] royalFlush1 = new Card[] {
      new Card(11, Util.Suit.HEART),
      new Card(10, Util.Suit.HEART),
      new Card(12, Util.Suit.HEART),
      new Card(1, Util.Suit.HEART),
      new Card(13, Util.Suit.HEART)
    };

    Card[] royalFlush2 = new Card[] {
      new Card(11, Util.Suit.SPADE),
      new Card(10, Util.Suit.SPADE),
      new Card(12, Util.Suit.SPADE),
      new Card(1, Util.Suit.SPADE),
      new Card(13, Util.Suit.SPADE)
    };

    // Straight Flushes
    Card[] straightFlush1 = new Card[] {
      new Card(11, Util.Suit.CLUB),
      new Card(10, Util.Suit. CLUB),
      new Card(12, Util.Suit.CLUB),
      new Card(9, Util.Suit.CLUB),
      new Card(13, Util.Suit.CLUB)
    };

    Card[] straightFlush2 = new Card[] {
      new Card(1, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.DIAMOND),
      new Card(5, Util.Suit.DIAMOND)
    };

    Card[] straightFlush3 = new Card[] {
      new Card(7, Util.Suit.DIAMOND),
      new Card(6, Util.Suit.DIAMOND),
      new Card(8, Util.Suit.DIAMOND),
      new Card(5, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.DIAMOND)
    };


    // Four of a kind
    Card[] fourKind3 = new Card[] {
      new Card(7, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.SPADE),
      new Card(7, Util.Suit.CLUB),
      new Card(7, Util.Suit.HEART),
      new Card(13, Util.Suit.DIAMOND)
    };

    Card[] fourKind1 = new Card[] {
      new Card(7, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.SPADE),
      new Card(7, Util.Suit.CLUB),
      new Card(7, Util.Suit.HEART),
      new Card(4, Util.Suit.DIAMOND)
    };

    Card[] fourKind2 = new Card[] {
      new Card(3, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.SPADE),
      new Card(3, Util.Suit.CLUB),
      new Card(3, Util.Suit.HEART),
      new Card(7, Util.Suit.DIAMOND)
    };

    Card[] fourKind4 = new Card[] {
      new Card(5, Util.Suit.DIAMOND),
      new Card(5, Util.Suit.SPADE),
      new Card(5, Util.Suit.CLUB),
      new Card(5, Util.Suit.HEART),
      new Card(1, Util.Suit.DIAMOND)
    };
    

    // Full houses
    Card[] fullHouse1 = new Card[] {
      new Card(1, Util.Suit.DIAMOND),
      new Card(1, Util.Suit.SPADE),
      new Card(1, Util.Suit.CLUB),
      new Card(4, Util.Suit.HEART),
      new Card(4, Util.Suit.DIAMOND)
    };

    Card[] fullHouse5 = new Card[] {
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.SPADE),
      new Card(2, Util.Suit.CLUB),
      new Card(4, Util.Suit.HEART),
      new Card(4, Util.Suit.DIAMOND)
    };

    Card[] fullHouse4 = new Card[] {
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.SPADE),
      new Card(2, Util.Suit.CLUB),
      new Card(3, Util.Suit.HEART),
      new Card(3, Util.Suit.DIAMOND)
    };

    Card[] fullHouse2 = new Card[] {
      new Card(13, Util.Suit.DIAMOND),
      new Card(13, Util.Suit.SPADE),
      new Card(13, Util.Suit.CLUB),
      new Card(12, Util.Suit.HEART),
      new Card(12, Util.Suit.DIAMOND)
    };

    Card[] fullHouse3 = new Card[] {
      new Card(12, Util.Suit.DIAMOND),
      new Card(12, Util.Suit.SPADE),
      new Card(12, Util.Suit.CLUB),
      new Card(1, Util.Suit.HEART),
      new Card(1, Util.Suit.DIAMOND)
    };
    
    // Flushes
    Card[] flush1 = new Card[]{
      new Card(1, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.DIAMOND),
      new Card(6, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.DIAMOND)
    };

    Card[] flush2 = new Card[]{
      new Card(5, Util.Suit.CLUB),
      new Card(4, Util.Suit.CLUB),
      new Card(2, Util.Suit.CLUB),
      new Card(6, Util.Suit.CLUB),
      new Card(6, Util.Suit.CLUB)
    };
    
    Card[] flush3 = new Card[]{
      new Card(13, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.DIAMOND),
      new Card(6, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.DIAMOND)
    };

    Card[] flush4 = new Card[]{
      new Card(1, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.DIAMOND),
      new Card(6, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.DIAMOND)
    };

    // Straights
    Card[] straight1 = new Card[]{
      new Card(1, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.CLUB),
      new Card(5, Util.Suit.DIAMOND)
    };

    Card[] straight2 = new Card[]{
      new Card(1, Util.Suit.DIAMOND),
      new Card(10, Util.Suit.DIAMOND),
      new Card(13, Util.Suit.DIAMOND),
      new Card(12, Util.Suit.CLUB),
      new Card(11, Util.Suit.DIAMOND)
    };

    Card[] straight3 = new Card[]{
      new Card(5, Util.Suit.DIAMOND),
      new Card(6, Util.Suit.DIAMOND),
      new Card(7, Util.Suit.DIAMOND),
      new Card(8, Util.Suit.CLUB),
      new Card(9, Util.Suit.DIAMOND)
    };

    // Three of a kind 
    Card[] threeKind1 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(2, Util.Suit.CLUB),
      new Card(4, Util.Suit.CLUB),
      new Card(5, Util.Suit.DIAMOND)
    };

    Card[] threeKind2 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(2, Util.Suit.CLUB),
      new Card(5, Util.Suit.CLUB),
      new Card(6, Util.Suit.DIAMOND)
    };

    Card[] threeKind3 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(2, Util.Suit.CLUB),
      new Card(3, Util.Suit.CLUB),
      new Card(6, Util.Suit.DIAMOND)
    };

    Card[] threeKind4 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.HEART),
      new Card(3, Util.Suit.CLUB),
      new Card(1, Util.Suit.CLUB),
      new Card(11, Util.Suit.DIAMOND)
    };

    Card[] threeKind5 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.HEART),
      new Card(3, Util.Suit.CLUB),
      new Card(13, Util.Suit.CLUB),
      new Card(11, Util.Suit.DIAMOND)
    };

    // Two pairs
    Card[] twoPair1 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(5, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };

     Card[] twoPair2 = new Card[]{
      new Card(1, Util.Suit.DIAMOND),
      new Card(1, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(6, Util.Suit.SPADE),
      new Card(3, Util.Suit.DIAMOND)
    };

     Card[] twoPair3 = new Card[]{
      new Card(13, Util.Suit.DIAMOND),
      new Card(13, Util.Suit.HEART),
      new Card(1, Util.Suit.CLUB),
      new Card(1, Util.Suit.SPADE),
      new Card(2, Util.Suit.DIAMOND)
    };
    
     Card[] twoPair4 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(5, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(3, Util.Suit.DIAMOND)
    };

     Card[] twoPair5 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(5, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(7, Util.Suit.DIAMOND)
    };

    // One pair
    Card[] onePair1 = new Card[]{
      new Card(2, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };

    Card[] onePair2 = new Card[]{
      new Card(10, Util.Suit.DIAMOND),
      new Card(10, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(2, Util.Suit.DIAMOND)
    };

    Card[] onePair3 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };

    Card[] onePair4 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(3, Util.Suit.HEART),
      new Card(7, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };
    
  // Highest

    Card[] highest1 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(2, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };
    
    Card[] highest2 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(10, Util.Suit.HEART),
      new Card(6, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };

    Card[] highest3 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(9, Util.Suit.HEART),
      new Card(4, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
    };

    Card[] highest4 = new Card[]{
      new Card(3, Util.Suit.DIAMOND),
      new Card(9, Util.Suit.HEART),
      new Card(10, Util.Suit.CLUB),
      new Card(5, Util.Suit.SPADE),
      new Card(1, Util.Suit.DIAMOND)
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
    // Collections.sort(testSorting);
    // System.out.println(hand[0]);
    // System.out.println(test.getCardsToCompare());
    // for (Hand h: testSorting){
      // System.out.println(h + "\n");
    // }

    // Test hand 
    Card[] setOfCards = new Card[]{
      new Card(2, Util.Suit.SPADE),
      new Card(1, Util.Suit.SPADE),
      new Card(6, Util.Suit.SPADE),
      new Card(3, Util.Suit.DIAMOND),
      new Card(4, Util.Suit.SPADE),
      new Card(5, Util.Suit.SPADE),
      new Card(7, Util.Suit.DIAMOND)
    };
    Hand h = maker.getBestHand(setOfCards);

        // System.out.println(Hand.timesCalled);

    // System.out.println(h);
    // System.out.println("\n\n\n\n" + testSorting);
  }
}